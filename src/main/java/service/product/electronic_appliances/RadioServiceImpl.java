package service.product.electronic_appliances;

import entity.product.Radio;
import repository.product.electronic_appliances.RadioRepositoryImpl;

import java.util.List;

public class RadioServiceImpl {

    private final RadioRepositoryImpl radioRepository = new RadioRepositoryImpl();

    public void save(boolean cdPlayer, boolean cassettePlayer, boolean flashPlayer, int id) {
        radioRepository.save(cdPlayer, cassettePlayer, flashPlayer, id);
    }

    public Radio load(int productId){
        return radioRepository.load(productId);
    }

    public List<Radio> loadAllForSeller(int sellerId) {
        return radioRepository.loadAllForSeller(sellerId);
    }

    public List<Radio> loadAllForCustomer() {
        return radioRepository.loadAllForCustomer();
    }

}
