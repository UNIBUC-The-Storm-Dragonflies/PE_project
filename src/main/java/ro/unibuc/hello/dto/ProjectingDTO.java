package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.Projecting;

import java.util.Date;

public class ProjectingDTO {
    private String id;
    private String ticket_id;
    private String film_id;
    private Date date;

    public ProjectingDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getFilm_id() {
        return film_id;
    }

    public void setFilm_id(String film_id) {
        this.film_id = film_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProjectingDTO(Projecting projecting) {
        this.id = projecting.getId();
        this.ticket_id = projecting.getTicket_id();
        this.film_id = projecting.getFilm_id();
        this.date = projecting.getDate();
    }
}
