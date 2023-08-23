package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> orderList = new ArrayList <>();
	
	public Order()  {	
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderList() {
		return orderList;
	}
	
	public void addOrder (OrderItem item) {
		orderList.add(item);
	}
	
	
	
	public void removeOrder (OrderItem item) {
		orderList.remove(item);
	}
	
	public double total () {
		double totalOrder = 0;	
		for (OrderItem o : orderList) {
		totalOrder = totalOrder + o.subTotal();
		}		
		return totalOrder;	
	}
	
}
