package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.Auditorium;
public class AuditoriumDTO {
    private String id;
    private String name;
    private String seatNumber;

    public AuditoriumDTO(String id, String name, String seatNumber) {
        this.id = id;
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public AuditoriumDTO(Auditorium auditorium) {
        this.id = auditorium.getId();
        this.name = auditorium.getName();
        this.seatNumber = auditorium.getSeatNumber();
    }

    @Override
    public String toString() {
        return "AuditoriumDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
