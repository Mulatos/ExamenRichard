package ucll.examen.practicum.Richard.resource;

import org.springframework.web.bind.annotation.*;
import ucll.examen.practicum.Richard.repository.Person;

@RestController
public class PersonController {
    public PersonController () {}
    @GetMapping ("/person")
    @ResponseBody
    public String test () {
        System.out.println("HONGER");
        return "Koekje";
    }
    @PostMapping("/api/v1/person")
    @ResponseBody
    public String createPersoon(@RequestBody Person person) {

    }

}
