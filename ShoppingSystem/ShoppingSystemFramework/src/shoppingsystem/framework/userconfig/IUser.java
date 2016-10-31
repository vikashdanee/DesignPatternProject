package shoppingsystem.framework.userconfig;


public abstract class IUser{
	private String name;
	private String emailAddress;
	private String username;
	private String password;
	private IAddress billingAddress;
	private IAddress shippingAddress;

	/*Acts as observer method*/
	public abstract void update(String message);

	public IUser(String username, String password){
		this.username = username;
		this.password = password;
	}

	public IUser(String username, String password, String name, String emailAddress, IAddress billingAddress, IAddress shippingAddress) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.emailAddress = emailAddress;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(IAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public IAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(IAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
