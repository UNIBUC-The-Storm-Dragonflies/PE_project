package ro.unibuc.hello.dto;
import ro.unibuc.hello.data.Cinema;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class CinemaTest {

    CinemaDTO myCinema = new CinemaDTO("1", "Cinema City", "info@cinemacity.com", "Main Street", 100, "Bucharest");
    Cinema cinema = new Cinema("1", "Cinema City", "info@cinemacity.com", "Main Street", 100, "Bucharest");
    Boolean hasId = true;

    @Test
    public void test_constructor(){
        CinemaDTO cinemaDTO = new CinemaDTO();
    }

    @Test
    void test_constructor1(){
        CinemaDTO cinema = new CinemaDTO("10", "Cinema Test", "info@cinemacity.com", "Flowers Street", 100, "Cluj");
        Assertions.assertEquals("10", cinema.getId());
        Assertions.assertEquals("Cinema Test", cinema.getName());
        Assertions.assertEquals("info@cinemacity.com", cinema.getEmail());
        Assertions.assertEquals("Flowers Street", cinema.getStreet());
        Assertions.assertEquals(100, cinema.getNumber());
        Assertions.assertEquals("Cluj", cinema.getCity());
    }

    @Test
    void test_constructor2(){
        CinemaDTO newCinema = new CinemaDTO(cinema);

        Assertions.assertEquals(newCinema.getId(), cinema.getId());
        Assertions.assertEquals(newCinema.getName(), cinema.getName());
        Assertions.assertEquals(newCinema.getEmail(), cinema.getEmail());
        Assertions.assertEquals(newCinema.getStreet(), cinema.getStreet());
        Assertions.assertEquals(newCinema.getNumber(), cinema.getNumber());
        Assertions.assertEquals(newCinema.getCity(), cinema.getCity());
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

    @Test
    void test_to_cinema(){
      Cinema cinemaTest = new Cinema();
      cinemaTest = myCinema.toCinema(hasId);

      Assertions.assertEquals(myCinema.getId(), cinemaTest.getId());
      Assertions.assertEquals(myCinema.getName(), cinemaTest.getName());
      Assertions.assertEquals(myCinema.getEmail(), cinemaTest.getEmail());
      Assertions.assertEquals(myCinema.getStreet(), cinemaTest.getStreet());
      Assertions.assertEquals(myCinema.getNumber(), cinemaTest.getNumber());
      Assertions.assertEquals(myCinema.getCity(), cinemaTest.getCity());
    }

    @Test
    void test_to_string(){
        CinemaDTO newCinema = new CinemaDTO("1", "Cinema City", "info@cinemacity.com", "Main Street", 100, "Bucharest");
        String expectedCinema = "Cinema{" + 
            "id='" + "1" + '\'' +
            ", name='" + "Cinema City" + '\'' + 
            ", email='" + "info@cinemacity.com" + '\'' +
            ", street='" + "Main Street" + '\'' +
            ", number='" + Integer.toString(100) + '\'' +
            ", city='" + "Bucharest" + '}';

        Assertions.assertEquals(expectedCinema, newCinema.toString());
    }

}
