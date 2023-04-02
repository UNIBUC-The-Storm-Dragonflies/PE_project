package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface AuditoriumRepository extends MongoRepository<Auditorium, String> {
    Optional<Auditorium> findByName(String name);
    List <Auditorium> findAllByCinema(Cinema cinema);
}