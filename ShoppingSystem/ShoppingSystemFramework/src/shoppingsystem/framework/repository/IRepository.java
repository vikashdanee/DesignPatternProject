package shoppingsystem.framework.repository;

import shoppingsystem.framework.product.Product;
import shoppingsystem.framework.userconfig.IUser;

import java.util.List;

public interface IRepository {

	public void saveUser(IUser user) throws Exception;
	public IUser getUserFromUserName(String username);
	public List<IUser> getListOfUser();

	public void saveProduct(Product product) throws Exception;
	 List<Product> getListOfProduct();
	Product getProduct(String productId);
}
