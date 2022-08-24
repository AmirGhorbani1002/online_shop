package repository.product;

import config.DBConfig;
import entity.product.Product;

import java.sql.*;

public class ProductRepositoryImpl {

    public Product save(Product product, int id) {
        String query = """
                    insert into product(product_type, price, description, seller_id, quantity)
                    values (?,?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, product.getProductType(), Types.OTHER);
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, id);
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            product.setId(resultSet.getInt("id"));
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public Product load(int id){
        String query = """
                    select * from pr
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

}
