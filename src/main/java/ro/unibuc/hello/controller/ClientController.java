package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.hello.data.ClientEntity;
import ro.unibuc.hello.dto.ClientDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.ClientService;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicLong;

import java.util.List;

@Controller
public class ClientController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ClientService clientService;

    @Autowired
    MeterRegistry metricsRegistry;

    @GetMapping("/clienti")
    @ResponseBody
    @Timed(value = "client.get.time", description = "Time taken to return clients")
    @Counted(value = "client.get.count", description = "Times clients were returned")
    public List<ClientDTO> getAllClients() {
        metricsRegistry.counter("client_get_non_aop_metric", "endpoint", "client").increment(counter.incrementAndGet());
        return clientService.getAll();
    }

    @PostMapping(value = "/clienti")
    @Timed(value = "client.post.time", description = "Time taken to add client")
    @Counted(value = "client.post.count", description = "Times clients were added")
    public ClientDTO createClient(@RequestBody ClientEntity client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/clienti/{id}")
    @ResponseBody
    @Timed(value = "client.get.id.time", description = "Time taken to return client by id")
    @Counted(value = "client.get.id.count", description = "Times clients were returned by id")
    public ClientEntity getClientById(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        return clientService.getClientById(id);
    }

    @PutMapping("/clienti/{id}")
    @ResponseBody
    @Timed(value = "client.update.id.time", description = "Time taken to update client by id")
    @Counted(value = "client.update.id.count", description = "Times clients were updated by id")
    public ClientEntity updateClientById(@PathVariable(value = "id") String id, @RequestBody ClientEntity updatedClient) throws EntityNotFoundException {
        return clientService.updateClientById(id, updatedClient);
    }

    @DeleteMapping("/clienti/{id}")
    @ResponseBody
    @Timed(value = "client.delete.id.time", description = "Time taken to delete client by id")
    @Counted(value = "client.delete.id.count", description = "Times clients were deleted by id")
    public String deleteClientById(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        return clientService.deleteClientById(id);
    }
}
