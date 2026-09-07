package Utils;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner s = new Scanner(System.in);
    public static int getNumericValue(String label) throws NumberFormatException{
            while (true) {

                System.out.print(label);

                try {
                    int value = Integer.parseInt(s.nextLine());

                    if (value < 0) {
                        throw new IllegalArgumentException("Invalid number provided");
                    }

                    return value;

                } catch (NumberFormatException e) {

                    System.out.println("Invalid input. Please enter a valid number.");

                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage());
                }
            }
        }

    public static String getStringValue(String label) {
        while(true) {
            System.out.println(label);
            try {
                String value = s.nextLine();
                if (value.trim().isEmpty()) throw new IllegalArgumentException("Please provide valid value");
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        InputHandler.getNumericValue("Enter the age: \n");
        InputHandler.getStringValue("Enter the name: \n");
    }
}
