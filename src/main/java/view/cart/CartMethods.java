package view.cart;

import check.Check;
import entity.Cart;
import entity.product.Product;
import service.cart.CartServiceImpl;
import service.product.ProductServiceImpl;

public class CartMethods {

    private final Check check = new Check();
    private final CartServiceImpl cartService = new CartServiceImpl();
    public void showProducts(Cart cart){
        int index = 0;
        for (Product product : cart.getProducts())
            System.out.println(++index + ") " + product);
    }

    public void deleteProduct(Cart cart,String command){
        int i = check.checkInt(command, true);
        if (i > cart.getProducts().size()) {
            System.out.println("This id was not found");
            return;
        }
        cartService.deleteProductFromCart(cart.getProducts().get(Integer.parseInt(command) - 1).getId()
                , cart.getId());
    }

    public void paidCart(Cart cart){
        ProductServiceImpl productService = new ProductServiceImpl();
        int quantity;
        for (Product product : cart.getProducts()) {
            quantity = productService.loaProductQuantity(product.getId());
            if (quantity < product.getQuantity()) {
                System.out.println("for product with id " + product.getId() + " We are out of stock!!! You are late." +
                        " we delete it for you from your cart");
                cartService.deleteProductFromCart(product.getId(), cart.getId());
                continue;
            }
            productService.update(product.getId(), quantity - product.getQuantity());
        }
        cart.getProducts().clear();
        cartService.update(cart.getId());
    }

    public void showPrice(Cart cart){
        float price = 0;
        for (Product product : cart.getProducts())
            price += product.getPrice();
        System.out.println(price);
    }

}
