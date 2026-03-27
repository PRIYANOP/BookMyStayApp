package src;

class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 1500.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getType());
        System.out.println("Beds: " + getBeds());
        System.out.println("Price: ₹" + getPrice());
    }
}