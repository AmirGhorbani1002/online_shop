package service.product.electronic_appliances;

import entity.product.Radio;
import repository.product.electronic_appliances.RadioRepositoryImpl;
import service.product.base_interfaces.Loading;
import service.product.electronic_appliances.interfaces.RadioService;

import java.util.List;

public class RadioServiceImpl implements Loading<Radio>, RadioService {

    private final RadioRepositoryImpl radioRepository = new RadioRepositoryImpl();

    @Override
    public void save(boolean cdPlayer, boolean cassettePlayer, boolean flashPlayer, int id) {
        radioRepository.save(cdPlayer, cassettePlayer, flashPlayer, id);
    }

    @Override
    public Radio load(int productId){
        return radioRepository.load(productId);
    }

    @Override
    public List<Radio> loadAllForSeller(int sellerId) {
        return radioRepository.loadAllForSeller(sellerId);
    }

    @Override
    public List<Radio> loadAllForCustomer() {
        return radioRepository.loadAllForCustomer();
    }

}
