package src;

import java.util.*;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        // 📦 Booking history (UC8 concept)
        List<Reservation> history = new ArrayList<>();

        // 🏨 Inventory (room type → count)
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);

        // ✅ Create reservations
        Reservation r1 = new Reservation("SI-101", "Priyan", "Single");
        Reservation r2 = new Reservation("DO-202", "Arun", "Double");

        // Add to history (simulate confirmed bookings)
        history.add(r1);
        history.add(r2);

        // Reduce inventory (simulate booking allocation)
        inventory.put("Single", inventory.get("Single") - 1);
        inventory.put("Double", inventory.get("Double") - 1);

        System.out.println("Initial Inventory: " + inventory);

        CancellationService service = new CancellationService();

        try {
            // ✅ Cancel valid booking
            service.cancelBooking("SI-101", history, inventory);

            // ❌ Cancel invalid booking
            service.cancelBooking("XX-999", history, inventory);

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 📊 Final state
        System.out.println("\nUpdated Inventory: " + inventory);

        System.out.println("\nRemaining Bookings:");
        for (Reservation r : history) {
            r.displayReservation();
        }

        service.displayRollbackStack();
    }
}