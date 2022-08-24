package repository.person;

import config.DBConfig;
import entity.Customer;
import entity.Person;
import entity.enums.CustomerType;
import repository.person.interfaces.CustomerRepository;
import service.person.PersonServiceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final PersonServiceImpl personService = new PersonServiceImpl();

    @Override
    public void save(String username, String password, long id) {
        String query = """
                    insert into customer(username, password, customer_type, person_id)
                    values (?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setObject(3, String.valueOf(CustomerType.NORMAL), Types.OTHER);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer load(String username, String password) {
        String query = """
                    select * from customer
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
            Customer customer = new Customer(person.getFirstname(), person.getLastname(), person.getNationalCode());
            customer.setId(resultSet.getInt("id"));
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
