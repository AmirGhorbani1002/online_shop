package service.product.electronic_appliances;

import entity.enums.product.tv.DisplayType;
import entity.product.Tv;
import repository.product.electronic_appliances.TvRepositoryImpl;
import service.product.base_interfaces.Loading;
import service.product.electronic_appliances.interfaces.TvService;

import java.util.List;

public class TvServiceImpl implements Loading<Tv>, TvService {

    private final TvRepositoryImpl tvRepository = new TvRepositoryImpl();

    @Override
    public void save(int inch, DisplayType displayType, int id) {
        tvRepository.save(inch, displayType, id);
    }

    @Override
    public Tv load(int productId) {
        return tvRepository.load(productId);
    }

    @Override
    public List<Tv> loadAllForSeller(int sellerId) {
        return tvRepository.loadAllForSeller(sellerId);
    }

    @Override
    public List<Tv> loadAllForCustomer() {
        return tvRepository.loadAllForCustomer();
    }

}
