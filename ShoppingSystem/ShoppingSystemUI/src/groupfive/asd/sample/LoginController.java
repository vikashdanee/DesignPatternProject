package groupfive.asd.sample;

import shoppingsystem.framework.exception.AuthorizationException;
import shoppingsystem.framework.exception.UserNotFoundException;
import shoppingsystem.framework.userconfig.ILoginService;
import shoppingsystem.framework.userconfig.IUser;

public class LoginController implements ILoginController {
    private ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public String login(IUser user) {
        try {
           loginService.loginUser(user);
            return "success";
        } catch (UserNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (AuthorizationException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return "Unable to loggedIn";
    }
}
