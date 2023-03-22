package ro.unibuc.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.unibuc.hello.dto.AuditoriumDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.AuditoriumService;

@Controller
@RequestMapping("/auditorium")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @GetMapping("/get-auditorium/{id}")
    @ResponseBody
    public AuditoriumDTO getAuditoriumById(@PathVariable String id) throws EntityNotFoundException {
        return auditoriumService.getAuditoriumById(id);
    }

    @GetMapping("/get-auditorium-by-name/{name}")
    @ResponseBody
    public AuditoriumDTO getAuditoriumByName(@PathVariable String name) throws EntityNotFoundException {
        return auditoriumService.getAuditoriumByName(name);
    }

    @GetMapping("/auditoriums-for-movie/{movieId}")
    @ResponseBody
    public List<AuditoriumDTO> getAuditoriumsByMovie(@PathVariable String movieId) throws EntityNotFoundException {
        return auditoriumService.getAuditoriumsByMovie(movieId);
    }
}
