package entity.product;

import entity.enums.product.ProductType;

public class Product {

    private int id;
    private ProductType productType;
    private String sellerName;
    private String description;
    private int quantity;
    private float price;

    public Product(ProductType productType, String sellerName, String description, int quantity, float price) {
        this.productType = productType;
        this.sellerName = sellerName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
