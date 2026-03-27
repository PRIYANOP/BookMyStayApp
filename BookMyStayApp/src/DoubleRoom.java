package src;
class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 2500.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getType());
        System.out.println("Beds: " + getBeds());
        System.out.println("Price: ₹" + getPrice());
    }
}