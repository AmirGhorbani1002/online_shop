package service.person;

import entity.Cart;
import entity.Customer;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Tv;
import repository.person.CustomerRepositoryImpl;
import service.cart.CartServiceImpl;
import service.product.electronic_appliances.RadioServiceImpl;
import service.product.electronic_appliances.TvServiceImpl;
import service.product.readable.BookServiceImpl;
import service.product.shoes.ShoesServiceImpl;

import java.util.Objects;

public class CustomerServiceImpl {

    private final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    private final BookServiceImpl bookService = new BookServiceImpl();
    private final ShoesServiceImpl shoesService = new ShoesServiceImpl();
    private final TvServiceImpl tvService = new TvServiceImpl();
    private final RadioServiceImpl radioService = new RadioServiceImpl();
    private final CartServiceImpl cartService = new CartServiceImpl();

    public boolean save(String username, String password, long id) {
        if (load(username, password) == null) {
            customerRepository.save(username, password, id);
            return true;
        } else {
            return false;
        }
    }

    public Customer load(String username, String password) {
        return customerRepository.load(username, password);
    }

    public void loadBooks() {
        System.out.println(bookService.loadAllForCustomer());
    }

    public void loadShoes() {
        System.out.println(shoesService.loadAllForCustomer());
    }

    public void loadTvs() {
        System.out.println(tvService.loadAllForCustomer());
    }

    public void loadRadios() {
        System.out.println(radioService.loadAllForCustomer());
    }

    public void addBookToCart(int productId, int quantity, long customerId, Cart cart) {
        Book book = bookService.load(productId);
        book.setQuantity(quantity);
        cart.getProducts().add(book);
        float price = quantity * book.getPrice();
        cartService.saveProduct(productId, cart.getId(), quantity, price);
    }

    public void addTvToCart(int productId, int quantity, long customerId, Cart cart) {
        Tv tv = tvService.load(productId);
        tv.setQuantity(quantity);
        cart.getProducts().add(tv);
        float price = quantity * tv.getPrice();
        cartService.saveProduct(productId, cart.getId(), quantity, price);
    }

    public void addRadioToCart(int productId, int quantity, long customerId, Cart cart) {
        Radio radio = radioService.load(productId);
        radio.setQuantity(quantity);
        cart.getProducts().add(radio);
        float price = quantity * radio.getPrice();
        cartService.saveProduct(productId, cart.getId(), quantity, price);
    }

    public boolean checkExistProduct(int productId, String type) {
        if (Objects.equals(type, "book")) {
            return bookService.load(productId) != null;
        } else if(Objects.equals(type, "tv")){
            return tvService.load(productId) != null;
        } else if(Objects.equals(type, "radio")){
            return radioService.load(productId) != null;
        } else return true;
    }


}
