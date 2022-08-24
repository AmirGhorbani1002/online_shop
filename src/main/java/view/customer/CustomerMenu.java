package view.customer;

import entity.Cart;
import entity.Customer;

import java.util.Objects;
import java.util.Scanner;

public class CustomerMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerMethods customerMethods = new CustomerMethods();

    public void showMenu(Customer customer, Cart cart){
        while(true){
            System.out.println("Welcome " + customer.getFirstname() + " " + customer.getLastname());
            System.out.print("Enter your command (Enter help for get information about commands): ");
            String[] command = scanner.nextLine().split(" ");
            if(Objects.equals(command[0].toLowerCase(), "view")){
                if(Objects.equals(command[1].toLowerCase(), "all")){
                    customerMethods.showAll();
                } else if(Objects.equals(command[1].toLowerCase(), "cart")){
                    customerMethods.showCart(cart);
                } else if(Objects.equals(command[1].toLowerCase(), "book")){
                    customerMethods.showBooks(customer.getId(),cart);
                } else if(Objects.equals(command[1].toLowerCase(), "tv")){
                    customerMethods.showTvs(customer.getId(),cart);
                } else if(Objects.equals(command[1].toLowerCase(), "radio")){
                    customerMethods.showRadios(customer.getId(),cart);
                } else if(Objects.equals(command[1].toLowerCase(), "shoes")){
                    customerMethods.showShoes(customer.getId(),cart);
                }
            } else if(Objects.equals(command[0].toLowerCase(), "exit")){
                break;
            }
        }

    }

}
