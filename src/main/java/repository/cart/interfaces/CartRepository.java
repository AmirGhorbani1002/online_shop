package repository.cart.interfaces;

import entity.Cart;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Shoes;
import entity.product.Tv;

import java.util.List;

public interface CartRepository {

    void save(long customerId);
    long saveProduct(int productId, long cartId, int quantity, float price);
    void saveShoesSize(int size, long cart_products_id);
    Cart loadPending(long customerId);
    List<Book> loadBookForCart(long cartId);
    List<Tv> loadTvForCart(long cartId);
    List<Radio> loadRadioForCart(long cartId);
    List<Shoes> loadShoesForCart(long cartId);
    void deleteProductFromCart(int productId, long cartId);
    void update(long cartId);
}
