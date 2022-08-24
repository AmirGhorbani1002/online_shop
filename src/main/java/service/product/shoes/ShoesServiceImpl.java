package service.product.shoes;

import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;
import entity.product.Shoes;
import repository.product.shoes.ShoesRepositoryImpl;
import service.product.base_interfaces.Loading;
import service.product.shoes.interfaces.ShoesService;

import java.util.List;

public class ShoesServiceImpl implements Loading<Shoes>, ShoesService {

    private final ShoesRepositoryImpl shoesRepository = new ShoesRepositoryImpl();

    @Override
    public void save(int[] sizes, Color color, ShoesType type, int id) {
        shoesRepository.save(sizes, color, type, id);
    }

    @Override
    public Shoes load(int productId){
        return shoesRepository.load(productId);
    }

    @Override
    public List<Shoes> loadAllForSeller(int sellerId) {
        return shoesRepository.loadAllForSeller(sellerId);
    }

    @Override
    public List<Shoes> loadAllForCustomer() {
        return shoesRepository.loadAllForCustomer();
    }

}
