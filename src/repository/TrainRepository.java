package repository;

import model.Station;
import model.Train;
import java.util.*;

public class TrainRepository {

    Map<Integer, Train> trainMap;

    public TrainRepository() {
        trainMap = new HashMap<>();
        trainMap.put(101, new Train(101, "chennai Exp", List.of(Station.CBE, Station.TPJ, Station.TJ, Station.KUM)));
        trainMap.put(102, new Train(102, "chemmozhi Exp", List.of(Station.KUM,Station.TJ, Station.TPJ, Station.CBE)));
    }

    // get methods
    public Train getTrain(int trainNo) {
        if (trainMap.containsKey(trainNo)) return trainMap.get(trainNo);
        return null;
    }

    public List<Train> getAllTrains() {
        return new ArrayList<>(trainMap.values());
    }
}
