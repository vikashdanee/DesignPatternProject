package groupfive.asd.sample;

import shoppingsystem.framework.logger.AbstractLogger;
import shoppingsystem.framework.logger.LoggerBuilder;
import shoppingsystem.framework.userconfig.IUser;

public interface ILoginController {
    static AbstractLogger logger =  LoggerBuilder.getLogger();
    public String login(IUser user) throws Exception;
}
