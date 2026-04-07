package src;
import java.util.*;

class CancellationService {

    private Stack<String> rollbackStack = new Stack<>();

    // Cancel booking
    public void cancelBooking(String reservationId,
                              List<Reservation> history,
                              Map<String, Integer> inventory)
            throws InvalidBookingException {

        Reservation target = null;

        // 🔍 Find reservation
        for (Reservation r : history) {
            if (r.getReservationId().equals(reservationId)) {
                target = r;
                break;
            }
        }

        // ❌ If not found
        if (target == null) {
            throw new InvalidBookingException("Reservation not found");
        }

        // 🔁 Rollback step 1: store ID in stack
        rollbackStack.push(target.getReservationId());

        // 🔁 Rollback step 2: restore inventory
        String roomType = target.getRoomType();
        inventory.put(roomType, inventory.getOrDefault(roomType, 0) + 1);

        // 🔁 Rollback step 3: remove from history
        history.remove(target);

        System.out.println("Cancellation successful for ID: " + reservationId);
    }

    // Show rollback stack
    public void displayRollbackStack() {
        System.out.println("\nRollback Stack (LIFO): " + rollbackStack);
    }
}