package shoppingsystem.framework.cart;

import java.util.List;

import shoppingsystem.framework.product.Product;

public interface IShoppingCart {
    void removeItem(Product product);
    void addItem(Product product);
    List<ShoppingCartItem> getItems();
    double calculateTotal();
    void clear();
    int getNoOfItems();
}
