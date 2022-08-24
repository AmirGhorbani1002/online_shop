package view.customer;

import entity.Cart;
import entity.Customer;
import entity.Person;
import entity.product.Book;
import entity.product.Radio;
import entity.product.Tv;
import service.cart.CartServiceImpl;
import service.person.CustomerServiceImpl;
import service.person.PersonServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CustomerMethods {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final PersonServiceImpl personService = new PersonServiceImpl();
    private final CartServiceImpl cartService = new CartServiceImpl();

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
        String password;
        while (true) {
            System.out.print("Enter your password: ");
            password = scanner.next();
            System.out.print("Again enter your password: ");
            String againPassword = scanner.next();
            if (Objects.equals(password, againPassword))
                break;
        }
        if (customerService.save(username, password, person.getPersonId())) {
            CustomerMenu customerMenu = new CustomerMenu();
            //customerMenu.showMenu(customerService.load(username, password));
        }
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        Customer customer = customerService.load(username, password);
        if (customer != null) {
            CustomerMenu customerMenu = new CustomerMenu();
            Cart cart = cartService.loadPending(customer.getId());
            if (cart == null) {
                cartService.save(customer.getId());
                cart = cartService.loadPending(customer.getId());
            } else {
                loadProductsForCustomerCart(cart);
            }
            customerMenu.showMenu(customer, cart);
        } else {
            System.out.println("This username was not found with this password");
        }
    }

    public void showBooks(long customerId, Cart cart) {
        System.out.println("This is our books");
        customerService.loadBooks();
        System.out.print("Enter the ID of the product you want: ");
        int productId = scanner.nextInt();
        addBookToCart(productId, customerId, cart);
    }

    public void showTvs(long customerId, Cart cart) {
        System.out.println("This is our tvs");
        customerService.loadTvs();
        System.out.print("Enter the ID of the product you want: ");
        int productId = scanner.nextInt();
        addTvToCart(productId, customerId, cart);
    }

    public void showRadios(long customerId, Cart cart) {
        System.out.println("This is our radios");
        customerService.loadRadios();
        System.out.print("Enter the ID of the product you want: ");
        int productId = scanner.nextInt();
        addRadioToCart(productId, customerId, cart);
    }

    public void showShoes() {
        System.out.println("This is our shoes");
        customerService.loadShoes();
    }

    public void showAll() {
        /*showBooks();
        showTvs();
        showRadios();
        showShoes();*/
    }

    private void loadProductsForCustomerCart(Cart cart) {
        List<Book> books = cartService.loadBookForCart(cart.getId());
        List<Tv> tvs = cartService.loadTvForCart(cart.getId());
        List<Radio> radios = cartService.loadRadioForCart(cart.getId());
        cart.getProducts().addAll(0, books);
        cart.getProducts().addAll(0, tvs);
        cart.getProducts().addAll(0, radios);
    }

    private void addBookToCart(int productId, long customerId, Cart cart) {
        if (customerService.checkExistProduct(productId, "book")) {
            System.out.print("How much do you want? ");
            int quantity = scanner.nextInt();
            customerService.addBookToCart(productId, quantity, customerId, cart);
        }
    }

    private void addTvToCart(int productId, long customerId, Cart cart) {
        if (customerService.checkExistProduct(productId, "tv")) {
            System.out.print("How much do you want? ");
            int quantity = scanner.nextInt();
            customerService.addTvToCart(productId, quantity, customerId, cart);
        }
    }

    private void addRadioToCart(int productId, long customerId, Cart cart) {
        if (customerService.checkExistProduct(productId, "tv")) {
            System.out.print("How much do you want? ");
            int quantity = scanner.nextInt();
            customerService.addRadioToCart(productId, quantity, customerId, cart);
        }
    }

}
