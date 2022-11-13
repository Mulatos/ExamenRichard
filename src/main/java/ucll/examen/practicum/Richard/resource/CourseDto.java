package ucll.examen.practicum.Richard.resource;

import ucll.examen.practicum.Richard.repository.Course;
import ucll.examen.practicum.Richard.repository.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDto {
    public static final String INSERT_SQL = "INSERT INTO  course(id, name, description, study_points) VALUES (?,?,?,?)";

    public static final String FIND_BY_ID_SQL = "SELECT * FROM course  WHERE id = ?;";

    private final Connection connection;

    public CourseDto(Connection connection) {
        this.connection = connection;
    }

    public void create(Course course) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
        preparedStatement.setLong(1, course.getId());
        preparedStatement.setString(2, course.getName());
        preparedStatement.setString(3, course.getDescription());
        preparedStatement.setString(4, course.getStudy_points());
        preparedStatement.execute();

    }

    public String getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Course course = new Course(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            return course.toString();
        }
        return "geen course gevonden";
    }
}