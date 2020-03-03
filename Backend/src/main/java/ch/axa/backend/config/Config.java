package ch.axa.backend.config;

import ch.axa.backend.graphql.resolver.Mutation;
import ch.axa.backend.graphql.resolver.Query;
import ch.axa.backend.mongo.repository.TerminRepository;
import ch.axa.backend.service.TerminService;
import ch.axa.backend.service.TerminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Autowired
    private TerminRepository terminRepository;

    @Bean
    public TerminService terminService() {
        return new TerminServiceImpl(terminRepository);
    }

    @Bean
    public Query queryResolver() {
        return new Query(terminService());
    }

    @Bean
    public Mutation mutationResolver() {
        return new Mutation(terminService());
    }
}
