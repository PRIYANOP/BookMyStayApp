package src;

class BookingTask implements Runnable {

    private ConcurrentBookingProcessor processor;
    private Reservation reservation;

    public BookingTask(ConcurrentBookingProcessor processor,
                       Reservation reservation) {
        this.processor = processor;
        this.reservation = reservation;
    }

    @Override
    public void run() {
        processor.addBooking(reservation);
        processor.processBooking();
    }
}