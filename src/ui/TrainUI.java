package ui;

import Utils.InputHandler;
import model.Train;
import service.TrainService;

import java.util.List;

public class TrainUI {
    private final TrainService trainService;

    public TrainUI(TrainService trainService) {
        this.trainService = trainService;
    }
    public void start() {
        do {
            System.out.println("----- Train Ticket Booking ----\n");
            System.out.println("1. View all Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Add Train");
            System.out.println("4. Search Train");
            System.out.println("5. Check Seat Availability");
            System.out.println("6. Exit");

            int choice = InputHandler.getNumericValue("Enter the choice:\n");
            switch (choice) {
                case 1:
                    getTrains();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    addTrain();
                    break;
                case 4:
                    searchTrain();
                    break;
                case 5:
                    getSeatAvailability();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Option.");
                    break;
            }
        } while (true);
    }

    private void getSeatAvailability() {
        try {
            trainService.getSetAvailability();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void getTrains() {
        List<Train> trains = trainService.getAllTrains();
        for (Train t : trains) {
            System.out.println(t.toString());
        }
    }

    public void bookTicket() {
        trainService.bookTicket();
    }
    public void addTrain() {
        try {
            trainService.addTrain();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }

    public void searchTrain() {
        try {
            trainService.searchTrains();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}
