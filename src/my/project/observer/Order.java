package my.project.observer;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private String id;
	
	private double itemCost;
	
	private int count;
	
	private double discount;
	
	private double shippingCost;
	
	private List<OrderObserver> observers = new ArrayList<>();
	
	public void attach(OrderObserver observer) {
		observers.add(observer);
	}
	
	public void detach(OrderObserver observer) {
		observers.remove(observer);
	}
	
	public Order(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public double getTotal() {
		return itemCost - discount + shippingCost;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", itemCost=" + itemCost + ", count=" + count + ", discount=" + discount
				+ ", shippingCost=" + shippingCost + "]";
	}

	public void addItem(double price) {
		itemCost += price;
		count++;
		observers.forEach(o->o.updated(this));
	}
	
	public int getCount() {
		return count;
	}
	
	public double getItemCost() {
		return itemCost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	
}
