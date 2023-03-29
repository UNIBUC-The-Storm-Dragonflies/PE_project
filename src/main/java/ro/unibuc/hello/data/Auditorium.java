package ro.unibuc.hello.data;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Auditoriums")
public class Auditorium {
    @Id
    private String id;
    private String name;
    private int seatNumber;

    @ReadOnlyProperty
    private List<String> moviesIds;

    @DBRef(lazy = true)
    Cinema cinema;


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

    public List<String> getMovieIds() {
        return moviesIds;
    }

    public Cinema getCinema(){
        return cinema;
    }

    public void setCinema(Cinema cinema){
        this.cinema = cinema;
        
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