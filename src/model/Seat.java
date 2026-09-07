package model;

public class Seat {
    private int seatNo;
    private SeatClass seatClass;

    public Seat(int seatNo, SeatClass seatClass) {
        this.seatNo = seatNo;
        this.seatClass = seatClass;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }
    @Override
    public String toString() {
        return "SeatNo: "+this.seatNo+"\t Seat Class: "+this.seatClass.name();
    }
}
