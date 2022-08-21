package entity;

import entity.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Product> products = new ArrayList<>();
    private float totalAmount;

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
}
