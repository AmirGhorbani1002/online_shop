package service.readable;

import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;
import entity.product.Book;
import repository.readable.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl {

    private final BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    public void save(BookType type, BookSubject subject, int numberOfPages, String authorName, String publisherName, int id){
        bookRepository.save(type, subject, numberOfPages, authorName, publisherName, id);
    }

    public List<Book> load(int sellerId){
        return bookRepository.load(sellerId);
    }

}
