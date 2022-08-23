package service.shoes;

import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;
import entity.product.Shoes;
import repository.shoes.ShoesRepositoryImpl;

import java.util.List;

public class ShoesServiceImpl {

    private final ShoesRepositoryImpl shoesRepository = new ShoesRepositoryImpl();

    public void save(int[] sizes, Color color, ShoesType type, int id) {
        shoesRepository.save(sizes, color, type, id);
    }

    public List<Shoes> load(int sellerId){
        return shoesRepository.load(sellerId);
    }

}
