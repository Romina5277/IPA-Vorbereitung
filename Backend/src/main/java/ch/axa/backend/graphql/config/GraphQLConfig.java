package ch.axa.backend.graphql.config;

import ch.axa.backend.graphql.resolver.Mutation;
import ch.axa.backend.graphql.resolver.Query;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Autowired
    private Query queryResolver;

    @Autowired
    private Mutation mutationResolver;

    @Bean
    public GraphQLSchema schema() {
        return SchemaParser
                .newParser()
                .file("graphql/knowhow.graphqls")
                .resolvers(
                        queryResolver,
                        mutationResolver)
                .build()
                .makeExecutableSchema();
    }
}
