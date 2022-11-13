package ucll.examen.practicum.Richard.resource;

import org.springframework.web.bind.annotation.*;
import ucll.examen.practicum.Richard.repository.Course;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
public class CourseController {
    private final Connection connection = CourseController.getConnection();

    private final CourseDto courseDto = new CourseDto(connection);

    private static final String url = "jdbc:h2:mem:Practicum";
    private static final String user = "Richard";
    private static final String pass = "";

    public CourseController() throws SQLException {
    }
    @PostMapping("/api/v1/course")
    @ResponseBody
    public String createCourse(@RequestBody Course course) throws SQLException {
        courseDto.create(course);
        return "course gemaakt!";
    }
    @GetMapping("/api/v1/course/{id}")
    @ResponseBody
    public String getCourse(@PathVariable int id) throws SQLException {

        Long idLong = Long.valueOf(id);
        return courseDto.getById(idLong);

    }
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, user, pass);
    }
}
