package service.product.electronic_appliances.interfaces;

import entity.enums.product.tv.DisplayType;

public interface TvService {

    void save(int inch, DisplayType displayType, int id);

}
