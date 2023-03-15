package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.unibuc.hello.dto.TicketDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.TicketService;

import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public void dosmth() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @GetMapping("/{film_id}/tickets")
    @ResponseBody
    public List<TicketDTO> getTicketsByFilm(@PathVariable String id) throws EntityNotFoundException {
        return ticketService.getTicketsByFilm(id);
    }

//    @GetMapping("/tickets")
//    @ResponseBody
//    public List<TicketDTO> getTickets() { return ticketService.getTickets(); };

}
