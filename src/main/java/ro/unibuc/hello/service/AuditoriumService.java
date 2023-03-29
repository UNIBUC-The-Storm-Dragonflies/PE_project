package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.Auditorium;
import ro.unibuc.hello.data.AuditoriumRepository;
import ro.unibuc.hello.data.MovieEntity;
import ro.unibuc.hello.dto.AuditoriumDTO;
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
            throw new EntityNotFoundException("movie");
        }

        return auditoriumRepository
                .findAll()
                .stream()
                .filter(auditorium -> movie.getAuditoriumIds().contains(auditorium.getId()))
                .map(auditorium -> new AuditoriumDTO(auditorium))
                .collect(Collectors.toList());
    }
}
