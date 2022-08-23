package repository.product.readable;

import config.DBConfig;
import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;
import entity.product.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl {

    public void save(BookType type, BookSubject subject, int numberOfPages, String authorName, String publisherName, int id) {
        String query = """
                    insert into book(book_type, book_subject, author_name, publisher_name, product_id, number_of_pages)
                    values (?,?,?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setObject(1, type, Types.OTHER);
            preparedStatement.setObject(2, subject, Types.OTHER);
            preparedStatement.setString(3, authorName);
            preparedStatement.setString(4, publisherName);
            preparedStatement.setInt(5, id);
            preparedStatement.setInt(6, numberOfPages);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> loadForSeller(int sellerId) {
        List<Book> books = new ArrayList<>();
        String query = """
                    select * from book
                    inner join product p on p.id = book.product_id
                    where seller_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, sellerId);
            return getBooks(books, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> loadAllForCustomer() {
        List<Book> books = new ArrayList<>();
        String query = """
                    select * from book
                    inner join product p on p.id = book.product_id
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            return getBooks(books, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Book> getBooks(List<Book> books, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Book book = new Book(resultSet.getInt("seller_id"),
                    resultSet.getString("description"), resultSet.getInt("quantity"),
                    resultSet.getFloat("price"),
                    BookType.valueOf(resultSet.getString("book_type")),
                    BookSubject.valueOf(resultSet.getString("book_subject")),
                    resultSet.getInt("number_of_pages"),resultSet.getString("author_name"),
                    resultSet.getString("publisher_name"));
            book.setId(resultSet.getInt("product_id"));
            books.add(book);
        }
        return books;
    }

}
