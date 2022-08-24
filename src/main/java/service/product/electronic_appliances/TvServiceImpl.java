package service.product.electronic_appliances;

import entity.enums.product.tv.DisplayType;
import entity.product.Tv;
import repository.product.electronic_appliances.TvRepositoryImpl;

import java.util.List;

public class TvServiceImpl {

    private final TvRepositoryImpl tvRepository = new TvRepositoryImpl();

    public void save(int inch, DisplayType displayType, int id) {
        tvRepository.save(inch, displayType, id);
    }

    public Tv load(int productId) {
        return tvRepository.load(productId);
    }

    public List<Tv> loadAllForSeller(int sellerId) {
        return tvRepository.loadAllForSeller(sellerId);
    }

    public List<Tv> loadAllForCustomer() {
        return tvRepository.loadAllForCustomer();
    }

}
