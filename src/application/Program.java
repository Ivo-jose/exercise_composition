package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
	    Date birthDate = sdf.parse(sc.next());
	    System.out.println("Enter order data: ");
	    System.out.print("Status: ");
	    OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());
	    Order order = new Order(new Date(), status, new Client(name, email, birthDate));
	    System.out.print("How many items to his order? ");
	    int qO = sc.nextInt();
	    for (int i=1; i<=qO; i++) {
	    	System.out.println("Enter #"+i+" item data:");
	    	System.out.print("Product name: ");
	    	sc.nextLine();
	    	String productName = sc.nextLine();
	    	System.out.print("Product price: ");
	    	double productPrice = sc.nextDouble();
	    	System.out.print("Quantity: ");
	    	int quantity = sc.nextInt();
	    	OrderItem oI = new OrderItem(quantity,productPrice , new Product(productName, productPrice));
	    	order.addItem(oI);
	    }
	    System.out.println();
	    System.out.println(order);
		sc.close();
	}

}
