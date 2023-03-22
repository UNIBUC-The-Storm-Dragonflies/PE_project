package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.Auditorium;

public class AuditoriumDTO {
    private String id;
    private String name;
    private String cinemaId;

    private int seatNumber;

    public AuditoriumDTO() {}

    public AuditoriumDTO(String id, String name, int seatNumber) {
        this.id = id;
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public AuditoriumDTO(Auditorium auditorium) {
        this.id = auditorium.getId();
        this.name = auditorium.getName();
        this.seatNumber = auditorium.getSeatNumber();
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
}
