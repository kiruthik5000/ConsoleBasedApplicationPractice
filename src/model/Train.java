package model;

import java.util.*;
import java.io.Serializable;

public class Train implements Serializable {
    private final int seralizeableUID = 1;

    private int trainNo;

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Set<Station> getRoute() {
        return route;
    }

    public void setRoute(LinkedHashSet<Station> route) {
        this.route = route;
    }

    private String trainName;
    private Set<Station> route;

    public Train(int trainNo, String trainName, Set<Station> stations) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.route = stations;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("Train No: " + trainNo + "\nTrain Name: " + trainName + "\n Route:\n");
        for (Station s : route) {
           value.append("\t* - ").append(s.name()+"\n");
        }
        return value.toString();
    }
    public int getSeralizeableUID() {
        return this.seralizeableUID;
    }
}
