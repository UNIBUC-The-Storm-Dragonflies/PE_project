package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import ro.unibuc.hello.data.Auditorium;
import ro.unibuc.hello.data.AuditoriumRepository;
import ro.unibuc.hello.dto.AuditoriumDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.Optional;

@Component
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

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
}
