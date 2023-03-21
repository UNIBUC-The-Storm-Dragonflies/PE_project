package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuditoriumRepository extends MongoRepository<Auditorium, String> {
    Optional<Auditorium> findByName(String name);
}