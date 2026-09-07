package repository;

import model.Station;
import model.Train;
import java.util.*;

public class TrainRepository {

    Map<Integer, Train> trainMap;

    public TrainRepository() {
        trainMap = new HashMap<>();
        trainMap.put(101, new Train(101, "Chennai Exp", new LinkedHashSet<>(List.of(Station.CBE, Station.TPJ, Station.TJ, Station.KUM))));
        trainMap.put(102, new Train(102, "chemmozhi Exp", new LinkedHashSet<>(List.of(Station.KUM,Station.TJ, Station.TPJ, Station.CBE))));
    }

    // get methods
    public Train getTrain(int trainNo) {
        if (trainMap.containsKey(trainNo)) return trainMap.get(trainNo);
        return null;
    }

    public List<Train> getAllTrains() {
        return new ArrayList<>(trainMap.values());
    }
    public Set<Integer> getTrainNumbers() {
        return trainMap.keySet();
    }
    public void addTrain(Train train) {
        int trainNo = train.getTrainNo();
        trainMap.put(trainNo, train);
    }
    public List<Train> getTrainsByStation(Station station) {
        List<Train> selectedTrains = new ArrayList<>();
        for (Train t : getAllTrains()) {
            if (t.getRoute().isEmpty()) continue;
            if (t.getRoute().contains(station)) selectedTrains.add(t);
        }
        return selectedTrains;
    }
}
