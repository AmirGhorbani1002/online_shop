package service.person;

import entity.Customer;
import repository.person.CustomerRepositoryImpl;
import service.product.electronic_appliances.RadioServiceImpl;
import service.product.electronic_appliances.TvServiceImpl;
import service.product.readable.BookServiceImpl;
import service.product.shoes.ShoesServiceImpl;

public class CustomerServiceImpl {

    private final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    private final BookServiceImpl bookService = new BookServiceImpl();
    private final ShoesServiceImpl shoesService = new ShoesServiceImpl();
    private final TvServiceImpl tvService = new TvServiceImpl();
    private final RadioServiceImpl radioService = new RadioServiceImpl();

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

    public void loadBooks(){
        System.out.println(bookService.loadAllForCustomer());
    }

    public void loadShoes(){
        System.out.println(shoesService.loadAllForCustomer());
    }

    public void loadTvs(){
        System.out.println(tvService.loadAllForCustomer());
    }

    public void loadRadios(){
        System.out.println(radioService.loadAllForCustomer());
    }
}
