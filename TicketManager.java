import java.util.ArrayList;

public class TicketManager {
    private final ArrayList <Ticket> tickets = new ArrayList<>();

    public Ticket generateTicket(Booking booking) {
        if (booking == null || booking.getFlight() == null || booking.getSeat() == null) {
            throw new IllegalArgumentException("Booking, flight, and seat must not be null");
        }
        String ticketId = "TKT-" + booking.getFlight().getFlightId() + "-" + booking.getSeat().getSeatNumber();
        Ticket newTicket = new Ticket(ticketId, booking);
        tickets.add(newTicket);
        return newTicket;
    }

    public Ticket findTicket(String ticketId) {
        if (ticketId == null) {
            return null;
        }
        for (Ticket t : tickets) {
            if (t.getTicketId().equals(ticketId)) {
                return t;
            }
        }
        return null;
    }

    public Ticket findTicketByBooking(Booking booking) {
        if(booking == null) {
            return null;
        }
        for (Ticket t : tickets) {
            if (t.getBooking().equals(booking)) {
                return t;
            }
        }
        return null;
    }

    public void cancelTicket(String ticketId) {
        Ticket ticket = findTicket(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found");
        }
        ticket.cancelTicket();
    }

    public void displayTicket(String ticketId) {
        Ticket ticket = findTicket(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found");
        }
        ticket.displayInfo();
    }
}
