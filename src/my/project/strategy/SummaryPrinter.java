package my.project.strategy;

import java.util.Collection;
import java.util.Iterator;

public class SummaryPrinter implements OrderPrinter {

	@Override
	public void printMethod(Collection<Order> orders) {
		System.out.println("**************** Summary Report *********************");
		Iterator<Order> iter = orders.iterator();
		double total = 0;
		for (int i=1; iter.hasNext(); ++i) {
			Order o = iter.next();
			System.out.println(i + ". " + o.getId() + "\t" + o.getDate()+"\t"+o.getItems().size()+"\t"+o.getTotal());
			total += o.getTotal();
		}
		System.out.println("*****************************************************");
		System.out.println("\t\t\tTotal: " + total);
	}

}
