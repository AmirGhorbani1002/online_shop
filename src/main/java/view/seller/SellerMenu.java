package view.seller;

import entity.Seller;
import entity.enums.product.ProductType;

import java.util.Objects;
import java.util.Scanner;

public class SellerMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final SellerMethods sellerMethods = new SellerMethods();

    public void showMenu(Seller seller) {
        while (true) {
            System.out.println("Welcome Seller " + seller.getFirstname() + " " + seller.getLastname());
            System.out.print("Enter your command (Enter help for get information about commands: ");
            String[] command = scanner.nextLine().split(" ");
            if (command.length > 1) {
                System.out.println("Wrong command");
                return;
            }
            if (Objects.equals(command[0], "add")) {
                System.out.println(seller.getProductType().name());
                if (seller.getProductType() == ProductType.ELECTRONIC_APPLIANCES) {
                    sellerMethods.addElectronicAppliances(seller);
                } else if (seller.getProductType() == ProductType.READABLE) {
                    sellerMethods.addReadable(seller);
                } else if (seller.getProductType() == ProductType.SHOES) {
                    sellerMethods.addShoes(seller);
                }
            } else if (Objects.equals(command[0], "show")) {
                sellerMethods.showProductsInformation(seller);
            } else if (Objects.equals(command[0], "help")) {
                helpMenu();
            } else if (Objects.equals(command[0], "exit")) {
                break;
            } else {
                System.out.println("Wrong command");
            }
        }
    }

    private void helpMenu() {
        System.out.println("add                   (for add product)");
        System.out.println("show                  (for show product)");
        System.out.println("exit                  (for exit)");
    }

}
