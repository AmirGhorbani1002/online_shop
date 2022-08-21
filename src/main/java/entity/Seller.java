package entity;

import entity.enums.product.ProductType;

public class Seller extends Person {

    private ProductType productType;

    public Seller(String firstname, String lastname, String nationalCode, ProductType productType) {
        super(firstname, lastname, nationalCode);
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
