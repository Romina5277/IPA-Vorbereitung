package ch.axa.backend.service;

import ch.axa.backend.mongo.model.Termin;
import ch.axa.backend.mongo.repository.TerminRepository;

import java.util.List;
import java.util.Optional;

public class TerminServiceImpl implements TerminService {

    private final TerminRepository terminRepository;

    public TerminServiceImpl(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }

    @Override
    public Termin save(Termin termin) {
        return terminRepository.save(termin);
    }

    @Override
    public List<Termin> findAll() {
        return terminRepository.findAll();
    }

    @Override
    public Optional<Termin> findById(String id) {
        return terminRepository.findById(id);
    }

    @Override
    public List<Termin> findByName(String name) {
        return terminRepository.findByName(name);
    }

    @Override
    public List<Termin> findByTime(String time) {
        return terminRepository.findByTime(time);
    }

    @Override
    public Termin createTermin(Termin termin) {
        termin.setId(null);
        return terminRepository.save(termin);
    }

    @Override
    public Termin editTermin(Termin newTermin) {
        return terminRepository.findById(newTermin.getId()).map(oldTermin -> terminRepository.save(newTermin)).orElse(null);
    }

    @Override
    public boolean deleteTermin(String terminId) {
        return terminRepository.findById(terminId).map(termin -> {
            terminRepository.delete(termin);
            return true;
        }).orElse(false);
    }

    @Override
    public Termin copyTermin(String terminId) {
        return terminRepository.findById(terminId).map(termin -> copyTermin(termin)).orElse(null);
    }

    @Override
    public Termin copyTermin(Termin termin) {
        termin.setId(null);
        termin.setName(termin.getName() + " - COPY");
        return terminRepository.save(termin);
    }
}
