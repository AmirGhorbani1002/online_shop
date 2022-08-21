package view;

import entity.Admin;
import entity.Customer;

public class CustomerMenu {

    public void showMenu(Customer customer){
        System.out.println("Welcome " + customer.getFirstname() + " " + customer.getLastname());
    }

}
