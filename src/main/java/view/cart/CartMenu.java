package view.cart;

import entity.Cart;

import java.util.Scanner;

public class CartMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final CartMethods cartMethods = new CartMethods();

    public void showMenu(Cart cart) {
        while (true) {
            cartMethods.showProducts(cart);
            System.out.print("Enter your command (Enter help for get information about commands): ");
            String[] command = scanner.nextLine().split(" ");
            if (command.length > 2) {
                System.out.println("Wrong command");
                return;
            }
            if (command[0].equalsIgnoreCase("delete")) {
                cartMethods.deleteProduct(cart, command[1]);
            } else if (command[0].equalsIgnoreCase("paid")) {
                cartMethods.paidCart(cart);
                break;
            } else if (command[0].equalsIgnoreCase("price")) {
                cartMethods.showPrice(cart);
            } else if (command[0].equalsIgnoreCase("help")) {
                helpMenu();
            } else if (command[0].equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    private void helpMenu() {
        System.out.println("delete id                 (for delete product)");
        System.out.println("price                     (for see total price)");
        System.out.println("paid                      (for pay cart)");
        System.out.println("exit                      (for exit)");
    }

}
