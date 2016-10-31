package shoppingsystem.framework.shipment;


public interface IShippingFactory {
        public IShipOrder getShippingAddress(String shippingType);
}
