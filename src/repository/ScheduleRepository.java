package repository;

import model.*;

import java.time.LocalDate;
import java.util.*;

public class ScheduleRepository {
    private final Map<LocalDate, List<TrainSchedule>> scheduleMap;
    public ScheduleRepository() {
        scheduleMap = new HashMap<>();

        scheduleMap.put(
                LocalDate.now(), List.of(new TrainSchedule(101, LocalDate.now(), List.of(new SeatAvailability(SeatClass.AC, 1, 0), new SeatAvailability(SeatClass.SL, 1, 0))),
                new TrainSchedule(102, LocalDate.now(), List.of(new SeatAvailability(SeatClass.AC, 1, 0), new SeatAvailability(SeatClass.SL, 1, 0)))));
    }
    public List<TrainSchedule> getTrainOn(LocalDate date) {
        try {
            if (!scheduleMap.containsKey(date)) throw new IllegalArgumentException("Error Invalid Date Provided");
            return scheduleMap.get(date);
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        return null;
    }

    public List<LocalDate> getWorkingDates() {
        return new ArrayList<>(scheduleMap.keySet());
    }
}
