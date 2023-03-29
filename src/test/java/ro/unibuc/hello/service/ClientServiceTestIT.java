package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ro.unibuc.hello.data.ClientEntity;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.dto.ClientDTO;
import ro.unibuc.hello.dto.Greeting;
import ro.unibuc.hello.exception.EntityNotFoundException;

@SpringBootTest
@Tag("IT")
class ClientServiceTestIT {

    @Autowired
    InformationRepository informationRepository;

    @Autowired
    ClientService clientService;

    @Test
    void test_saveClient_returnsClientDtoWithInformation() {
        // Arrange
        String name = "Name 1";
        String email = "email12340@email.com";
        ClientEntity clientEntity = new ClientEntity(name, email);

        // Act
        ClientDTO clientDTO = clientService.saveClient(clientEntity);

        // Assert
        Assertions.assertEquals("Name 1", clientDTO.getName());
        Assertions.assertEquals("email12340@email.com", clientDTO.getEmail());
    }

    void test_DeleteClientById_returnsId() {
        // Arrange
        String name = "Name";
        String email = "test_email123@email.com";
        ClientEntity clientEntity = new ClientEntity(name, email);

        // Act
        ClientDTO clientDTO = clientService.saveClient(clientEntity);
        String clientDTOId = clientDTO.getId();
        String id = clientService.deleteClientById(clientDTOId);

        // Assert
        Assertions.assertEquals(id, clientDTOId);
    }

    @Test
    void test_getClientById_returnsClientEntityWithInformation() {
        // Arrange
        ClientDTO clientDTO = clientService.saveClient(new ClientEntity("Name", "test_email123@email.com"));
        // Act
        ClientEntity clientEntity = clientService.getClientById(clientDTO.getId());

        // Assert
        Assertions.assertEquals(clientDTO.getId(), clientEntity.getId());
        Assertions.assertEquals("Name", clientEntity.getName());
        Assertions.assertEquals("test_email123@email.com", clientEntity.getEmail());

        String id = clientService.deleteClientById(clientDTO.getId());
    }

    @Test
    void test_getClientById_throwsEntityNotFoundException_whenEntityIsNull() {
        // Arrange

        // Act
        try {
            ClientEntity clientEntity = clientService.getClientById("64246cad056ca801e687b401");
        }
        catch (Exception ex) {
            // Assert
            Assertions.assertEquals(ex.getClass(), EntityNotFoundException.class);
        }
    }

    @Test
    void test_updateClientById_returnsClientEntityWithInformation() {
        // Arrange
        ClientDTO clientDTO = clientService.saveClient(new ClientEntity("Name", "test_email123@email.com"));
        ClientEntity updatedEntity = new ClientEntity("New Name", "newEmail123@email.com");
        // Act
        ClientEntity clientEntity = clientService.updateClientById(clientDTO.getId(), updatedEntity);

        // Assert
        Assertions.assertEquals(clientDTO.getId(), clientEntity.getId());
        Assertions.assertEquals("New Name", clientEntity.getName());
        Assertions.assertEquals("newEmail123@email.com", clientEntity.getEmail());

        String id = clientService.deleteClientById(clientDTO.getId());
    }
}
