package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.Auditorium;

public class AuditoriumCreationDTO{
    private String id;
    private String name;
    private int seatNumber;
    private String cinemaId;

    public AuditoriumCreationDTO(){}

    public AuditoriumCreationDTO(String name, int seatNumber, String cinemaId){
        this.name = name;
        this.seatNumber = seatNumber;
        this.cinemaId = cinemaId;
    }

    
    public AuditoriumCreationDTO(String id, String name, int seatNumber, String cinemaId){
        this.id = id;
        this.name = name;
        this.seatNumber = seatNumber;
        this.cinemaId = cinemaId;
    }

    public Auditorium toAuditorium(){
        Auditorium auditorium = new Auditorium();
        auditorium.setId(id);
        auditorium.setName(name);
        auditorium.setSeatNumber(seatNumber);
        
        return auditorium;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSeatNumber(){
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

    public String getCinemaId(){
        return cinemaId;
    }

    public void setCinemaId(String cinemaId){
        this.cinemaId = cinemaId;
    }
}