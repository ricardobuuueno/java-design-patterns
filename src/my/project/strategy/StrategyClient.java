package my.project.strategy;

import java.util.LinkedList;

public class StrategyClient {

	private static LinkedList<Order> orders = new LinkedList<>();
	
	public static void execute() {
		createOrders();
		
		PrintService service = new PrintService(new DetailPrinter());
		service.printOrders(orders);
	}
	
	private static void createOrders() {
		Order o = new Order("100");
		o.addItem("Soda", 2);
		o.addItem("Chips", 10);
		orders.add(o);
		
		o = new Order("200");
		o.addItem("Cake", 20);
		o.addItem("Cookies", 5);
		orders.add(o);

		o = new Order("300");
		o.addItem("Burger", 8);
		o.addItem("Fries", 5);
		orders.add(o);
	}
	
}
