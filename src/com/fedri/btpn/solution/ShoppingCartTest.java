package com.fedri.btpn.solution;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShoppingCartTest {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public static void main(String[] args) {
		
		Item item1 = new Item("111aaa","Electronics","LG G4",300.00);
		Item item2 = new Item("111aab","Furniture","Sofa 3 row",450.00);
		Item item3 = new Item("211aaa","Groceries","Rice 1 kg",15.00);
		Item item4 = new Item("211aab","Groceries","Egg 1 kg",10.00);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);
		cart.addItem(item4);
		
		String createdDateStr = "01-09-2015"; 
		Date createdDate = null;
		try {
			createdDate = sdf.parse(createdDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		User user = new User("Fedri Arianto", true, true, cart, createdDate);
		user.pay(new CreditCardStrategy("Fedri Arianto", "1234567890123456", "123", "12/22"));
		
	}

}
