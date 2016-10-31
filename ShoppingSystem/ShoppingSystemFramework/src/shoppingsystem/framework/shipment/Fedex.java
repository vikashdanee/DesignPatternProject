package shoppingsystem.framework.shipment;

import shoppingsystem.framework.cart.Order;


public class Fedex implements IShipOrder {
    @Override
    public void shipOrder(Order order) {
        System.out.println("************ ORDER DELIVERY THROUGH FEDEX ************");
    
    }
}
