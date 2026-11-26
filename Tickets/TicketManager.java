package Project;

import java.util.ArrayList;
import java.util.UUID;

public class TicketManager {
    private final ArrayList <Ticket> tickets = new ArrayList<>();

    public Ticket generateTicket(Booking booking) {
        if (booking == null || booking.getFlight() == null || booking.getSeat() == null) {
            throw new IllegalArgumentException("Booking, flight, and seat must not be null");
        }

        Ticket existing = findTicketByBooking(booking);
        if (existing != null) {
            if(existing.getStatus() != TicketStatus.CANCELLED) {
                return existing;
            }
            tickets.remove(existing);
        }

        String ticketId = "TKT-" + UUID.randomUUID();
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
        /*  to read the latest booking of a ticket in case of having multiple tickets with the same booking */
        for (int i = tickets.size() - 1; i >= 0; i--) {
            Ticket t = tickets.get(i);
            if (t.getBooking().equals(booking)) {   //equals requires overriding it in Booking
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
