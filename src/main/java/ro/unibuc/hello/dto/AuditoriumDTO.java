package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.Auditorium;
import ro.unibuc.hello.dto.CinemaDTO;
import java.util.List;

public class AuditoriumDTO {
    private String id;
    private String name;
    private String cinemaId;
    private CinemaDTO cinema;

    private int seatNumber;

    public AuditoriumDTO() {}

    public AuditoriumDTO(String id, String name, int seatNumber, String cinemaId) {
        this.id = id;
        this.name = name;
        this.seatNumber = seatNumber;
        this.cinemaId = cinemaId;
    }

    public AuditoriumDTO(Auditorium auditorium) {
        this.id = auditorium.getId();
        this.name = auditorium.getName();
        this.seatNumber = auditorium.getSeatNumber();
        this.cinema = new CinemaDTO (auditorium.getCinema());
    }

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

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public CinemaDTO getCinema(){
        return cinema;
    }

    public void setCinema(CinemaDTO cinema){
        this.cinema = cinema;
    }
}
