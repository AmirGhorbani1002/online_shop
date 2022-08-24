package view.customer;

import entity.Cart;
import entity.Customer;

import java.util.Objects;
import java.util.Scanner;

public class CustomerMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerMethods customerMethods = new CustomerMethods();

    public void showMenu(Customer customer, Cart cart) {
        label:
        while (true) {
            System.out.println("Welcome " + customer.getFirstname() + " " + customer.getLastname());
            System.out.print("Enter your command (Enter help for get information about commands): ");
            String[] command = scanner.nextLine().split(" ");
            if(command.length > 2){
                System.out.println("Wrong command");
                return;
            }
            switch (command[0].toLowerCase()) {
                case "view":
                    switch (command[1].toLowerCase()) {
                        case "cart" -> customerMethods.showCart(cart);
                        case "book" -> customerMethods.showBooks(customer.getId(), cart);
                        case "tv" -> customerMethods.showTvs(customer.getId(), cart);
                        case "radio" -> customerMethods.showRadios(customer.getId(), cart);
                        case "shoes" -> customerMethods.showShoes(customer.getId(), cart);
                        default -> System.out.println("Wrong command");
                    }
                    break;
                case "exit":
                    break label;
                case "help":
                    helpMenu();
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }

    }

    private void helpMenu() {
        System.out.println("view book                 (for view book)");
        System.out.println("view tv                   (for view tv)");
        System.out.println("view Radio                (for view Radio)");
        System.out.println("view Shoes                (for view Shoes)");
        System.out.println("view cart                 (for view cart)");
        System.out.println("exit                      (for exit)");
    }

}
