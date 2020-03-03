package ch.axa.backend;

import ch.axa.backend.mongo.model.Termin;
import ch.axa.backend.mongo.repository.TerminRepository;
import ch.axa.backend.restservices.TerminController;
import ch.axa.backend.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({"ch.axa.backend.graphql",
                "ch.axa.backend.mongo.config",
                "ch.axa.backend.config",
                "ch.axa.backend.graphql.config",
                "ch.axa.backend.restservices",
                "ch.axa.backend.soapservices"})
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private TerminRepository terminRepository;

    @Autowired
    private TerminService terminService;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

/*    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/termine").allowedOrigins("*");
            }
        };
    }
*/
    @Override
    public void run(String... args) throws Exception {
        terminRepository.deleteAll();

        // save a couple of meetings
        terminRepository.save(new Termin("Hans Peter Bretschner", "12:00:00"));
        terminRepository.save(new Termin("Hans Peter Bretschner", "15:30:00"));
        terminRepository.save(new Termin("Hans Peter Bretschner", "11:00:00"));
        terminRepository.save(new Termin("Hans Peter Bretschner", "10:50:00"));
        terminRepository.save(new Termin("Hans Peter Muster", "12:00:00"));
        terminRepository.save(new Termin("Hans Muster", "13:00:00"));

        // fetch all meetings
        System.out.println("Meetings found with findAll():");
        System.out.println("------------------------------");
        terminRepository.findAll().forEach(System.out::println);
        System.out.println();

        // fetch individual meetings
        System.out.println("Meetings found with findByName('Hans Peter Bretschner'):");
        System.out.println("--------------------------------------------------------");
        for (Termin termin : terminRepository.findByName("Hans Peter Bretschner")) {
            System.out.println(termin);
        }
        System.out.println();

        System.out.println("Meetings found with findFirstBy('Hans Muster'):");
        System.out.println("-----------------------------------------------");
        System.out.println(terminRepository.findFirstBy("Hans Muster"));
        System.out.println();

        System.out.println("Meetings found with findByTime('12:00:00'):");
        System.out.println("-------------------------------------------");
        for (Termin termin : terminRepository.findByTime("12:00:00")) {
            System.out.println(termin);
        }
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        TerminController terminController = new TerminController(terminService);
        System.out.println("Test REST");
        System.out.println("--------------------------");
        terminController.termine().forEach(termin -> System.out.println(termin));
        System.out.println();
    }
}
