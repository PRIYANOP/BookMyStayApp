package src;
import java.util.*;

class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    // Add reservation to history
    public void addReservation(Reservation reservation) {
        history.add(reservation);
        System.out.println("Added to history: " + reservation.getGuestName());
    }

    // Return all reservations
    public List<Reservation> getAllReservations() {
        return history;
    }

    // Display booking history
    public void displayHistory() {

        System.out.println("\n===== BOOKING HISTORY =====");

        if (history.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Reservation r : history) {
            r.displayReservation();
        }
    }
}