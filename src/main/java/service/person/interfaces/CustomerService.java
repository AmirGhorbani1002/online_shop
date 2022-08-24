package service.person.interfaces;

import entity.Cart;
import entity.Customer;

public interface CustomerService {

    void save(String username, String password, long id);
    Customer load(String username, String password);
    void loadBooks();
    void loadShoes();
    void loadTvs();
    void loadRadios();
    void addBookToCart(int productId, int quantity, long customerId, Cart cart);
    void addTvToCart(int productId, int quantity, long customerId, Cart cart);
    void addRadioToCart(int productId, int quantity, long customerId, Cart cart);
    void addShoesToCart(int productId, int quantity, long customerId, Cart cart, int size);
    int checkExistProduct(int productId, String type);
}
