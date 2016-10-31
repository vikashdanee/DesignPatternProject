package shoppingsystem.framework.context;

import shoppingsystem.framework.logger.AbstractLogger;
import shoppingsystem.framework.logger.LoggerBuilder;
import shoppingsystem.framework.product.Product;
import shoppingsystem.framework.repository.IRepository;
import shoppingsystem.framework.repository.Repository;
import shoppingsystem.framework.userconfig.ILoginService;
import shoppingsystem.framework.userconfig.LoginService;


public abstract class ShoppingSystem {
    protected String name = "ShoppingSystem APP";
    protected final String VERSION = "1.0";
    protected  static AbstractLogger logger =  LoggerBuilder.getLogger();
    protected IRepository repository;
    protected ILoginService loginService;
    protected Product product;

    public ShoppingSystem() {

        logger.logMessage(AbstractLogger.INFO, "ShoppingSystem App: Started");
        this.repository = Repository.getInstance();
        loginService = new LoginService(repository);
        start();
    }


    protected abstract void start();


}
