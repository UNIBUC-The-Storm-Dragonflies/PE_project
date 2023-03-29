package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import ro.unibuc.hello.data.AuditoriumRepository;
import ro.unibuc.hello.dto.AuditoriumDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.exception.EntityNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.unibuc.hello.data.Auditorium;

import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;


@SpringBootTest
//@Tag("IT")
@ExtendWith(SpringExtension.class)
class AuditoriumServiceTestIT {

//    @MockBean
//    AuditoriumRepository mockAuditoriumRepository;

//    @InjectMocks
//    AuditoriumService auditoriumService = new AuditoriumService();

    @Autowired
    AuditoriumRepository mockAuditoriumRepository;
    @Autowired
    AuditoriumService auditoriumService;

    @Test
    void test_getAuditoriumById_returnEntity() {
        String id = "1234567890";

//        Auditorium auditorium = new Auditorium("room1", 101);
//        auditorium.setId(id);
//        when(mockAuditoriumRepository.findById(id))
//                .thenReturn(Optional.of(auditorium));

        AuditoriumDTO auditoriumDTO = auditoriumService.getAuditoriumById(id);

        Assertions.assertEquals("room1", auditoriumDTO.getName());
        Assertions.assertEquals(101, auditoriumDTO.getSeatNumber());
    }

    @Test
    void test_getAuditoriumById_throwEntityNotFoundException() {
        String id = "exception";

        try {
            AuditoriumDTO auditoriumDTO = auditoriumService.getAuditoriumById(id);
        } catch (Exception ex) {
            Assertions.assertEquals(ex.getClass(), EntityNotFoundException.class);
            Assertions.assertEquals(ex.getMessage(), "Entity: auditorium was not found");
        }
    }

    @Test
    void test_getAuditoriumByName_returnEntity() {
        String name = "room1";

        AuditoriumDTO auditoriumDTO = auditoriumService.getAuditoriumByName(name);

        Assertions.assertEquals("1234567890", auditoriumDTO.getId());
        Assertions.assertEquals(101, auditoriumDTO.getSeatNumber());
    }

    @Test
    void test_getAuditoriumByName_throwEntityNotFoundException() {
        String name = "exception";

        try {
            AuditoriumDTO auditoriumDTO = auditoriumService.getAuditoriumByName(name);
        } catch (Exception ex) {
            Assertions.assertEquals(ex.getClass(), EntityNotFoundException.class);
            Assertions.assertEquals(ex.getMessage(), "Entity: auditorium was not found");
        }
    }

    @Test
    void test_getAuditoriumsByMovie_returnEntityList() {
        String movieId = "123";

        List<AuditoriumDTO> auditoriumDTOList = auditoriumService.getAuditoriumsByMovie(movieId);

        AuditoriumDTO auditoriumDTO = new AuditoriumDTO("1234567890", "room1", 101);

        Assertions.assertTrue(auditoriumDTOList.contains(auditoriumDTO));
    }

    @Test
    void test_getAuditoriumsByMovie_throwEntityNotFoundException() {
        String movieId = "123";

        try {
            List<AuditoriumDTO> auditoriumDTOList = auditoriumService.getAuditoriumsByMovie(movieId);
        } catch (Exception ex) {
            Assertions.assertEquals(ex.getClass(), EntityNotFoundException.class);
            Assertions.assertEquals(ex.getMessage(), "Entity: movie was not found");
        }
    }

}