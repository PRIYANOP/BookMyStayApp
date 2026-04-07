package src;

import java.util.*;

public class UseCase12PersistenceRecovery {

    public static void main(String[] args) {

        PersistenceService service = new PersistenceService();

        List<Reservation> history;
        Map<String, Integer> inventory;

        // 🔁 Try loading existing data
        Object[] data = service.loadData();

        if (data != null) {
            history = (List<Reservation>) data[0];
            inventory = (Map<String, Integer>) data[1];
        } else {
            // 🆕 Fresh start
            history = new ArrayList<>();
            inventory = new HashMap<>();

            inventory.put("Single", 2);
            inventory.put("Double", 1);
            inventory.put("Suite", 1);
        }

        // 📌 Add new booking
        Reservation r1 = new Reservation("SI-101", "Priyan", "Single");
        history.add(r1);
        inventory.put("Single", inventory.get("Single") - 1);

        System.out.println("\nCurrent Bookings:");
        for (Reservation r : history) {
            r.displayReservation();
        }

        System.out.println("\nCurrent Inventory: " + inventory);

        // 💾 Save state before exit
        service.saveData(history, inventory);
    }
}