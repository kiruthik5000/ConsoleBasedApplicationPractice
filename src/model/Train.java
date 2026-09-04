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

    public List<Station> getRoute() {
        return route;
    }

    public void setRoute(List<Station> route) {
        this.route = route;
    }

    private String trainName;
    private List<Station> route;

    public Train(int trainNo, String trainName, List<Station> stations) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.route = List.copyOf(stations);
    }



    public int getSeralizeableUID() {
        return this.seralizeableUID;
    }
}
