package my.project.strategy;

import java.util.LinkedList;

public class PrintService {

	private OrderPrinter printer;
	
	public PrintService(OrderPrinter printer) {
		this.printer = printer;
	}
	
	public void printOrders(LinkedList<Order> orders) {
		printer.printMethod(orders);
	}

}
