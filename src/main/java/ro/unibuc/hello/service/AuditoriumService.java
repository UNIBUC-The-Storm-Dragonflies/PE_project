package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.Auditorium;
import ro.unibuc.hello.data.AuditoriumRepository;
import ro.unibuc.hello.dto.AuditoriumDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public List<AuditoriumDTO> getAuditoriums() {
        return auditoriumRepository.findAll()
                .stream().map(auditorium -> new AuditoriumDTO(auditorium.getId(), auditorium.getName(), auditorium.getSeatNumber()))
                .collect(Collectors.toList());
    }

    public AuditoriumDTO saveAuditorium(Auditorium auditorium) {
        Auditorium audit = auditoriumRepository.save(auditorium);
//        System.out.println(audit);
        AuditoriumDTO auditAux = new AuditoriumDTO(audit.getId(), audit.getName(), audit.getSeatNumber());

//        System.out.println(auditAux);
        return auditAux;
    }
}
