package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditoriumRepository extends MongoRepository<Auditorium, String> {
}
