package model;

public class SeatAvailability {
    private SeatClass seatClass;
    private int availability;
    private int booked;

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public SeatAvailability(SeatClass seatClass, int availability, int booked) {
        this.seatClass = seatClass;
        this.availability = availability;
        this.booked = booked;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    @Override
    public String toString() {
        return "SeatClass: "+seatClass.name()+" -> Available : "+(availability - booked);
    }
}
