package repository.product.electronic_appliances.interfaces;

import entity.enums.product.tv.DisplayType;

public interface TvRepository {

    void save(int inch, DisplayType displayType, int id);

}
