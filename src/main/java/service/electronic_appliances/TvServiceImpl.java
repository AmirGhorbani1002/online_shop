package service.electronic_appliances;

import entity.enums.product.tv.DisplayType;
import entity.product.Tv;
import repository.electronic_appliances.TvRepositoryImpl;

import java.util.List;

public class TvServiceImpl {

    private final TvRepositoryImpl tvRepository = new TvRepositoryImpl();

    public void save(int inch, DisplayType displayType, int id) {
        tvRepository.save(inch, displayType, id);
    }

    public List<Tv> load(int sellerId) {
        return tvRepository.load(sellerId);
    }

}
