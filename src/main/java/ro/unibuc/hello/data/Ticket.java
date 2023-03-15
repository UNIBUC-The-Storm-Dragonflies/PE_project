package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Tickets")
public class Ticket {
    @Id
    private String id;

    private int seat;

//    constructors
    public Ticket() {}

    public Ticket(int seat) {
        this.seat = seat;
    }

//    getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

//    toString
    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", seat=" + seat +
                '}';
    }
}
