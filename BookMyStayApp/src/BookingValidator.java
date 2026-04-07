package src;
class BookingValidator {

    // Validate reservation input
    public void validateReservation(Reservation reservation)
            throws InvalidBookingException {

        // Check null
        if (reservation == null) {
            throw new InvalidBookingException("Reservation cannot be null");
        }

        // Validate guest name
        if (reservation.getGuestName() == null || reservation.getGuestName().isEmpty()) {
            throw new InvalidBookingException("Guest name is required");
        }

        // Validate room type
        if (!isValidRoomType(reservation.getRoomType())) {
            throw new InvalidBookingException("Invalid room type selected");
        }
    }

    // Allowed room types
    private boolean isValidRoomType(String roomType) {
        return roomType.equals("Single") ||
                roomType.equals("Double") ||
                roomType.equals("Suite");
    }

    // Example: Inventory validation
    public void validateAvailability(int availableRooms)
            throws InvalidBookingException {

        if (availableRooms <= 0) {
            throw new InvalidBookingException("No rooms available");
        }
    }
}