package model;

import java.time.LocalDate;
import java.util.List;

public class TrainSchedule {
    private int trainNo;
    private LocalDate journeyDate;
    private List<SeatAvailability> availableSeats;

    public TrainSchedule(int trainNo, LocalDate journeyDate, List<SeatAvailability> availableSeats) {
        this.trainNo = trainNo;
        this.journeyDate = journeyDate;
        this.availableSeats = availableSeats;
    }

    public List<SeatAvailability> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<SeatAvailability> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public int getTrain() {
        return trainNo;
    }

    public void setTrain(int trainNo) {
        this.trainNo = trainNo;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("---- Train Details ----\n");
        sb.append("Train No: ").append(this.trainNo).append("\n");
        sb.append("Available Seats:\n");

        for (SeatAvailability sa : this.availableSeats) {
            sb.append(sa).append("\n");
        }
        return sb.toString();
    }
}
