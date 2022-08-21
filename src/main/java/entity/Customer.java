package entity;

import entity.enums.CustomerType;
import entity.enums.PersonType;

public class Customer extends Person {

    private CustomerType type;

    public Customer(String firstname, String lastname, String nationalCode, CustomerType type) {
        super(firstname, lastname, nationalCode, PersonType.Customer);
        this.type = type;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }
}
