package ch.axa.backend.service;

import ch.axa.backend.mongo.model.Termin;

import java.util.List;
import java.util.Optional;

public interface TerminService {
    Termin save(Termin termin);
    List<Termin> findAll();
    Optional<Termin> findById(String id);
    List<Termin> findByName(String name);
    List<Termin> findByTime(String time);
    Termin createTermin(Termin termin);
    Termin editTermin(Termin newTermin);
    boolean deleteTermin(String terminId);
    Termin copyTermin(String terminId);
    Termin copyTermin(Termin termin);
}