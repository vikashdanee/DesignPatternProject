package shoppingsystem.framework.cart;

import java.util.Stack;

import shoppingsystem.framework.product.Product;


public class ShoppingCartOperator {
    Stack<ICommand> commadStack = new Stack<ICommand>();
    ICommand command;

      public ShoppingCartOperator(ICommand command){
           this.command = command;
      }

    public void addToCart(){
         if (command.execute()==true) {
             commadStack.add(command);
             System.out.println("Successfully Added to the Cart");
            
         }
    }
    public void removeFromCart(AddToCart commad,Product product){
         if (commad.undo()== true){
             commadStack.add(commad);
             System.out.println("Successfully Removed from the cart");
         }
    }

}
