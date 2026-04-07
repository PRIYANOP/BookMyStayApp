package src;

import java.util.*;

class ConcurrentBookingProcessor {

    private Queue<Reservation> queue = new LinkedList<>();
    private Map<String, Integer> inventory = new HashMap<>();

    public ConcurrentBookingProcessor() {
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);
    }

    // Add request (synchronized)
    public synchronized void addBooking(Reservation reservation) {
        queue.offer(reservation);
        System.out.println(Thread.currentThread().getName() +
                " added booking: " + reservation.getReservationId());
    }

    // Process booking (critical section)
    public synchronized void processBooking() {

        if (queue.isEmpty()) {
            return;
        }

        Reservation r = queue.poll();
        String roomType = r.getRoomType();

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            inventory.put(roomType, available - 1);

            System.out.println(Thread.currentThread().getName() +
                    " SUCCESS → Allocated " + roomType +
                    " to " + r.getGuestName());
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED → No " + roomType + " rooms available");
        }
    }

    // Show final inventory
    public void displayInventory() {
        System.out.println("\nFinal Inventory: " + inventory);
    }
}