package ch.axa.backend.graphql.resolver;

import ch.axa.backend.mongo.model.Termin;
import ch.axa.backend.service.TerminService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class Query implements GraphQLQueryResolver {

    @Autowired
    private TerminService terminService;

    public Query(TerminService terminService) {
        this.terminService = terminService;
    }

    public List<Termin> getTermine() {
        return terminService.findAll();
    }

    public Optional<Termin> getTermin(String terminId) {
        return terminService.findById(terminId);
    }
}
