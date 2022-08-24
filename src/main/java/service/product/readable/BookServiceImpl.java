package service.product.readable;

import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;
import entity.product.Book;
import repository.product.readable.BookRepositoryImpl;
import service.product.base_interfaces.Loading;
import service.product.readable.interfaces.BookService;

import java.util.List;

public class BookServiceImpl implements Loading<Book>, BookService {

    private final BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @Override
    public void save(BookType type, BookSubject subject, int numberOfPages, String authorName, String publisherName, int id) {
        bookRepository.save(type, subject, numberOfPages, authorName, publisherName, id);
    }

    @Override
    public Book load(int productId){
        return bookRepository.load(productId);
    }

    @Override
    public List<Book> loadAllForSeller(int sellerId) {
        return bookRepository.loadAllForSeller(sellerId);
    }

    @Override
    public List<Book> loadAllForCustomer() {
        return bookRepository.loadAllForCustomer();
    }

}
