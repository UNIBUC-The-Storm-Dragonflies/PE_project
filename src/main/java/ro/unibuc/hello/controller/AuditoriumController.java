package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.hello.data.Auditorium;
import ro.unibuc.hello.dto.AuditoriumDTO;
import ro.unibuc.hello.dto.Greeting;
import ro.unibuc.hello.service.AuditoriumService;

import java.util.List;

@Controller
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @GetMapping("/auditoriums")
    @ResponseBody
    public List<AuditoriumDTO> getAuditoriums() { return auditoriumService.getAuditoriums(); }
//    public void dosmth() {
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
//    }

    @PostMapping("/newAuditoriums")
    public AuditoriumDTO postAuditorium(@RequestBody Auditorium auditorium) {
//        System.out.println(auditorium);

        return auditoriumService.saveAuditorium(auditorium);
    }
}
