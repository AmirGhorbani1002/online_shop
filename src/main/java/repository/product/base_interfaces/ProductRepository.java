package repository.product.base_interfaces;

import entity.product.Product;

public interface ProductRepository {

    Product save(Product product, int id);
    int loaProductQuantity(long productId);
    void update(long productId, int quantity);

}
