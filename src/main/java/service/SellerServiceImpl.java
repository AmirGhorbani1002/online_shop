package service;

import entity.Seller;
import entity.enums.product.ProductType;
import repository.SellerRepositoryImpl;

public class SellerServiceImpl {

    private final SellerRepositoryImpl sellerRepository = new SellerRepositoryImpl();

    public boolean save(String username, String password, ProductType type, long id,String company) {
        if (load(username, password) == null) {
            sellerRepository.save(username, password, type, id, company);
            return true;
        } else {
            return false;
        }
    }

    public Seller load(String username, String password) {
        return sellerRepository.load(username, password);
    }

}
