package entity;

import entity.enums.PersonType;

public class Admin extends Person{
    public Admin(String firstname, String lastname, String nationalCode) {
        super(firstname, lastname, nationalCode, PersonType.ADMIN);
    }
}
