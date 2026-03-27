package src;

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize booking queue
        BookingQueue bookingQueue = new BookingQueue();

        // Add booking requests (FIFO order)
        bookingQueue.addRequest(new Reservation("Priyan", "Single Room"));
        bookingQueue.addRequest(new Reservation("Arun", "Double Room"));
        bookingQueue.addRequest(new Reservation("Meena", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Karthik", "Single Room"));
        bookingQueue.addRequest(new Reservation("Divya", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Ravi", "Suite Room")); // may fail if limit reached

        // Process bookings
        RoomAllocationService allocationService = new RoomAllocationService();
        allocationService.processBookings(bookingQueue, inventory);

        // Show updated inventory
        System.out.println("=== Updated Inventory ===");
        inventory.displayInventory();
    }
}