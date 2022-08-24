package service.product.shoes.interfaces;

import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;

public interface ShoesService {

    void save(int[] sizes, Color color, ShoesType type, int id);

}
