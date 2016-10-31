package shoppingsystem.framework.cart;

import shoppingsystem.framework.product.Product;
import shoppingsystem.framework.userconfig.IUser;

import java.util.List;


public class Order {


    private List<Product> products ;
    private IUser user;
    private double totalPrice;

    public  Order(IUser user, double totalPrice,List<Product> products ){
        this.products = products;
        this.totalPrice = totalPrice;
        this.user = user;
    }
    public  Order(IUser user, double totalPrice){
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
   String order = "";
        for (Product product : products) {
            order += "-------------------------------------------------------"+"\n"+" Item: "+product.getName()+
                    "       Quantity: "+ product.getQuantity()+
                    "       Rate: "+ product.getPrice()+"\n";
        }
        order +="-------------------------------------------------------"+"\n"+
                " Total: "+totalPrice+"\n"+"-------------------------------------------------------";

        return  order;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }
}
