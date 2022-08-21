package view;

import entity.Seller;

public class SellerMenu {

    public void showMenu(Seller seller){
        System.out.println("Welcome " + seller.getFirstname() + " " + seller.getLastname());
    }

}
