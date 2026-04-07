package src;
import java.util.*;

class BookingReportService {

    public void generateReport(List<Reservation> reservations) {

        System.out.println("\n===== BOOKING REPORT =====");

        if (reservations.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        int totalBookings = reservations.size();

        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : reservations) {
            String type = r.getRoomType();
            roomTypeCount.put(type,
                    roomTypeCount.getOrDefault(type, 0) + 1);
        }

        System.out.println("Total Bookings: " + totalBookings);

        System.out.println("\nRoom Type Summary:");
        for (String type : roomTypeCount.keySet()) {
            System.out.println(type + " : " + roomTypeCount.get(type));
        }
    }
}