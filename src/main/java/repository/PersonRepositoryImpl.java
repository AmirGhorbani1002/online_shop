package repository;

import config.DBConfig;
import entity.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepositoryImpl{

    public void save(Person person) {
        String query = """
                    insert into person(firstname, lastname, national_code)
                    values (?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setString(1, person.getFirstname());
            preparedStatement.setString(2, person.getLastname());
            preparedStatement.setString(3, person.getNationalCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person loadByNationalCode(String nationalCode){
        String query = """
                    select * from person
                    where national_code = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setString(1, nationalCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next())
                return null;
            return new Person(resultSet.getString("firstname"),resultSet.getString("lastname"),
                    resultSet.getString("national_code"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person loadById(long id){
        String query = """
                    select * from person
                    where id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next())
                return null;
            return new Person(resultSet.getString("firstname"),resultSet.getString("lastname"),
                    resultSet.getString("national_code"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
