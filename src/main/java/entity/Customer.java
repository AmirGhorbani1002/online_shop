package entity;

import entity.enums.CustomerType;

public class Customer extends Person {

    private long id;
    private CustomerType type;

    public Customer(String firstname, String lastname, String nationalCode) {
        super(firstname, lastname, nationalCode);
        this.type = CustomerType.NORMAL;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
