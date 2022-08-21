package view;

import entity.Person;
import entity.enums.CustomerType;
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
        if (customerService.save(username, password, person.getId())) {
            CustomerMenu customerMenu = new CustomerMenu();
            customerMenu.showMenu(customerService.load(username, password));
        }
    }

}
