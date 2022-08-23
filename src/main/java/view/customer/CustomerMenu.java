package view.customer;

import entity.Customer;

import java.util.Objects;
import java.util.Scanner;

public class CustomerMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerMethods customerMethods = new CustomerMethods();

    public void showMenu(Customer customer){
        while(true){
            System.out.println("Welcome " + customer.getFirstname() + " " + customer.getLastname());
            System.out.print("Enter your command (Enter help for get information about commands): ");
            String[] command = scanner.nextLine().split(" ");
            if(Objects.equals(command[0].toLowerCase(), "view")){
                if(Objects.equals(command[1].toLowerCase(), "all")){

                } else if(Objects.equals(command[1].toLowerCase(), "cart")){

                } else if(Objects.equals(command[1].toLowerCase(), "book")){
                    customerMethods.showBooks();
                } else if(Objects.equals(command[1].toLowerCase(), "tv")){
                    customerMethods.showTvs();
                } else if(Objects.equals(command[1].toLowerCase(), "radio")){
                    customerMethods.showRadios();
                } else if(Objects.equals(command[1].toLowerCase(), "shoes")){
                    customerMethods.showShoes();
                }
            } else if(Objects.equals(command[0].toLowerCase(), "exit")){
                break;
            }
        }

    }

}
