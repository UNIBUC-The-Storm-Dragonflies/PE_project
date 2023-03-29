package ro.unibuc.hello.service;

import ro.unibuc.hello.data.*;
import ro.unibuc.hello.dto.CinemaDTO;

import java.util.stream.Collectors;
import java.beans.Transient;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.*;


@SpringBootTest
@Tag("IT")
class CinemaServiceTestIT {

    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    CinemaService cinemaService;
    
    String cinemaId;
 
    @AfterEach
    void deleteActual(){
        if(cinemaId != null){
            cinemaRepository.deleteById(cinemaId);
        }
    }

    @Test
    void test_addCinema_returnsCinemaDTOwithInfo() {
        // Arrange
        CinemaDTO cinema = new CinemaDTO("Cinema 10", "cinema10@test.ro", "Street 10", 100, "Bucharest");

        // Act
        CinemaDTO toAddCinema = cinemaService.addCinema(cinema);

        // Assert
        Assertions.assertNotNull(toAddCinema.getId());
        Assertions.assertEquals(cinema.getName(), toAddCinema.getName());
        Assertions.assertEquals(cinema.getEmail(), toAddCinema.getEmail());
        Assertions.assertEquals(cinema.getStreet(), toAddCinema.getStreet());
        Assertions.assertEquals(cinema.getNumber(), toAddCinema.getNumber());
        Assertions.assertEquals(cinema.getCity(), toAddCinema.getCity());

        cinemaId = toAddCinema.getId();
    }

    @Test
    void test_getCinemas_returnsListOfCinemas() {
        // Arrange
        CinemaDTO cinema = new CinemaDTO("Cinema 10", "cinema10@test.ro", "Street 10", 100, "Bucharest");
        CinemaDTO createdCinema = cinemaService.addCinema(cinema);

 
        // Act
        List<CinemaDTO> actualCinemaDTOs = cinemaService.getCinemas();
        CinemaDTO actualCinemaDTO = actualCinemaDTOs.stream()
        .filter((cinemaDTO) -> cinemaDTO.getId().equals(createdCinema.getId()))
        .collect(Collectors.toList())
        .get(0);

        // Assert
        Assertions.assertEquals(createdCinema.getId(), actualCinemaDTO.getId());
        Assertions.assertEquals(createdCinema.getName(), actualCinemaDTO.getName());
        Assertions.assertEquals(createdCinema.getEmail(), actualCinemaDTO.getEmail());
        Assertions.assertEquals(createdCinema.getStreet(), actualCinemaDTO.getStreet());
        Assertions.assertEquals(createdCinema.getNumber(), actualCinemaDTO.getNumber());
        Assertions.assertEquals(createdCinema.getCity(), actualCinemaDTO.getCity());

        cinemaId = createdCinema.getId();
    }

    @Test
    void test_getCinemaById_returnsGetCinemaForValidId(){
     // Arrange
     CinemaDTO cinema = new CinemaDTO("Cinema 10", "cinema10@test.ro", "Street 10", 100, "Bucharest");
     CinemaDTO createdCinema = cinemaService.addCinema(cinema);
     
     // Act
     CinemaDTO actualCinema = cinemaService.getCinemaById(createdCinema.getId());

     // Assert
     Assertions.assertEquals(createdCinema.getId(), actualCinema.getId());
     Assertions.assertEquals(createdCinema.getName(), actualCinema.getName());
     Assertions.assertEquals(createdCinema.getEmail(), actualCinema.getEmail());
     Assertions.assertEquals(createdCinema.getStreet(), actualCinema.getStreet());
     Assertions.assertEquals(createdCinema.getNumber(), actualCinema.getNumber());
     Assertions.assertEquals(createdCinema.getCity(), actualCinema.getCity());

     cinemaId = createdCinema.getId();

    }

    @Test
    void test_updateCinema_updatesCinemaForValidCinemaDTO(){
     // Arrange
     CinemaDTO cinema = new CinemaDTO("Cinema 10", "cinema10@test.ro", "Street 10", 100, "Bucharest");
     CinemaDTO createdCinema = cinemaService.addCinema(cinema);
     
     cinema.setId(createdCinema.getId());
     cinema.setName("New Name");
     cinema.setEmail(createdCinema.getEmail());
     cinema.setStreet("New Street");
     cinema.setNumber(200);
     cinema.setCity("New City");
    
     // Act
     CinemaDTO updatedCinema = cinemaService.updateCinema(cinema);

     // Assert
     Assertions.assertEquals(cinema.getId(), updatedCinema.getId());
     Assertions.assertEquals(cinema.getName(), updatedCinema.getName());
     Assertions.assertEquals(cinema.getEmail(), updatedCinema.getEmail());
     Assertions.assertEquals(cinema.getStreet(), updatedCinema.getStreet());
     Assertions.assertEquals(cinema.getNumber(), updatedCinema.getNumber());
     Assertions.assertEquals(cinema.getCity(), updatedCinema.getCity());

     cinemaId = updatedCinema.getId();

    }

    // @Test
    // void test_getCinemaByName_returnsCinemaForValidName(){

    //  // Arrange
    //  CinemaDTO cinema = new CinemaDTO("Cinema 10", "cinema10@test.ro", "Street 10", 100, "Bucharest");
    //  CinemaDTO createdCinema = cinemaService.addCinema(cinema);
     
    //  // Act
    //  ResponseEntity <Cinema> actualCinema = cinemaService.getCinemaByName(createdCinema.getName());

    //  // Assert
    //  Assertions.assertEquals(createdCinema.getId(), actualCinema.getId());
    //  Assertions.assertEquals(createdCinema.getName(), actualCinema.getName());
    //  Assertions.assertEquals(createdCinema.getEmail(), actualCinema.getEmail());
    //  Assertions.assertEquals(createdCinema.getStreet(), actualCinema.getStreet());
    //  Assertions.assertEquals(createdCinema.getNumber(), actualCinema.getNumber());
    //  Assertions.assertEquals(createdCinema.getCity(), actualCinema.getCity());

    //  cinemaId = createdCinema.getId();

    // }


    // @Test
    // void test_getCinemaByCity_returnsCinemaForValidCity(){

    //  // Arrange
    //  CinemaDTO cinema = new CinemaDTO("Cinema 10", "cinema10@test.ro", "Street 10", 100, "Bucharest");
    //  CinemaDTO createdCinema = cinemaService.addCinema(cinema);
     
    //  // Act
    //  ResponseEntity <Cinema>  actualCinema = cinemaService.getCinemaByCity(createdCinema.getCity());

    //  // Assert
    //  Assertions.assertEquals(createdCinema.getId(), actualCinema.getId());
    //  Assertions.assertEquals(createdCinema.getName(), actualCinema.getName());
    //  Assertions.assertEquals(createdCinema.getEmail(), actualCinema.getEmail());
    //  Assertions.assertEquals(createdCinema.getStreet(), actualCinema.getStreet());
    //  Assertions.assertEquals(createdCinema.getNumber(), actualCinema.getNumber());
    //  Assertions.assertEquals(createdCinema.getCity(), actualCinema.getCity());

    //  cinemaId = createdCinema.getId();

    // }

}