package entity.product;

import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;
import entity.enums.product.ProductType;

public class Book extends Product {

    private BookType type;
    private BookSubject subject;
    private int numberOfPages;
    private String authorName;
    private String publisherName;

    public Book(String sellerName, String description, int quantity, float price,
                BookType type, BookSubject subject, int numberOfPages, String authorName, String publisherName) {
        super(ProductType.READABLE, sellerName, description, quantity, price);
        this.type = type;
        this.subject = subject;
        this.numberOfPages = numberOfPages;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public BookSubject getSubject() {
        return subject;
    }

    public void setSubject(BookSubject subject) {
        this.subject = subject;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
