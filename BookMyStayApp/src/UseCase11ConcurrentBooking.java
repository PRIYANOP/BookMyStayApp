package src;

public class UseCase11ConcurrentBooking {

    public static void main(String[] args) {

        ConcurrentBookingProcessor processor = new ConcurrentBookingProcessor();

        // Create reservations
        Reservation r1 = new Reservation("SI-101", "Priyan", "Single");
        Reservation r2 = new Reservation("SI-102", "Arun", "Single");
        Reservation r3 = new Reservation("SI-103", "Kiran", "Single");
        Reservation r4 = new Reservation("DO-201", "Rahul", "Double");

        // Create threads (simulate multiple users)
        Thread t1 = new Thread(new BookingTask(processor, r1), "Thread-1");
        Thread t2 = new Thread(new BookingTask(processor, r2), "Thread-2");
        Thread t3 = new Thread(new BookingTask(processor, r3), "Thread-3");
        Thread t4 = new Thread(new BookingTask(processor, r4), "Thread-4");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Final state
        processor.displayInventory();
    }
}