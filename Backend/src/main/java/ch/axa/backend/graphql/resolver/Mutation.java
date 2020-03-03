package ch.axa.backend.graphql.resolver;

import ch.axa.backend.mongo.model.Termin;
import ch.axa.backend.service.TerminService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TerminService terminService;

    public Mutation(TerminService terminService) {
        this.terminService = terminService;
    }

    public Termin createTermin(Termin termin) {
        return terminService.createTermin(termin);
    }

    public Termin editTermin(Termin termin) {
        return terminService.editTermin(termin);
    }

    public boolean deleteTermin(String terminId) {
        return terminService.deleteTermin(terminId);
    }

    public Termin copyTermin(String terminId) {
        return terminService.copyTermin(terminId);
    }

}
