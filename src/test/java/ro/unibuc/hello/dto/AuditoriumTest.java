package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AuditoriumTest {

    AuditoriumDTO auditoriumDTO = new AuditoriumDTO("1", "Room 1", 101);

    // unit tests for getters
    @Test
    void test_getId() {
        Assertions.assertSame("1", auditoriumDTO.getId());
    }

    @Test
    void test_getName() {
        Assertions.assertSame("Room 1", auditoriumDTO.getName());
    }

    @Test
    void test_getSeatNumber() {
        Assertions.assertSame(101, auditoriumDTO.getSeatNumber());
    }

    // unit tests for setters
    @Test
    void test_setId() {
        AuditoriumDTO auditoriumDTO = new AuditoriumDTO();
        auditoriumDTO.setId("200");
        Assertions.assertSame("200", auditoriumDTO.getId());
    }

    @Test
    void test_setName() {
        AuditoriumDTO auditoriumDTO = new AuditoriumDTO();
        auditoriumDTO.setName("Room 200");
        Assertions.assertSame("Room 200", auditoriumDTO.getName());
    }

    @Test
    void test_setSeatNumber() {
        AuditoriumDTO auditoriumDTO = new AuditoriumDTO();
        auditoriumDTO.setSeatNumber(200);
        Assertions.assertEquals(200, auditoriumDTO.getSeatNumber());
    }
}