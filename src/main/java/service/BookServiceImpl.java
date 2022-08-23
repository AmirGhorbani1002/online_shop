package service;

import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;
import repository.BookRepositoryImpl;

public class BookServiceImpl {

    private final BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    public void save(BookType type, BookSubject subject, int numberOfPages, String authorName, String publisherName){
        bookRepository.save(type, subject, numberOfPages, authorName, publisherName);
    }

}
