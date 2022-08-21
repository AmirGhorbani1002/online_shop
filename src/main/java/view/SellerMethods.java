package view;

import entity.Customer;
import entity.Person;
import entity.Seller;
import entity.enums.product.ProductType;
import service.PersonServiceImpl;
import service.SellerServiceImpl;

import java.util.Objects;
import java.util.Scanner;

public class SellerMethods {

    private final Scanner scanner = new Scanner(System.in);
    private final SellerServiceImpl sellerService = new SellerServiceImpl();
    private final PersonServiceImpl personService = new PersonServiceImpl();

    public void signup() {
        System.out.print("Enter your national code: ");
        String nationalCode = scanner.next();
        if (personService.loadByNationalCode(nationalCode) == null) {
            System.out.print("Enter your firstname: ");
            String firstname = scanner.next();
            System.out.print("Enter your lastname: ");
            String lastname = scanner.next();
            personService.save(firstname, lastname, nationalCode);
        }
        Person person = personService.loadByNationalCode(nationalCode);
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your product type: ");
        ProductType type = ProductType.valueOf(scanner.next().toUpperCase());
        String password;
        while (true) {
            System.out.print("Enter your password: ");
            password = scanner.next();
            System.out.print("Again enter your password: ");
            String againPassword = scanner.next();
            if (Objects.equals(password, againPassword))
                break;
        }
        if (sellerService.save(username, password,type, person.getId())) {
            SellerMenu sellerMenu = new SellerMenu();
            sellerMenu.showMenu(sellerService.load(username, password));
        }
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        Seller seller = sellerService.load(username, password);
        if (seller != null) {
            SellerMenu sellerMenu = new SellerMenu();
            sellerMenu.showMenu(seller);
        } else {
            System.out.println("This username was not found with this password");
        }
    }

}
