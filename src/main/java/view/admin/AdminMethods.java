package view.admin;

import entity.Admin;
import service.person.AdminServiceImpl;

import java.util.Scanner;

public class AdminMethods {

    private final Scanner scanner = new Scanner(System.in);
    private final AdminServiceImpl adminService = new AdminServiceImpl();

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        Admin admin = adminService.load(username, password);
        if (admin != null) {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.showMenu(admin);
        } else {
            System.out.println("This username was not found with this password");
        }
    }

}
