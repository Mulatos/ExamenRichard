package ucll.examen.practicum.Richard.resource;

import ucll.examen.practicum.Richard.repository.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDto {
    public static final String INSERT_SQL = "INSERT INTO  person(id, first_name, last_name, email, phone) VALUES (?,?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE person SET first_name= ?, last_name= ?, email= ?, phone= ? WHERE id = ?;";
    public static final String DELETE_SQL = "DELETE FROM person  WHERE id = ?;";
    public static final String FIND_BY_ID_SQL = "SELECT * FROM person  WHERE id = ?;";
    public static final String FIND_BY_NAME_SQL = "SELECT * FROM person WHERE first_name= ?;";
    private final Connection connection;
    public String first_name;
    public String last_name;
    public String email;
    public int phone;
    public PersonDto(Connection connection) { this.connection= connection;}
    public void create(Person person) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
        preparedStatement.setLong(1,person.getId());
        preparedStatement.setString(2,person.getFirst_name());
        preparedStatement.setString(3,person.getLast_name());
        preparedStatement.setString(4,person.getEmail());
        preparedStatement.setInt(5,person.getPhone());
        preparedStatement.execute();

    }
    public void update(Person person) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
        preparedStatement.setLong(5,person.getId());
        preparedStatement.setString(1,person.getFirst_name());
        preparedStatement.setString(2,person.getLast_name());
        preparedStatement.setString(3,person.getEmail());
        preparedStatement.setInt(4,person.getPhone());
        preparedStatement.execute();

    }
     public String getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
        preparedStatement.setLong(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
         if (resultSet.next()) {
             Person person = new Person(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));
             return person.toString();
         }
         return "geen persoon gevonden";

    }
}
