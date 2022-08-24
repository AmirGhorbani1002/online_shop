package repository.product;

import config.DBConfig;
import entity.product.Product;
import repository.product.base_interfaces.ProductRepository;

import java.sql.*;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
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

    @Override
    public int loaProductQuantity(long productId) {
        String query = """
                    select quantity from product
                    where id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next())
                return 0;
            return resultSet.getInt("quantity");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(long productId, int quantity) {
        String query = """
                    update product
                    set quantity = ?
                    where id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setLong(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
