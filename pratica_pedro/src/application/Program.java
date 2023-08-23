package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth Date: ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client (name, email, birthDate);
		
		System.out.println("Enter Order data: ");
		System.out.print("Status: ");
		String orderstatus = sc.next();
		OrderStatus orderStatus = OrderStatus.valueOf(orderstatus);
		
		Order order = new Order(new Date(), orderStatus);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
	
		for (int i = 1; i<=n; i++) {
		System.out.println("Enter #" + i + " item data:");	
		System.out.print("Product name: ");
		String nameProduct = sc.next();
		System.out.print("Product price: ");
		double priceProduct = sc.nextDouble();
		System.out.print("Quantity: ");
		int quantityProduct = sc.nextInt();
		
		Product product = new Product (nameProduct, priceProduct);
	    OrderItem orderItem = new OrderItem (quantityProduct, product);
		
	    order.addOrder(orderItem);
	    
		}
	
		System.out.println();
		
		System.out.println("ORDER SUMARY:");
		System.out.println("Order Moment: " + order.getMoment());
		System.out.println("Order Status: " + order.getStatus());
		System.out.println("Client: " + client.getName() + " " + client.getEmail() + " " + sdf.format(client.getBirthDate()));
		System.out.println();
		System.out.println("Order Items: " + "\n");
		for (OrderItem item : order.getOrderList()) {
			System.out.println("Product:" + item.getProduct().getName());
		    System.out.println("Price: " + item.getProduct().getPrice());
		    System.out.println("Quantity: " + item.getQuantity());
		    System.out.println("Subtotal: " + item.subTotal());
		    System.out.println();
		}
		System.out.println("Total Price: " + order.total());
		
		sc.close();
	}

}
