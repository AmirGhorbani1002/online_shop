package service.product;

import entity.product.Product;
import repository.product.ProductRepositoryImpl;

public class ProductServiceImpl {

    private final ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    public Product save(Product product, int id){
        return productRepository.save(product, id);
    }

}
