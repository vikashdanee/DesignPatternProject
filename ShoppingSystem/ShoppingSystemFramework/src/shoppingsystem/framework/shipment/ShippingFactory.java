package shoppingsystem.framework.shipment;


public class ShippingFactory implements IShippingFactory {
    @Override
    public IShipOrder getShippingAddress(String shippingType) {
        if(shippingType.equalsIgnoreCase("fedex")){
            return new Fedex();
        }else{
            return new UPS();
        }
    }
}
