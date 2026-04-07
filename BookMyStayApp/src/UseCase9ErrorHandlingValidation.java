package src;

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        BookingValidator validator = new BookingValidator();

        // ✅ Valid reservation
        Reservation r1 = new Reservation("SI-101", "Priyan", "Single");

        // ❌ Invalid reservation (wrong room type)
        Reservation r2 = new Reservation("DO-202", "Arun", "Triple");

        // ❌ Invalid reservation (empty name)
        Reservation r3 = new Reservation("SU-301", "", "Suite");

        try {
            System.out.println("Validating r1...");
            validator.validateReservation(r1);
            System.out.println("r1 is valid ✅");

            System.out.println("\nValidating r2...");
            validator.validateReservation(r2);  // will fail

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nValidating r3...");
            validator.validateReservation(r3);  // will fail

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Inventory check example
        try {
            System.out.println("\nChecking room availability...");
            validator.validateAvailability(0); // invalid

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nSystem continues running safely ✅");
    }
}