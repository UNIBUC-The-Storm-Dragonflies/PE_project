package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import ro.unibuc.hello.service.CinemaService;
import ro.unibuc.hello.dto.CinemaDTO;
import ro.unibuc.hello.data.Cinema;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.List;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicLong;


@Controller
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    MeterRegistry metricsRegistry;

    @PostMapping("/add_cinema")
    @ResponseBody
    public CinemaDTO addCinema(@RequestBody CinemaDTO cinemaDTO){
        return cinemaService.addCinema(cinemaDTO);
    }

    @GetMapping("/cinemas")
    @ResponseBody
    @Timed(value = "cinemas.get.time", description = "Time taken to get cinemas")
    @Counted(value = "cinemas.get.time", description = "Times cinemas were returned")
    public List<CinemaDTO> getCinemas(){
        return cinemaService.getCinemas();
    } 

    @PutMapping("/update_cinema")
    @ResponseBody
    public CinemaDTO updateCinema(@RequestBody CinemaDTO cinemaUpdatedDTO){
        return cinemaService.updateCinema(cinemaUpdatedDTO);
    }

    @GetMapping("/get_cinema/{id}")
    @ResponseBody
    public CinemaDTO getCinemaById(@PathVariable String id) throws EntityNotFoundException {
        return cinemaService.getCinemaById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    public ResponseEntity<Cinema> getCinemaByName(@PathVariable(value = "name") String name) throws EntityNotFoundException{
        return cinemaService.getCinemaByName(name);
    }

    @GetMapping("/city/{city}")
    @ResponseBody
    public ResponseEntity<Cinema> getCinemaByCity(@PathVariable(value = "city") String city) throws EntityNotFoundException{
        return cinemaService.getCinemaByCity(city);
    }
}
