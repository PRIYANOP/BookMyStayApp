package src;
public class UseCase8BookingHistoryReporting {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        Reservation r1 = new Reservation("SI-101", "Priyan", "Single");
        Reservation r2 = new Reservation("DO-202", "Arun", "Double");
        Reservation r3 = new Reservation("SU-301", "Kiran", "Suite");

        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        history.displayHistory();

        BookingReportService report = new BookingReportService();
        report.generateReport(history.getAllReservations());
    }
}