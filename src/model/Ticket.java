    package model;

    import java.time.LocalDate;

    public class Ticket {
        private String pnr;
        private int trainNo;
        private String trainName;
        private LocalDate travelDate;
        private Seat seat;
        private Station from;

        public String getPnr() {
            return pnr;
        }

        public void setPnr(String pnr) {
            this.pnr = pnr;
        }

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

        public LocalDate getTravelDate() {
            return travelDate;
        }

        public void setTravelDate(LocalDate travelDate) {
            this.travelDate = travelDate;
        }

        public Seat getSeat() {
            return seat;
        }

        public void setSeat(Seat seat) {
            this.seat = seat;
        }

        public Station getFrom() {
            return from;
        }

        public void setFrom(Station from) {
            this.from = from;
        }

        public Ticket(String pnr, int trainNo, String trainName, LocalDate travelDate, Seat seat, Station from, Station to) {
            this.pnr = pnr;
            this.trainNo = trainNo;
            this.trainName = trainName;
            this.travelDate = travelDate;
            this.seat = seat;
            this.from = from;
            this.to = to;
        }

        public Station getTo() {
            return to;
        }

        public void setTo(Station to) {
            this.to = to;
        }

        private Station to;
        @Override
        public String toString() {
            return "----- Ticket Details -----\n" +
                    "PNR         : " + pnr + "\n" +
                    "Train No    : " + trainNo + "\n" +
                    "Train Name  : " + trainName + "\n" +
                    "Travel Date : " + travelDate + "\n" +
                    "From        : " + from + "\n" +
                    "To          : " + to + "\n" +
                    "Seat        : " + seat.toString() + "\n" +
                    "--------------------------";
        }
    }
