public abstract class Passenger extends User {

    protected String passportNumber;
    protected String phoneNumber;

    public Passenger(
            int userId,
            String name,
            String email,
            String password,
            String passportNumber,
            String phoneNumber) {

        super(userId, name, email, password);

        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }

    public void viewBookings(BookingManager other) {

        System.out.println("Bookings for passenger " + name);

        for (Booking booking : other.getBookings()) {

            String b = booking.getPassenger().getPassportNumber();

            if (this.passportNumber.equals(b)) {
                booking.displayInfo();
            }
        }

    }

    public void cancelBooking(BookingManager other, String bookingId) {

        System.out.println("Canceling booking for passenger " + name);

        for (Booking booking : other.getBookings()) {
            String b = booking.getPassenger().getPassportNumber();

            if (this.passportNumber.equals(b) && bookingId.equals(booking.getBookingId())) {
                booking.displayInfo();
                booking.cancelBooking(bookingId);
                System.out.println("Booking has been cancelled successfully.");
                return;
            }
        }
        System.out.println("No Bookings for passenger " + name + " have this BookingId: " + bookingId);
    }

    public abstract void displayInfo();

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
