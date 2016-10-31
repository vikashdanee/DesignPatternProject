package shoppingsystem.framework.offer;



import shoppingsystem.framework.userconfig.IUser;

/*Subject Interface*/
public interface SendOffer {
	public void registerCustomer(IUser customer);

	public void removeCustomer(IUser customer);

	public void notifyCustomers();
}
