package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Auditoriums")
public class Auditorium {
    @Id
    private String id;
    private String name;
    private String seatNumber;

//    constructors
    public Auditorium() {}

    public Auditorium(String name, String seatNumber) {
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
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
