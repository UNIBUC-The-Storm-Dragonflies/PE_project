package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.Auditorium;
import ro.unibuc.hello.data.AuditoriumRepository;
import ro.unibuc.hello.data.Cinema;
import ro.unibuc.hello.data.CinemaRepository;
import ro.unibuc.hello.data.MovieEntity;
import ro.unibuc.hello.dto.AuditoriumDTO;
import ro.unibuc.hello.dto.AuditoriumCreationDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private MovieService movieService;
    @Autowired 
    private CinemaRepository cinemaRepository;

    public AuditoriumDTO addAuditorium(AuditoriumCreationDTO auditoriumCreationDTO) throws EntityNotFoundException{
        Auditorium auditorium = auditoriumCreationDTO.toAuditorium();

        Optional <Cinema> cinema = cinemaRepository.findById(auditoriumCreationDTO.getCinemaId());

        if (cinema.isEmpty()){
            throw new EntityNotFoundException("cinema");
        }

        auditorium.setCinema(cinema.get());
        auditorium = auditoriumRepository.save(auditorium);

        return new AuditoriumDTO(auditorium);
    }

    public AuditoriumDTO getAuditoriumById(String id) throws EntityNotFoundException {
        Optional<Auditorium> auditorium = auditoriumRepository.findById(id);

        if (auditorium.isEmpty()) {
            throw new EntityNotFoundException("auditorium");
        }

        return new AuditoriumDTO(auditorium.get());
    }

    public AuditoriumDTO getAuditoriumByName(String name) throws EntityNotFoundException {
        Optional<Auditorium> auditorium = auditoriumRepository.findByName(name);

        if (auditorium.isEmpty()) {
            throw new EntityNotFoundException("auditorium");
        }

        return new AuditoriumDTO(auditorium.get());
    }

    public List<AuditoriumDTO> getAuditoriumsByMovie(String movieId) throws EntityNotFoundException {
        MovieEntity movie = movieService.getMovieObjectById(movieId);
        
        if(movie == null) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
            
        }
        System.out.println(movie);
              
        return auditoriumRepository
                .findAll()
                .stream()
                .filter(auditorium -> movie.getAuditoriumIds().contains(auditorium.getId()))
                .map(auditorium -> new AuditoriumDTO(auditorium))
                .collect(Collectors.toList());
    }


    public List<AuditoriumDTO> getCinemaAuditoriums(String cinemaId) throws EntityNotFoundException{
        Optional <Cinema> cinemaFilter = cinemaRepository.findById(cinemaId);

        if (cinemaFilter.isEmpty()){
            throw new EntityNotFoundException("cinema");
        }

        return auditoriumRepository.findAllByCinema(cinemaFilter.get())
                .stream()
                .map(auditorium -> new AuditoriumDTO(auditorium))
                .collect(Collectors.toList());
    }



}
