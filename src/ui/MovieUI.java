package ui;

import Utils.InputHandler;

import java.util.*;

public class MovieUI {
    private final Set<String> bookings = new HashSet<>();
    private final List<Character> rows = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
    private final List<Integer> columns = List.of(1, 2, 3, 4, 5);

    public void start() {
        while (true) {
            System.out.println("1. Show Tickets");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Exit");

            int choice = InputHandler.getNumericValue("Enter your option");

            switch (choice) {
                case 1:
                    showTickets();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    cancelTickets();
                    break;
                default:
                    return;
            }
        }
    }

    public void cancelTickets() {
        String input = InputHandler.getStringValue("Enter the seat number separated by comma eg: [A1,B1]");
        List<String> seats = validate(input);
        if (seats == null) {
            System.out.println("Error No Seat Specified");
            return;
        }
        for (String s : seats) {
            if (!bookings.contains(s)) {
                System.out.println("Error Invalid Seat Specified");
            } else {
                bookings.remove(s);
            }
        }
        System.out.println("Seats canceled successfully");
    }

    public void showTickets() {
        System.out.println("\t\tscreen\t\t");
        System.out.println("\t ------------- \t");
        for (int i : columns) System.out.print(" \t"+i);
        System.out.println();
        for (Character row : rows) {
            System.out.print(row + "\t");
            for (Integer column : columns) {
                String curSeat = "" + row + column;
                if (bookings.contains(curSeat)) {
                    System.out.print("-");
                } else {
                    System.out.print("*");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void bookTicket() {
        try {
            showTickets();
            String userInput = InputHandler.getStringValue("Enter the seat number separated by comma eg: [A1,B1]");
            List<String> validInput = validate(userInput);

            if (validInput == null || validInput.isEmpty()) {
                System.out.println("Invalid input");
                return;
            }
            for (String s : validInput) {
                if (bookings.contains(s)) {
                    System.out.println("Seat Already Booked");
                    return;
                }
            }
            bookings.addAll(validInput);
            System.out.println("Tickets Booked Successfully.");
        }catch (Exception e) {
            System.out.println("Error Occurred "+e.getMessage());
        }
    }
    private List<String> validate(String input) {
        String[] res = input.split(",");

        String pattern = "^[A-H]([1-9]|[1-9][0-9])$";
        List<String> result = new ArrayList<>();
        for (String s : res) {
            String lot = s.trim();
            int seatNumber;
            try {
                seatNumber = Integer.parseInt(lot.substring(1));
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
           if (!lot.matches(pattern) || seatNumber > 5) {
               return null;
           }
           result.add(lot);
        }
        return result;
    }
}
