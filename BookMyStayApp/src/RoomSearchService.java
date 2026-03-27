package src;

class RoomSearchService {

    // Read-only search method
    public void searchAvailableRooms(Room[] rooms, RoomInventory inventory) {

        System.out.println("=== Available Rooms ===\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getType());

            // Defensive check (filter unavailable rooms)
            if (available > 0) {
                room.displayRoomDetails();
                System.out.println("Available: " + available);
                System.out.println();
            }
        }
    }
}