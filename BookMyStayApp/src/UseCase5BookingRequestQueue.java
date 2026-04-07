package src;

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Initialize booking queue
        BookingQueue bookingQueue = new BookingQueue();

        // Simulating guest booking requests (arrival order matters)
        Reservation r1 = new Reservation("SI-101", "Priyan", "Single");
        Reservation r2 = new Reservation("DO-202", "Arun", "Double");
        Reservation r3 = new Reservation("SU-301", "meena", "Single");
        Reservation r4 = new Reservation("DO-203", "mala", "Double");

        // Add requests to queue (FIFO order)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        bookingQueue.addRequest(r4);

        // Display queue (no processing yet)
        bookingQueue.displayQueue();
    }
}