package service;

import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;
import repository.ShoesRepositoryImpl;

import java.util.List;

public class ShoesServiceImpl {

    private final ShoesRepositoryImpl shoesRepository = new ShoesRepositoryImpl();

    public void save(int[] sizes, Color color, ShoesType type, int id) {
        shoesRepository.save(sizes, color, type, id);
    }

}
