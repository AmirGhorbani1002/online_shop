package entity;

import entity.enums.CartStatus;
import entity.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private long id;
    private long customerId;
    private final List<Product> products = new ArrayList<>();
    private CartStatus cartStatus;
    private float totalAmount;

    public Cart(long customerId, CartStatus cartStatus) {
        this.customerId = customerId;
        this.cartStatus = cartStatus;
    }

    public Cart() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
