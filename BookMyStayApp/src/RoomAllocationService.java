package src;

import java.util.*;

class RoomAllocationService {

    // Track allocated room IDs per room type
    private Map<String, Set<String>> allocatedRooms;

    // Global set to ensure uniqueness
    private Set<String> allAllocatedRoomIds;

    public RoomAllocationService() {
        allocatedRooms = new HashMap<>();
        allAllocatedRoomIds = new HashSet<>();
    }

    // Process booking requests
    public void processBookings(BookingQueue bookingQueue, RoomInventory inventory) {

        System.out.println("=== Processing Booking Requests ===\n");

        Queue<Reservation> queue = bookingQueue.getQueue();

        while (!queue.isEmpty()) {

            Reservation request = queue.poll(); // FIFO
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Ensure uniqueness
                while (allAllocatedRoomIds.contains(roomId)) {
                    roomId = generateRoomId(roomType);
                }

                // Store allocation
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                allocatedRooms.get(roomType).add(roomId);
                allAllocatedRoomIds.add(roomId);

                // Update inventory immediately
                inventory.updateAvailability(roomType, available - 1);

                // Confirm booking
                System.out.println("Booking Confirmed!");
                System.out.println("Guest: " + request.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Allocated Room ID: " + roomId);
                System.out.println();

            } else {
                System.out.println("Booking Failed (No Availability)");
                System.out.println("Guest: " + request.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println();
            }
        }
    }

    // Simple unique ID generator
    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + (int)(Math.random() * 1000);
    }
}