package repository;

import config.DBConfig;
import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class BookRepositoryImpl {

    public void save(BookType type, BookSubject subject, int numberOfPages, String authorName, String publisherName) {
        String query = """
                    insert into book(book_type, book_subject, author_name, publisher_name, product_id)
                    values (?,?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setObject(1,type, Types.OTHER);
            preparedStatement.setObject(2,subject, Types.OTHER);
            preparedStatement.setInt(3,numberOfPages);
            preparedStatement.setString(4,authorName);
            preparedStatement.setString(5,publisherName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
