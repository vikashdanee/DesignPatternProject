package shoppingsystem.framework.offer;


import java.util.ArrayList;

import shoppingsystem.framework.userconfig.IUser;

/*Concrete Subject*/
public class SendOfferDetails implements SendOffer {
    private ArrayList<IUser> users = new ArrayList<IUser>();
    private String message;

    public SendOfferDetails(String message) {
        super();
        this.message = message;
    }

    public ArrayList<IUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<IUser> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void registerCustomer(IUser userObserver) {
        users.add(userObserver);
    }

    @Override
    public void removeCustomer(IUser userObserver) {
        users.remove(userObserver);
    }

    @Override
    public void notifyCustomers() {
        System.out.println("Sending Notification to customers...");
        System.out.println("------------------------------");
        for (IUser user : users) {
            user.update(message);
        }
        System.out.println("------------------------------");

    }
}
