package shoppingsystem.framework.cart;


public interface ICommand {

    boolean execute();
    boolean undo();

}
