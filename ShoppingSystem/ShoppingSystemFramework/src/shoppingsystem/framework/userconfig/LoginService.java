package shoppingsystem.framework.userconfig;

import shoppingsystem.framework.exception.AuthorizationException;
import shoppingsystem.framework.exception.UserNotFoundException;
import shoppingsystem.framework.repository.IRepository;

public class LoginService implements ILoginService {
    private IRepository repository;

    public LoginService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean loginUser(IUser user) throws Exception {
        IUser usr = repository.getUserFromUserName(user.getUsername());
       
        if(usr == null){
            throw new UserNotFoundException("User doesn't exist");
        }else{
            if(usr.getPassword().equals(user.getPassword())){
                return true;
            }else{
                throw new AuthorizationException("Invalid username and password");
            }
        }
    }
}
