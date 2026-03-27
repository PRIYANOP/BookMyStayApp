package src;
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Domain objects (Room definitions)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Store rooms in array (for iteration)
        Room[] rooms = { single, doubleRoom, suite };

        // Centralized inventory (state)
        RoomInventory inventory = new RoomInventory();

        // Search service (read-only)
        RoomSearchService searchService = new RoomSearchService();

        // Perform search (no modification happens)
        searchService.searchAvailableRooms(rooms, inventory);
    }
}