package service.electronic_appliances;

import entity.product.Radio;
import repository.electronic_appliances.RadioRepositoryImpl;

import java.util.List;

public class RadioServiceImpl {

    private final RadioRepositoryImpl radioRepository = new RadioRepositoryImpl();

    public void save(boolean cdPlayer, boolean cassettePlayer, boolean flashPlayer, int id){
        radioRepository.save(cdPlayer, cassettePlayer, flashPlayer, id);
    }

    public List<Radio> load(int sellerId) {
        return radioRepository.load(sellerId);
    }

}
