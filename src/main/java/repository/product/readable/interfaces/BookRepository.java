package repository.product.readable.interfaces;

import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;

public interface BookRepository {

    void save(BookType type, BookSubject subject, int numberOfPages, String authorName, String publisherName, int id);

}
