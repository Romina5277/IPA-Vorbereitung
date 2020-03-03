package ch.axa.backend.mongo.repository;

import ch.axa.backend.mongo.model.Termin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TerminRepository extends MongoRepository<Termin, String> {

    public Termin findFirstBy(String name);
    public Optional<Termin> findById(String id);
    public List<Termin> findByName(String name);
    public List<Termin> findByTime(String time);
}
