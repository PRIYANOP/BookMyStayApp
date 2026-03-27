package src;

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Reuse existing room classes
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // New centralized inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("=== Room Details with Availability ===\n");

        single.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(single.getType()));
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(doubleRoom.getType()));
        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(suite.getType()));
        System.out.println();

        // Show full inventory
        System.out.println();
        inventory.displayInventory();
    }
}