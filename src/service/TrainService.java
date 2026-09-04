package service;

import model.Station;
import model.Train;
import repository.TrainRepository;

import java.util.*;

public class TrainService {
    private final TrainRepository trainRepository;
    private static final Scanner s = new Scanner(System.in);
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> getAllTrains() {
        return trainRepository.getAllTrains();
    }

    public void bookTicket(int trainNo) {
        Train train = trainRepository.getTrain(trainNo);
        int from = getFromStation(train.getRoute());
        int to = getToStation(train.getRoute(), from);
        System.out.println("Successfully Booked Train Ticket");
        String PNR = String.valueOf(generatePnr());
        System.out.println("Train No: "+trainNo);
        System.out.println("Train Name: "+train.getTrainName());
        System.out.println("PNR: "+PNR);
        System.out.println("From : "+train.getRoute().get(from));
        System.out.println("To : "+train.getRoute().get(to));
    }
    private long generatePnr() {
        return new Random().nextLong(10000000, 99999999);
    }
    private int getFromStation(List<Station> allStations) {
        List< Station> availableBoardingStations = allStations.stream().limit(allStations.size() - 1).toList();
        System.out.println("Enter the boarding Station: ");
        return printStations(availableBoardingStations) - 1;
    }
    private int getToStation(List<Station> allStations, int fromStation) {
        List<Station> availableEndingStations = allStations.stream().skip((long) fromStation + 1).toList();
        System.out.println("Enter the departure Station: ");
        return fromStation + printStations(availableEndingStations);
    }

    private int printStations(List<Station> availableEndingStations) {
        for (int i=0; i<availableEndingStations.size(); i++) {
            System.out.println(i + 1+". "+availableEndingStations.get(i));
        }
        int selectedStation = Integer.parseInt(s.nextLine());
        if (selectedStation < 0 || selectedStation > availableEndingStations.size()) {
            System.out.println("Error Invalid Station Selected");
            return -1;
        }
        return selectedStation;
    }

    public static void main(String[] args) {
        TrainRepository tr = new TrainRepository();
        TrainService ts = new TrainService(tr);
        ts.bookTicket(101);
    }
}
