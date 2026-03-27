package src;

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        // Create Room objects (Polymorphism)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 10;
        int doubleAvailable = 5;
        int suiteAvailable = 2;

        // Display details
        System.out.println("=== Hotel Room Availability ===\n");

        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
        System.out.println();
    }
}