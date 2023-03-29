package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class ClientTest {
    ClientDTO myClient = new ClientDTO("1","Nume Client", "email1@gmail.com");
    @Test
    void test_get_id() { Assertions.assertEquals("1", myClient.getId());}
    @Test
    void test_name(){
        Assertions.assertSame("Nume Client", myClient.getName());
    }
    @Test
    void test_email(){
        Assertions.assertSame("email1@gmail.com", myClient.getEmail());
    }

    @Test
    void test_set_id() {
        ClientDTO newClient = new ClientDTO();
        newClient.setId("2");
        Assertions.assertEquals("2", newClient.getId());
    }
    @Test
    void test_set_name(){
        ClientDTO newClient = new ClientDTO();
        newClient.setName("New Name");
        Assertions.assertSame("New Name", newClient.getName());
    }
    @Test
    void test_set_email(){
        ClientDTO newClient = new ClientDTO("New Name", "email@gmail.com");
        newClient.setEmail("new_email@gmail.com");
        Assertions.assertSame("new_email@gmail.com", newClient.getEmail());
    }
}
