package service;

import Utils.InputHandler;
import model.*;
import repository.ScheduleRepository;
import repository.TrainRepository;
import java.time.LocalDate;
import java.util.*;

public class TrainService {
    private final TrainRepository trainRepository;
    private final ScheduleRepository scheduleRepository;
    private static final Scanner s = new Scanner(System.in);
    public TrainService(TrainRepository trainRepository, ScheduleRepository scheduleRepository) {
        this.trainRepository = trainRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public List<Train> getAllTrains() {
        return trainRepository.getAllTrains();
    }
    private LocalDate getDate() {
        System.out.println("Enter the journey Date");
        List<LocalDate> workingDates = scheduleRepository.getWorkingDates();
        for (int i=0; i<workingDates.size(); i++) {
            System.out.println((i + 1)+". "+workingDates.get(i));
        }
        int index = InputHandler.getNumericValue("Enter the index of the date: ");
        if (index <= 0 || index > workingDates.size()) throw new IndexOutOfBoundsException("Invalid Index provided");
        return workingDates.get(index - 1);
    }
    public void bookTicket() {
        System.out.println("---- Welcome to Train Ticket Booking ----");
        try {
            LocalDate date = getDate();
            TrainSchedule trainSchedule = getTrain(date);
            Train train = trainRepository.getTrain(trainSchedule.getTrain());
            List<Station> route = new ArrayList<>(train.getRoute());
            int from = getFromStation(train.getRoute());
            int to = getToStation(train.getRoute(), from);
            Seat bookedSeat = getSeatBooking(trainSchedule);
            System.out.println("Successfully Booked Train Ticket");
            String PNR = String.valueOf(generatePnr());
            Ticket ticket = new Ticket(
                    PNR,
                    train.getTrainNo(),
                    train.getTrainName(),
                    date,
                    bookedSeat,
                    route.get(from),
                    route.get(to)
            );
            System.out.println(ticket);
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }

    private Seat getSeatBooking(TrainSchedule trainSchedule) {
        System.out.println("---- Select seats ----:");
        for (int i=0; i<trainSchedule.getAvailableSeats().size(); i++) {
            System.out.println((i+1)+". "+trainSchedule.getAvailableSeats().get(i));
        }
        int index = InputHandler.getNumericValue("Enter the seat option:\n");
        return getSelected(trainSchedule, index);
    }

    private static Seat getSelected(TrainSchedule trainSchedule, int index) {
        if (index <= 0 || index > trainSchedule.getAvailableSeats().size()) throw new IndexOutOfBoundsException("Invalid index selected");
        SeatAvailability availability = trainSchedule.getAvailableSeats().get(index - 1);
        System.out.println("Selected Seat Availability: "+availability.getAvailability()+"\n Selected Seat Booked: "+availability.getBooked());
        if ((availability.getAvailability() - availability.getBooked()) <= 0) throw new IllegalArgumentException("Cannot Select the seat.");
        availability.setBooked(availability.getBooked() + 1);
        Random rand = new Random();
        return new Seat(rand.nextInt(0, 100), trainSchedule.getAvailableSeats().get(index - 1).getSeatClass());
    }

    public void getSetAvailability() {
        List<Train> trains = trainRepository.getAllTrains();
        for (int i=0; i<trains.size(); i++) {
            System.out.println((i + 1)+". "+trains.get(i));
        }
        int trainIndex = InputHandler.getNumericValue("Enter the train number:\n");
        int trainNo = trains.get(trainIndex - 1).getTrainNo();
        List<LocalDate> dates = scheduleRepository.getWorkingDates();
        for (int i=0; i<dates.size(); i++) {
            System.out.println((i + 1)+". "+dates.get(i));
        }
        int journeyDateIndex = InputHandler.getNumericValue("Enter the Journey date:\n");
        LocalDate journeyDate = dates.get(journeyDateIndex - 1);

        TrainSchedule trainRunning =
                scheduleRepository.getTrainOn(journeyDate)
                        .stream()
                        .filter(x -> x.getTrain() == trainNo)
                        .findFirst()
                        .orElse(null);

        if (trainRunning == null || trainRunning.getAvailableSeats() == null) {
            System.out.println("No Trains Running on that Date.\n Please provide other dates");
            return;
        }
        for (SeatAvailability sa : trainRunning.getAvailableSeats()) {
            System.out.println("Available Seats on"+journeyDate);
            System.out.println(sa);
        }
    }

    private TrainSchedule getTrain(LocalDate date) {
        List<TrainSchedule> trains = scheduleRepository.getTrainOn(date);
        for (int i=0; i<trains.size(); i++) {
            System.out.println((i + 1)+". "+trains.get(i).toString());
        }
        int index = InputHandler.getNumericValue("Enter the train Number: ");
        if (index <= 0 || index > trains.size()) throw new IndexOutOfBoundsException("Invalid index specified.");
        return trains.get(index - 1);
    }
    private long generatePnr() {
        return new Random().nextLong(10000000, 99999999);
    }
    private int getFromStation(Set<Station> allStations) {
        List< Station> availableBoardingStations = allStations.stream().limit(allStations.size() - 1).toList();
        System.out.println("Enter the boarding Station: ");
        return printStations(new ArrayList<>(availableBoardingStations)) - 1;
    }
    private int getToStation(Set<Station> allStations, int fromStation) {
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

    public void addTrain() throws IllegalArgumentException{
        int trainNo = InputHandler.getNumericValue("Enter the TrainNo: \n");
        Set<Integer> trainNos = trainRepository.getTrainNumbers();
        if (trainNo < 0 || trainNo > 1000 || trainNos.contains(trainNo)) throw new IllegalArgumentException("Invalid Train No");
        String trainName = InputHandler.getStringValue("Enter the TrainName: \n");
        Set<Station> route = getStations();
        Train newTrain = new Train(trainNo, trainName, route);
        trainRepository.addTrain(newTrain);
        System.out.println(newTrain);
    }

    private Set<Station> getStations() {
        Set<Station> selected = new LinkedHashSet<>();
        while (true) {
            System.out.println("Select the stations: \n");
            int n = 1;
            for (Station station : Station.values()) {
                if (selected.contains(station)) continue;
                System.out.println(n+". "+station.name());
                n++;
            }
            System.out.println(n+". Finish");
            try {
                String valueObtained = InputHandler.getStringValue("Enter the value");
                if (valueObtained.equals("Finish")) break;
                Station selectedStation = Station.valueOf(valueObtained);
                selected.add(selectedStation);
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
        }
        return selected;
    }

    public void searchTrains() {
        System.out.println("Select from stations");
        for (Station station : Station.values()) {
            System.out.println("* "+station);
        }

        try {
            String selectedStation = InputHandler.getStringValue("Enter the station name");
            Station fromOrToStation = Station.valueOf(selectedStation);
            List<Train> trains = trainRepository.getTrainsByStation(fromOrToStation);
            System.out.println("Results for the selected station "+fromOrToStation+":\n");
            for (Train t : trains) {
                System.out.println(t);
            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}
