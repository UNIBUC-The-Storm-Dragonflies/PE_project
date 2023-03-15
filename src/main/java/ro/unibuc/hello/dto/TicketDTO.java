package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.Ticket;

public class TicketDTO {
    private String id;
    private int seat;

//    constructors
    public TicketDTO() {}

    public TicketDTO(String id, int seat) {
        this.id = id;
        this.seat = seat;
    }

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.seat = ticket.getSeat();
    }

//    toString
    @Override
    public String toString() {
        return "TicketDTO{" +
                "id='" + id + '\'' +
                ", seat=" + seat +
                '}';
    }
}
