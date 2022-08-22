package entity;

import entity.enums.product.ProductType;

public class Seller extends Person {

    private int id;
    private ProductType productType;
    private String company;

    public Seller(String firstname, String lastname, String nationalCode, ProductType productType, String company) {
        super(firstname, lastname, nationalCode);
        this.productType = productType;
        this.company = company;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
