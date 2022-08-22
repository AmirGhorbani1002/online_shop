package view.seller;

import entity.Person;
import entity.Seller;
import entity.enums.product.ProductType;
import entity.enums.product.tv.DisplayType;
import entity.product.Product;
import entity.product.Tv;
import service.PersonServiceImpl;
import service.ProductServiceImpl;
import service.SellerServiceImpl;
import service.TvServiceImpl;

import java.util.Objects;
import java.util.Scanner;

public class SellerMethods {

    private final Scanner scanner = new Scanner(System.in);
    private final SellerServiceImpl sellerService = new SellerServiceImpl();
    private final TvServiceImpl tvService = new TvServiceImpl();

    public void signup() {
        PersonServiceImpl personService = new PersonServiceImpl();
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
        System.out.print("Enter your company: ");
        String company = scanner.next();
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
        if (sellerService.save(username, password, type, person.getPersonId(), company)) {
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

    public void addElectronicAppliances(Seller seller) {
        ProductServiceImpl productService = new ProductServiceImpl();
        System.out.println("Which item? (for now we have tv and radio): ");
        String type = scanner.next();
        System.out.print("Enter description: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        float price = scanner.nextFloat();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        Product product = productService.save(new Product(ProductType.ELECTRONIC_APPLIANCES, seller.getCompany()
                , description, quantity, price), seller.getId());
        if (Objects.equals(type, "tv")) {
            System.out.print("Enter inch: ");
            int inch = scanner.nextInt();
            System.out.print("Enter display type: ");
            String display = scanner.next().toUpperCase();
            tvService.save(inch, DisplayType.valueOf(display), product.getId());
        }

    }

}
