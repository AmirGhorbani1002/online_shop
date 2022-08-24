package service.product;

import entity.product.Product;
import repository.product.ProductRepositoryImpl;

public class ProductServiceImpl {

    private final ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    public Product save(Product product, int id){
        return productRepository.save(product, id);
    }

    public void update(long productId, int quantity){
        productRepository.update(productId, quantity);
    }

    public int loaProductQuantity(long productId){
        return productRepository.loaProductQuantity(productId);
    }

}
