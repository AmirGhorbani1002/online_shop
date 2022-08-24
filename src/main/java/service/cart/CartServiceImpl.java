package service.cart;

import entity.Cart;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Shoes;
import entity.product.Tv;
import repository.cart.CartRepositoryImpl;
import service.cart.interfaces.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    private final CartRepositoryImpl cartRepository = new CartRepositoryImpl();

    @Override
    public void save(long customerId) {
        cartRepository.save(customerId);
    }

    @Override
    public long saveProduct(int productId, long cartId, int quantity, float price) {
        return cartRepository.saveProduct(productId, cartId, quantity, price);
    }

    @Override
    public void saveShoesSize(int size, long cart_products_id) {
        cartRepository.saveShoesSize(size, cart_products_id);
    }

    @Override
    public Cart loadPending(long customerId) {
        return cartRepository.loadPending(customerId);
    }

    @Override
    public List<Book> loadBookForCart(long cartId) {
        return cartRepository.loadBookForCart(cartId);
    }

    @Override
    public List<Tv> loadTvForCart(long cartId) {
        return cartRepository.loadTvForCart(cartId);
    }

    @Override
    public List<Radio> loadRadioForCart(long cartId) {
        return cartRepository.loadRadioForCart(cartId);
    }

    @Override
    public List<Shoes> loadShoesForCart(long cartId) {
        return cartRepository.loadShoesForCart(cartId);
    }

    @Override
    public void deleteProductFromCart(int productId, long cartId) {
        cartRepository.deleteProductFromCart(productId, cartId);
    }

    @Override
    public void update(long cartId){
        cartRepository.update(cartId);
    }

}
