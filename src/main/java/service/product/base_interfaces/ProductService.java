package service.product.base_interfaces;

import entity.product.Product;

public interface ProductService {

    Product save(Product product, int id);
    void update(long productId, int quantity);
    int loaProductQuantity(long productId);
}
