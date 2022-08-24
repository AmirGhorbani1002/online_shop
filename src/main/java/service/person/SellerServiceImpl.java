package service.person;

import entity.Seller;
import entity.enums.product.ProductType;
import repository.person.SellerRepositoryImpl;
import service.person.interfaces.SellerService;

public class SellerServiceImpl implements SellerService {

    private final SellerRepositoryImpl sellerRepository = new SellerRepositoryImpl();

    @Override
    public boolean save(String username, String password, ProductType type, long id,String company) {
        if (load(username, password) == null) {
            sellerRepository.save(username, password, type, id, company);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Seller load(String username, String password) {
        return sellerRepository.load(username, password);
    }

}
