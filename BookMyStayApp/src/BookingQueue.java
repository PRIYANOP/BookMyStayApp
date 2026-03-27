package src;

import java.util.LinkedList;
import java.util.Queue;

class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request (enqueue)
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added for: " + reservation.getGuestName());
    }

    // View all requests (without removing)
    public void displayQueue() {
        System.out.println("\n=== Booking Request Queue ===");

        for (Reservation r : queue) {
            r.displayReservation();
        }
    }
}