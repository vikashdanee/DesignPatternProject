package groupfive.asd.sample;

import shoppingsystem.framework.userconfig.IAddress;
import shoppingsystem.framework.userconfig.IUser;

public class User extends IUser {
	private RoleType roleType;

	public User(String username, String password) {
		super(username, password);
	}

	public User(String username, String password, String name, String emailAddress, IAddress billingAddress,
			IAddress shippingAddress, RoleType roleType) {
		super(username, password, name, emailAddress, billingAddress, shippingAddress);
		this.roleType = roleType;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	@Override
	public void update(String message) {
		System.out.println("Message received by " + getName() + " " + message);
	}
}
