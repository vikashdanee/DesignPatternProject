package shoppingsystem.framework.mediator;

import java.util.List;

import shoppingsystem.framework.product.Product;
import shoppingsystem.framework.repository.IRepository;
import shoppingsystem.framework.userconfig.IUser;


public class Mediator implements IMediator {
	IRepository repository;

	public Mediator(IRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveProduct(Product product) {

		try {
			repository.saveProduct(product);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	@Override
	public void saveUser(IUser user) {

		try {
			repository.saveUser(user);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getListOfProduct() {
	
		return repository.getListOfProduct();
	}

}
