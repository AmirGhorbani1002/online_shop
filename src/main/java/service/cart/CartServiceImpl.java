package service.cart;

import entity.Cart;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Shoes;
import entity.product.Tv;
import repository.cart.CartRepositoryImpl;

import java.util.List;

public class CartServiceImpl {

    private final CartRepositoryImpl cartRepository = new CartRepositoryImpl();

    public void save(long customerId) {
        cartRepository.save(customerId);
    }

    public long saveProduct(int productId, long cartId, int quantity, float price) {
        return cartRepository.saveProduct(productId, cartId, quantity, price);
    }

    public void saveShoesSize(int size, long cart_products_id) {
        cartRepository.saveShoesSize(size, cart_products_id);
    }

    public Cart loadPending(long customerId) {
        return cartRepository.loadPending(customerId);
    }

    public List<Book> loadBookForCart(long cartId) {
        return cartRepository.loadBookForCart(cartId);
    }

    public List<Tv> loadTvForCart(long cartId) {
        return cartRepository.loadTvForCart(cartId);
    }

    public List<Radio> loadRadioForCart(long cartId) {
        return cartRepository.loadRadioForCart(cartId);
    }

    public List<Shoes> loadShoesForCart(long cartId) {
        return cartRepository.loadShoesForCart(cartId);
    }

    public void deleteProductFromCart(int productId, long cartId) {
        cartRepository.deleteProductFromCart(productId, cartId);
    }

    public void update(long cartId){
        cartRepository.update(cartId);
    }

}
