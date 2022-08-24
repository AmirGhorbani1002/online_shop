package view.customer;

import check.Check;
import entity.Cart;
import entity.Customer;
import entity.Person;
import entity.product.*;
import service.cart.CartServiceImpl;
import service.person.CustomerServiceImpl;
import service.person.PersonServiceImpl;
import service.product.ProductServiceImpl;
import view.cart.CartMenu;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CustomerMethods {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final PersonServiceImpl personService = new PersonServiceImpl();
    private final CartServiceImpl cartService = new CartServiceImpl();
    private final Check check = new Check();

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
        customerService.save(username, password, person.getPersonId());
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

    public void showShoes(long customerId, Cart cart) {
        System.out.println("This is our shoes");
        customerService.loadShoes();
        System.out.print("Enter the ID of the product you want: ");
        int productId = scanner.nextInt();
        addShoesToCart(productId, customerId, cart);
    }

    public void showCart(Cart cart) {
            CartMenu cartMenu = new CartMenu();
            if(cart.getProducts().size() == 0){
                System.out.println("Your cart is empty");
                return;
            }
            cartMenu.showMenu(cart);
    }

    private void loadProductsForCustomerCart(Cart cart) {
        List<Book> books = cartService.loadBookForCart(cart.getId());
        List<Tv> tvs = cartService.loadTvForCart(cart.getId());
        List<Radio> radios = cartService.loadRadioForCart(cart.getId());
        List<Shoes> shoesList = cartService.loadShoesForCart(cart.getId());
        cart.getProducts().addAll(0, books);
        cart.getProducts().addAll(0, tvs);
        cart.getProducts().addAll(0, radios);
        cart.getProducts().addAll(0, shoesList);
    }

    private void addBookToCart(int productId, long customerId, Cart cart) {
        if (cart.getProducts().size() == 5) {
            System.out.println("Your cart is full");
            return;
        }
        int number = customerService.checkExistProduct(productId, "book");
        if (number != 0) {
            System.out.print("How much do you want? ");
            int quantity = check.checkInt(scanner.next(), true);
            if (quantity > number) {
                System.out.println("We don't have that much");
                return;
            }
            customerService.addBookToCart(productId, quantity, customerId, cart);
        } else {
            System.out.println("There is no product with this id");
        }
    }

    private void addTvToCart(int productId, long customerId, Cart cart) {
        if (cart.getProducts().size() == 5) {
            System.out.println("Your cart is full");
            return;
        }
        int number = customerService.checkExistProduct(productId, "tv");
        if (number != 0) {
            System.out.print("How much do you want? ");
            int quantity = scanner.nextInt();
            if (quantity > number) {
                System.out.println("We don't have that much");
                return;
            }
            customerService.addTvToCart(productId, quantity, customerId, cart);
        } else {
            System.out.println("There is no product with this id");
        }
    }

    private void addRadioToCart(int productId, long customerId, Cart cart) {
        if (cart.getProducts().size() == 5) {
            System.out.println("Your cart is full");
            return;
        }
        int number = customerService.checkExistProduct(productId, "radio");
        if (number != 0) {
            System.out.print("How much do you want? ");
            int quantity = scanner.nextInt();
            if (quantity > number) {
                System.out.println("We don't have that much");
                return;
            }
            customerService.addRadioToCart(productId, quantity, customerId, cart);
        } else {
            System.out.println("There is no product with this id");
        }
    }

    private void addShoesToCart(int productId, long customerId, Cart cart) {
        if (cart.getProducts().size() == 5) {
            System.out.println("Your cart is full");
            return;
        }
        int number = customerService.checkExistProduct(productId, "shoes");
        if (number != 0) {
            System.out.print("How much do you want? ");
            int quantity = scanner.nextInt();
            if (quantity > number) {
                System.out.println("We don't have that much");
                return;
            }
            System.out.print("what size?  ");
            int size = check.checkInt(scanner.next(), true);
            customerService.addShoesToCart(productId, quantity, customerId, cart, size);
        } else {
            System.out.println("There is no product with this id");
        }
    }

}
