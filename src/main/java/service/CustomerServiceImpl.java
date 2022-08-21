package service;

import entity.Customer;
import entity.enums.CustomerType;
import repository.CustomerRepositoryImpl;

public class CustomerServiceImpl {

    private final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    public boolean save(String username, String password, long id) {
        if (load(username, password) == null) {
            customerRepository.save(username, password, id);
            return true;
        } else {
            return false;
        }
    }

    public Customer load(String username, String password) {
        return customerRepository.load(username, password);
    }
}
