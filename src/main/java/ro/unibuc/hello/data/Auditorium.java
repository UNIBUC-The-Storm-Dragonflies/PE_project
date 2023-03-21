package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Auditoriums")
public class Auditorium {
    @Id
    private String id;
    private String name;
//    private String cinemaId;
    private int seatNumber;

    //    constructors
    public Auditorium() {}

    public Auditorium(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    //    getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    //    toString
    @Override
    public String toString() {
        return "Auditorium{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}