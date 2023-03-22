package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CinemaTest {

    CinemaDTO myCinema = new CinemaDTO("1", "Cinema City", "info@cinemacity.com", "Main Street", 100, "Bucharest");

    @Test
    void test_constructor(){
        CinemaDTO cinema = new CinemaDTO("10", "Cinema Test", "info@cinemacity.com", "Flowers Street", 100, "Cluj");
        Assertions.assertEquals("10", cinema.getId());
        Assertions.assertEquals("Cinema Test", cinema.getName());
        Assertions.assertEquals("info@cinemacity.com", cinema.getEmail());
        Assertions.assertEquals("Flowers Street", cinema.getStreet());
        Assertions.assertEquals(100, cinema.getNumber());
        Assertions.assertEquals("Cluj", cinema.getCity());
    }
    
    @Test
    void test_get_id() { Assertions.assertEquals("1", myCinema.getId());}

    
    @Test
    void test_get_name(){
        Assertions.assertSame("Cinema City", myCinema.getName());
    }

    @Test
    void test_get_email(){
        Assertions.assertSame("info@cinemacity.com", myCinema.getEmail());
    }

    @Test
    void test_get_street(){
        Assertions.assertSame("Main Street", myCinema.getStreet());
    }

    @Test
    void test_get_number(){
        Assertions.assertSame(100, myCinema.getNumber());
    }

    @Test
    void test_get_city(){
        Assertions.assertSame("Bucharest", myCinema.getCity());
    }

    @Test
    void test_set_id() {
        CinemaDTO newCinema = new CinemaDTO();
        newCinema.setId("10");
        Assertions.assertEquals("10", newCinema.getId());
    }

    @Test
    void test_set_name() {
        CinemaDTO newCinema = new CinemaDTO();
        newCinema.setName("Skyline Cinema");
        Assertions.assertEquals("Skyline Cinema", newCinema.getName());
    }

}
