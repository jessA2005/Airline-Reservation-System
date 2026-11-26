public class Ticket {
    private String ticketId;
    private TicketStatus status;
    private Booking booking;

public Ticket(String ticketId, Booking booking) {
    this.ticketId = ticketId;
    this.booking = booking;
    this.status = TicketStatus.VALID;
}

    public String getTicketId() {
        return ticketId;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Booking getBooking() {
        return booking;
    }

    public void cancelTicket() {
        if(status == TicketStatus.CANCELLED) {
            throw new IllegalStateException("Ticket is already cancelled");
        }
        this.status = TicketStatus.CANCELLED;
    }

    public void displayInfo() {
        System.out.println("ID: " + ticketId);
        System.out.println("Status: " + status);
        System.out.println("Booking: " + booking.toString());
    }
}
