
package src;

class Reservation {

    private String reservationId;   // ✅ ADD THIS
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {   // ✅ ADD THIS
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room Type: " + roomType);
    }
}