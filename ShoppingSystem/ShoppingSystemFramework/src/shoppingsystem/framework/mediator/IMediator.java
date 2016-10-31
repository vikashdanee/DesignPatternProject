package shoppingsystem.framework.mediator;

import java.util.List;

import shoppingsystem.framework.product.Product;
import shoppingsystem.framework.userconfig.IUser;


public interface IMediator {
	public void saveProduct(Product product);
	public void saveUser(IUser user);
	public List<Product> getListOfProduct();
	
}
