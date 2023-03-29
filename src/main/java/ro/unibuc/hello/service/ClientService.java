package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.ClientEntity;
import ro.unibuc.hello.data.ClientRepository;
import ro.unibuc.hello.dto.ClientDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(client -> new ClientDTO(client.getId(), client.getName(), client.getEmail()))
                .collect(Collectors.toList());
    }

    public ClientEntity getClientById(String id) {
        ClientEntity entity = clientRepository.findById(id).orElse(null);
        if (entity == null) {
            throw new EntityNotFoundException(id);
        }
        return entity; 
   }

    public ClientDTO saveClient(ClientEntity client) {
        ClientEntity clientEntity = clientRepository.save(client);
        ClientDTO clientDTO = new ClientDTO(clientEntity.getId(), clientEntity.getName(), clientEntity.getEmail());
        return clientDTO;
    }

    public ClientEntity updateClientById(String id, ClientEntity updatedClient) {
        ClientEntity client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            throw new EntityNotFoundException(id);
        }

        client.setEmail(updatedClient.getEmail());
        client.setName(updatedClient.getName());
        ClientEntity clientEntity = clientRepository.save(client);
        return clientEntity;
    }

    public String deleteClientById(String id) {
        ClientEntity client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            throw new EntityNotFoundException(id);
        }
        clientRepository.delete(client);
        return id;
    }
}
