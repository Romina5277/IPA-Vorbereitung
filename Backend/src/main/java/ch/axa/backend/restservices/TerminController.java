package ch.axa.backend.restservices;

import ch.axa.backend.mongo.model.Termin;
import ch.axa.backend.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/termin")
public class TerminController{

    private TerminService terminService;

    @Autowired
    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @GetMapping("/termine")
    @CrossOrigin(origins = "*")
    public List<Termin> termine() {
        return terminService.findAll();
    }

}
