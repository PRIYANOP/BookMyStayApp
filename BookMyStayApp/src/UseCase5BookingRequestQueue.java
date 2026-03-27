package src;

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Initialize booking queue
        BookingQueue bookingQueue = new BookingQueue();

        // Simulating guest booking requests (arrival order matters)
        Reservation r1 = new Reservation("Priyan", "Single Room");
        Reservation r2 = new Reservation("Arun", "Double Room");
        Reservation r3 = new Reservation("Meena", "Suite Room");
        Reservation r4 = new Reservation("Karthik", "Single Room");

        // Add requests to queue (FIFO order)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        bookingQueue.addRequest(r4);

        // Display queue (no processing yet)
        bookingQueue.displayQueue();
    }
}