package ro.unibuc.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.unibuc.hello.dto.AuditoriumCreationDTO;
import ro.unibuc.hello.dto.AuditoriumDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.AuditoriumService;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/auditorium")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;
    
    @Autowired
    MeterRegistry metricsRegistry;    

    @PostMapping("/add-auditorium")
    @ResponseBody
    public AuditoriumDTO addAuditorium(@RequestBody AuditoriumCreationDTO auditoriumCreationDTO) throws EntityNotFoundException{
        return auditoriumService.addAuditorium(auditoriumCreationDTO);
    }

    @GetMapping("/get-auditorium/{id}")
    @ResponseBody
    @Timed(value = "auditorium.get.id.time", description = "Time taken to get auditorium by id")
    @Counted(value = "auditorium.get.id.count", description = "Times auditorium was added by id")
    public AuditoriumDTO getAuditoriumById(@PathVariable String id) throws EntityNotFoundException {
        return auditoriumService.getAuditoriumById(id);
    }

    @GetMapping("/get-auditorium-by-name/{name}")
    @ResponseBody
    @Timed(value = "auditorium.get.name.time", description = "Time taken to get auditorium by name")
    @Counted(value = "auditorium.get.name.count", description = "Times auditorium was added by name")
    public AuditoriumDTO getAuditoriumByName(@PathVariable String name) throws EntityNotFoundException {
        return auditoriumService.getAuditoriumByName(name);
    }

    @GetMapping("/auditoriums-for-movie/{movieId}")
    @ResponseBody
    @Timed(value = "auditorium.get.auditoriums.byMovie", description = "Time taken to get auditorium by movie")
    @Counted(value = "auditorium.get.auditoriums.byMovie", description = "Times auditorium was added by movie")
    public List<AuditoriumDTO> getAuditoriumsByMovie(@PathVariable String movieId) throws EntityNotFoundException {
        return auditoriumService.getAuditoriumsByMovie(movieId);
    }

    @GetMapping("/get-cinema-auditoriums/{cinema_id}")
    @ResponseBody
    @Timed(value = "auditorium.get.auditoriums.byCinemaId", description = "Time taken to get auditorium by cinema id")
    @Counted(value = "auditorium.get.auditoriums.byCinemaId", description = "Times auditorium was added by cinema id")
    public List <AuditoriumDTO> getCinemaAuditoriums(@PathVariable String cinema_id) throws EntityNotFoundException{
        return auditoriumService.getCinemaAuditoriums(cinema_id);
    }

}
