package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.Auditorium;

import java.util.Objects;

public class AuditoriumDTO {
    private String id;
    private String name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditoriumDTO that = (AuditoriumDTO) o;
        return seatNumber == that.seatNumber && id.equals(that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, seatNumber);
    }
}
