package service;

import repository.RadioRepositoryImpl;

public class RadioServiceImpl {

    private final RadioRepositoryImpl radioRepository = new RadioRepositoryImpl();

    public void save(boolean cdPlayer, boolean cassettePlayer, boolean flashPlayer, int id){
        radioRepository.save(cdPlayer, cassettePlayer, flashPlayer, id);
    }

}
