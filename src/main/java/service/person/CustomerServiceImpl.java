package service.person;

import entity.Cart;
import entity.Customer;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Shoes;
import entity.product.Tv;
import repository.person.CustomerRepositoryImpl;
import service.cart.CartServiceImpl;
import service.person.interfaces.CustomerService;
import service.product.electronic_appliances.RadioServiceImpl;
import service.product.electronic_appliances.TvServiceImpl;
import service.product.readable.BookServiceImpl;
import service.product.shoes.ShoesServiceImpl;

import java.util.Objects;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    private final BookServiceImpl bookService = new BookServiceImpl();
    private final ShoesServiceImpl shoesService = new ShoesServiceImpl();
    private final TvServiceImpl tvService = new TvServiceImpl();
    private final RadioServiceImpl radioService = new RadioServiceImpl();
    private final CartServiceImpl cartService = new CartServiceImpl();

    public void save(String username, String password, long id) {
        if (load(username, password) == null) {
            customerRepository.save(username, password, id);
        }
    }

    @Override
    public Customer load(String username, String password) {
        return customerRepository.load(username, password);
    }

    @Override
    public void loadBooks() {
        System.out.println(bookService.loadAllForCustomer());
    }

    @Override
    public void loadShoes() {
        System.out.println(shoesService.loadAllForCustomer());
    }

    @Override
    public void loadTvs() {
        System.out.println(tvService.loadAllForCustomer());
    }

    @Override
    public void loadRadios() {
        System.out.println(radioService.loadAllForCustomer());
    }

    @Override
    public void addBookToCart(int productId, int quantity, long customerId, Cart cart) {
        Book book = bookService.load(productId);
        book.setQuantity(quantity);
        book.setPrice(book.getPrice() * quantity);
        cart.getProducts().add(book);
        float price = quantity * book.getPrice();
        cartService.saveProduct(productId, cart.getId(), quantity, price);
    }

    @Override
    public void addTvToCart(int productId, int quantity, long customerId, Cart cart) {
        Tv tv = tvService.load(productId);
        tv.setQuantity(quantity);
        tv.setPrice(tv.getPrice() * quantity);
        cart.getProducts().add(tv);
        float price = quantity * tv.getPrice();
        cartService.saveProduct(productId, cart.getId(), quantity, price);
    }

    @Override
    public void addRadioToCart(int productId, int quantity, long customerId, Cart cart) {
        Radio radio = radioService.load(productId);
        radio.setQuantity(quantity);
        radio.setPrice(radio.getPrice() * quantity);
        cart.getProducts().add(radio);
        float price = quantity * radio.getPrice();
        cartService.saveProduct(productId, cart.getId(), quantity, price);
    }

    @Override
    public void addShoesToCart(int productId, int quantity, long customerId, Cart cart, int size) {
        Shoes shoes = shoesService.load(productId);
        shoes.setQuantity(quantity);
        shoes.setPrice(shoes.getPrice() * quantity);
        if (shoes.getSizes().contains(size)) {
            cart.getProducts().add(shoes);
            float price = quantity * shoes.getPrice();
            long cart_product_id = cartService.saveProduct(productId, cart.getId(), quantity, price);
            cartService.saveShoesSize(size, cart_product_id);
        } else {
            System.out.println("Wrong size");
        }
    }

    @Override
    public int checkExistProduct(int productId, String type) {
        if (Objects.equals(type, "book")) {
            if(bookService.load(productId) == null)
                return 0;
            return bookService.load(productId).getQuantity();
        } else if (Objects.equals(type, "tv")) {
            if(tvService.load(productId) == null)
                return 0;
            return tvService.load(productId).getQuantity();
        } else if (Objects.equals(type, "radio")) {
            if(radioService.load(productId) == null)
                return 0;
            return radioService.load(productId).getQuantity();
        } else return 0;
    }
}
