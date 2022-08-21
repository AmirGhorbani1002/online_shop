package service;

import entity.Admin;
import repository.AdminRepositoryImpl;

public class AdminServiceImpl {

    private final AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();

    public Admin load(String username, String password){
        return adminRepository.load(username, password);
    }

}
