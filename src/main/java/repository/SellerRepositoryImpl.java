package repository;

import config.DBConfig;
import entity.Person;
import entity.Seller;
import entity.enums.product.ProductType;
import service.PersonServiceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SellerRepositoryImpl {

    private final PersonServiceImpl personService = new PersonServiceImpl();

    public void save(String username, String password, ProductType type, long id) {
        String query = """
                    insert into seller(username, password, product_type, person_id)
                    values (?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setObject(3, String.valueOf(type), Types.OTHER);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Seller load(String username, String password) {
        String query = """
                    select * from seller
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
            return new Seller(person.getFirstname(), person.getLastname(), person.getNationalCode(),
                    ProductType.valueOf(resultSet.getString("product_type")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
