package service.cart;

import entity.Cart;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Tv;
import repository.cart.CartRepositoryImpl;

import java.util.List;

public class CartServiceImpl {

    private final CartRepositoryImpl cartRepository = new CartRepositoryImpl();

    public void save(long customerId){
        cartRepository.save(customerId);
    }

    public void saveProduct(int productId, long cartId, int quantity, float price){
        cartRepository.saveProduct(productId, cartId, quantity, price);
    }

    public Cart loadPending(long customerId){
        return cartRepository.loadPending(customerId);
    }

    public List<Book> loadBookForCart(long cartId){
        return cartRepository.loadBookForCart(cartId);
    }

    public List<Tv> loadTvForCart(long cartId){
        return cartRepository.loadTvForCart(cartId);
    }

    public List<Radio> loadRadioForCart(long cartId){
        return cartRepository.loadRadioForCart(cartId);
    }

    public void deleteProductFromCart(int productId, long cartId){
        cartRepository.deleteProductFromCart(productId, cartId);
    }

}
