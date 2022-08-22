package view.customer;

import entity.Customer;
import entity.Person;
import service.CustomerServiceImpl;
import service.PersonServiceImpl;

import java.util.Objects;
import java.util.Scanner;

public class CustomerMethods {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
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
            customerMenu.showMenu(customerService.load(username, password));
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
            customerMenu.showMenu(customer);
        } else {
            System.out.println("This username was not found with this password");
        }
    }

}
