package groupfive.asd.sample;

import groupfive.asd.dataloader.DataLoader;
import shoppingsystem.framework.cart.*;
import shoppingsystem.framework.logger.AbstractLogger;
import shoppingsystem.framework.payment.CreditCard;
import shoppingsystem.framework.payment.DebitCard;
import shoppingsystem.framework.payment.PaymentContext;
import shoppingsystem.framework.product.Product;
import shoppingsystem.framework.repository.IRepository;
import shoppingsystem.framework.shipment.IShipOrder;
import shoppingsystem.framework.shipment.IShippingFactory;
import shoppingsystem.framework.shipment.ShippingFactory;

import java.util.Date;
import java.util.Scanner;

public class CustomerSection {
	private IRepository repository;

	public CustomerSection(IRepository repository) {
		this.repository = repository;
	}

	public void proceedForClientOperation(User user) {
		Utility.logger.logMessage(AbstractLogger.INFO, "Proceeding to Customer Section");
		Utility.printLine();
		Utility.printMessage("CUSTOMER SECTION");
		Utility.printLine();
		DataLoader loader = new DataLoader(repository);
		loader.loadDefaultProducts();
		Utility.printLine();
		Utility.printMessage("*****Start Shopping**********");
		Utility.printMessage("Adding To ShoppingCart::Enter product id");
		Utility.printMessage("For Checkout:: checkout");
		Utility.printLine();
		String input = "";
		Scanner scan = new Scanner(System.in);
		ShoppingCart shoppingCart = new ShoppingCart(user);
		while (!input.equalsIgnoreCase("checkout")) {
			Utility.printInlineMessage("Enter ProductId OR type checkout: ");

			input = scan.nextLine();
			Product product = repository.getProduct(input);

			ICommand command = new AddToCart(shoppingCart, product);
			ShoppingCartOperator operator = new ShoppingCartOperator(command);
			operator.addToCart();
		}
		System.out.println("checkout time1");
		Order order = shoppingCart.createOrder();
		System.out.println("checkout time2");
		Utility.printLine();
		Utility.printMessage("********Checkout Order**********");
		Utility.printLine();
		Utility.printMessage("Shopping Cart:");
		Utility.printMessage(order.toString());
		Utility.printLine();
		Utility.logger.logMessage(AbstractLogger.INFO, "Items added to shopping Cart and Order Created");

		Utility.printMessage("Proceed To make Payment");
		Utility.logger.logMessage(AbstractLogger.INFO, "Payment Process Started");
		PaymentContext paymentContext = new PaymentContext();
		Date expiryDate = Utility.getCardExpiryDate();
		Utility.printMessage("Please Choose Payment Method:");
		Utility.printInlineMessage("C for Credit Card:: D for Debit Card : ");
		String paymentType = scan.nextLine();
		String name, cardNumber, date;
		Utility.printInlineMessage("Enter Name: ");
		name = scan.nextLine();
		Utility.printInlineMessage("Enter Card Number: ");
		cardNumber = scan.nextLine();
		Utility.printInlineMessage("Enter Expiration Date : ");
		date = scan.nextLine();

		switch (paymentType.toLowerCase()) {

		case "d":
			Utility.printMessage("Making Payment through Debit Card ");
			paymentContext.setPaymentMethod(new DebitCard(name, cardNumber, expiryDate));
			break;
		case "c":
			Utility.printMessage("Making Payment through Credit Card ");
			paymentContext.setPaymentMethod(new CreditCard(name, cardNumber, expiryDate));
			break;

		}
		Utility.logger.logMessage(AbstractLogger.INFO, "Payment Process Completed");
		paymentContext.makePayment(order.getTotalPrice());
		Utility.logger.logMessage(AbstractLogger.INFO, "Shipping Process Initiated");
		Utility.printMessage("Enter Shipping Details");
		Utility.printMessage("For Fedex:: fedex");
		Utility.printMessage("For UPS:: ups");
		input = scan.nextLine();
		IShippingFactory shippingFactory = new ShippingFactory();
		IShipOrder shipOrder = shippingFactory.getShippingAddress(input);
		shipOrder.shipOrder(order);
		Utility.logger.logMessage(AbstractLogger.INFO, "Order has been shipped");
	}

}
