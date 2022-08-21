package entity.product;

import entity.enums.product.tv.DisplayType;
import entity.enums.product.ProductType;

public class Tv extends Product {

    private int inch;
    private DisplayType type;

    public Tv(String sellerName, String description,
              int quantity, float price, int inch, DisplayType type) {
        super(ProductType.ELECTRONIC_APPLIANCES, sellerName, description, quantity, price);
        this.inch = inch;
        this.type = type;
    }

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    public DisplayType getType() {
        return type;
    }

    public void setType(DisplayType type) {
        this.type = type;
    }
}
