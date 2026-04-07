package src;
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Example reservation IDs (from Use Case 6)
        String reservation1 = "SI-101";
        String reservation2 = "DO-202";

        // Initialize manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 200);
        AddOnService wifi = new AddOnService("WiFi", 100);
        AddOnService pickup = new AddOnService("Airport Pickup", 500);

        // Add services
        manager.addService(reservation1, breakfast);
        manager.addService(reservation1, wifi);
        manager.addService(reservation2, pickup);

        // Display services
        manager.displayServices(reservation1);
        manager.displayServices(reservation2);

        // Show total cost
        System.out.println("\nTotal Add-on Cost for " + reservation1 + ": ₹"
                + manager.calculateTotalCost(reservation1));

        System.out.println("Total Add-on Cost for " + reservation2 + ": ₹"
                + manager.calculateTotalCost(reservation2));
    }
}