package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.Projecting;
import ro.unibuc.hello.data.ProjectingRepository;
import ro.unibuc.hello.data.Ticket;
import ro.unibuc.hello.data.TicketRepository;
import ro.unibuc.hello.dto.ProjectingDTO;
import ro.unibuc.hello.dto.TicketDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    private ProjectingRepository projectingRepository;
    private ProjectingService projectingService;

    public List<TicketDTO> getTicketsByFilm(String film_id) throws EntityNotFoundException {
//      search in projecting and get all ticket ids where the film_id matches
        List<ProjectingDTO> projections = projectingRepository.findAll()
                .stream().filter(proj -> Objects.equals(proj.getFilm_id(), film_id))
                .map(proj -> new ProjectingDTO(proj))
                .collect(Collectors.toList());

        List<TicketDTO> tickets = ticketRepository.findAll().
                stream().filter(ticket -> projectingService.getTicketIdsOfProjectingList(projections).contains(ticket.getId()))
                .map(ticket -> new TicketDTO(ticket))
                .collect(Collectors.toList());

        return tickets;
    }

    public List<TicketDTO> getTickets() {
        List<TicketDTO> tickets = ticketRepository.findAll()
                .stream().map(ticket -> new TicketDTO(ticket))
                .collect(Collectors.toList());

        if (tickets.isEmpty()) {
            throw new EntityNotFoundException("ticket");
        }

        for (TicketDTO t : tickets) {
            System.out.println(t);
        }

        return tickets;
    }
}
