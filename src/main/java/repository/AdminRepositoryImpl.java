package repository;

import config.DBConfig;
import entity.Admin;
import entity.Person;
import service.PersonServiceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class AdminRepositoryImpl {

    private final PersonServiceImpl personService = new PersonServiceImpl();

    public Admin load(String username, String password) {
        String query = """
                    select * from admin
                    where username = ? and password = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;
            Person person = personService.loadById(resultSet.getLong("person_id"));
            return new Admin(person.getFirstname(), person.getLastname(), person.getNationalCode());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}