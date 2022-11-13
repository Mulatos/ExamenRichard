package ucll.examen.practicum.Richard.resource;

import org.springframework.web.bind.annotation.*;
import ucll.examen.practicum.Richard.repository.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
public class PersonController {
    private final Connection connection = PersonController.getConnection();
    private  final  PersonDto personDto = new PersonDto(connection);
    private static final String url = "jdbc:h2:mem:Practicum";
    private static final String user = "Richard";
    private static final String pass = "";
    public PersonController () throws SQLException {}
    @GetMapping ("/person")
    @ResponseBody
    public String test () throws SQLException {
        System.out.println("HONGER");
        Person a = new Person( "bart", "koekje", "ik@hotmal", 123 );
        personDto.create(a);
        return "Koekje";

    }
    @PostMapping("/api/v1/person")
    @ResponseBody
    public String createPersoon(@RequestBody Person person) throws SQLException {
        personDto.create(person);
        return "persoon gemaakt!";
    }
    @PutMapping("/api/v1/person/{id}")
    @ResponseBody
    public String updatePersoon(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam int phone,@PathVariable Long id) throws SQLException {
        Person person = new Person(id, firstName, lastName,email,phone);
        personDto.update(person);
        return "persoon geupdate!";
    }
    @GetMapping("/api/v1/person/{id}")
    @ResponseBody
    public String getPersoon(@PathVariable Long id) throws SQLException {
        Person person = new Person(id, firstName, lastName,email,phone);
        personDto.update(person);
        return "persoon geupdate!";
    }


    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, user, pass);
    }
}
