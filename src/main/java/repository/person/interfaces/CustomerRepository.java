package repository.person.interfaces;

import entity.Customer;

public interface CustomerRepository {

    void save(String username, String password, long id);
    Customer load(String username, String password);

}
