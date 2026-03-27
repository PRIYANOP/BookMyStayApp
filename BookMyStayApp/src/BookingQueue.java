package src;

import java.util.LinkedList;
import java.util.Queue;

class BookingQueue {

    private Queue<Reservation> queue;

    // Constructor
    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request (enqueue)
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added for: " + reservation.getGuestName());
    }

    // Display all requests (without removing)
    public void displayQueue() {
        System.out.println("\n=== Booking Request Queue ===");

        if (queue.isEmpty()) {
            System.out.println("No booking requests.");
            return;
        }

        for (Reservation r : queue) {
            r.displayReservation();
        }
    }

    // ✅ NEW METHOD (Required for Use Case 6)
    // Provides access to queue for processing (FIFO)
    public Queue<Reservation> getQueue() {
        return queue;
    }
}