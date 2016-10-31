package groupfive.asd.sample;

import shoppingsystem.framework.repository.IRepository;
import shoppingsystem.framework.repository.Repository;
import shoppingsystem.framework.userconfig.ILoginService;
import shoppingsystem.framework.userconfig.IUser;

public class LoginControllerProxy implements ILoginController {
	private LoginController loginController;
	private IRepository repository;

	public LoginControllerProxy(ILoginService loginService) {
		loginController = new LoginController(loginService);
		repository = Repository.getInstance();
	}

	@Override
	public String login(IUser user) throws Exception {
		String isLoggedIn = loginController.login(user);

		return isLoggedIn;
	}

}
