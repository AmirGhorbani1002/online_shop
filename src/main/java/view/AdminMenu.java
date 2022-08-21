package view;

import entity.Admin;

public class AdminMenu {

    public void showMenu(Admin admin){
        System.out.println("Welcome " + admin.getFirstname() + " " + admin.getLastname());
    }

}
