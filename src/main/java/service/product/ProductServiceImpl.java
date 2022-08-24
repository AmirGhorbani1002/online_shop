package service.product;

import entity.product.Product;
import repository.product.ProductRepositoryImpl;
import service.product.base_interfaces.ProductService;

public class ProductServiceImpl implements ProductService {

    private final ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public Product save(Product product, int id){
        return productRepository.save(product, id);
    }

    @Override
    public void update(long productId, int quantity){
        productRepository.update(productId, quantity);
    }

    @Override
    public int loaProductQuantity(long productId){
        return productRepository.loaProductQuantity(productId);
    }

}
