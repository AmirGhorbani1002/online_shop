package repository.product.shoes.interfaces;

import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;

public interface ShoesRepository {

    void save(int[] sizes, Color color, ShoesType type, int id);

}
