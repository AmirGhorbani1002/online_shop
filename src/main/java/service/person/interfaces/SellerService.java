package service.person.interfaces;

import entity.Seller;
import entity.enums.product.ProductType;

public interface SellerService {

    boolean save(String username, String password, ProductType type, long id, String company);
    Seller load(String username, String password);
}
