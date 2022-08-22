package service;

import entity.enums.product.tv.DisplayType;
import repository.TvRepositoryImpl;

public class TvServiceImpl {

    private final TvRepositoryImpl tvRepository = new TvRepositoryImpl();

    public void save(int inch, DisplayType displayType, int id) {
        tvRepository.save(inch, displayType, id);
    }

}
