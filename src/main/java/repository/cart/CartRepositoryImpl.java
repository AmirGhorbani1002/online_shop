package repository.cart;

import config.DBConfig;
import entity.Cart;
import entity.enums.CartStatus;
import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;
import entity.enums.product.tv.DisplayType;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Tv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CartRepositoryImpl {

    public void save(long customerId) {
        String query = """
                    insert into cart(customer_id, cart_status)
                    values (?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, customerId);
            preparedStatement.setObject(2, CartStatus.UNPAID, Types.OTHER);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveProduct(int productId, long cartId, int quantity, float price) {
        String query = """
                    insert into cart_products(product_id, cart_id, description, quantity, price)
                    values (?,?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, productId);
            preparedStatement.setLong(2, cartId);
            preparedStatement.setString(3, "hello");
            preparedStatement.setInt(4, quantity);
            preparedStatement.setFloat(5, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cart loadPending(long customerId) {
        String query = """
                    select * from cart
                    where customer_id = ? and cart_status = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, customerId);
            preparedStatement.setObject(2, CartStatus.UNPAID, Types.OTHER);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            Cart cart = new Cart(customerId, CartStatus.UNPAID);
            cart.setId(resultSet.getLong("id"));
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> loadBookForCart(long cartId) {
        List<Book> books = new ArrayList<>();
        String query = """
                    select * from cart_products
                    inner join cart c on c.id = cart_products.cart_id
                    inner join product p on p.id = cart_products.product_id
                    inner join book b on p.id = b.product_id
                    where cart_id = ? and cart_status = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, cartId);
            preparedStatement.setObject(2, CartStatus.UNPAID, Types.OTHER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("seller_id"),
                        resultSet.getString("description"), resultSet.getInt(5),
                        resultSet.getFloat(6),
                        BookType.valueOf(resultSet.getString("book_type")),
                        BookSubject.valueOf(resultSet.getString("book_subject")),
                        resultSet.getInt("number_of_pages"), resultSet.getString("author_name"),
                        resultSet.getString("publisher_name"));
                book.setId(resultSet.getInt("product_id"));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Tv> loadTvForCart(long cartId) {
        List<Tv> tvs = new ArrayList<>();
        String query = """
                    select * from cart_products
                    inner join cart c on c.id = cart_products.cart_id
                    inner join product p on p.id = cart_products.product_id
                    inner join tv t on p.id = t.product_id
                    where cart_id = ? and cart_status = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, cartId);
            preparedStatement.setObject(2, CartStatus.UNPAID, Types.OTHER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tv tv = new Tv(resultSet.getInt("seller_id"), resultSet.getString("description"),
                        resultSet.getInt(5), resultSet.getFloat(6),
                        resultSet.getInt("inch"),
                        DisplayType.valueOf(resultSet.getString("display_type")));
                tv.setId(resultSet.getInt("product_id"));
                tvs.add(tv);
            }
            return tvs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Radio> loadRadioForCart(long cartId) {
        List<Radio> radios = new ArrayList<>();
        String query = """
                    select * from cart_products
                    inner join cart c on c.id = cart_products.cart_id
                    inner join product p on p.id = cart_products.product_id
                    inner join radio r on p.id = r.product_id
                    where cart_id = ? and cart_status = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, cartId);
            preparedStatement.setObject(2, CartStatus.UNPAID, Types.OTHER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Radio radio = new Radio(resultSet.getInt("seller_id"),
                        resultSet.getString("description"), resultSet.getInt(5),
                        resultSet.getFloat(6), resultSet.getBoolean("is_cd_player"),
                        resultSet.getBoolean("is_cassette_player"),
                        resultSet.getBoolean("is_flash_player"));
                radio.setId(resultSet.getInt("product_id"));
                radios.add(radio);
            }
            return radios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProductFromCart(int productId, long cartId) {
        String query = """
                    delete from cart_products
                    where product_id = ? and cart_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, productId);
            preparedStatement.setLong(2, cartId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
