package com.fedri.btpn.solution;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User {
	private String name;
	private Boolean isEmployee;
	private Boolean isAffiliate;
	private Date createdDate;
	private ShoppingCart shoppingCart;
	
	public User(String name, Boolean isEmployee, Boolean isAffiliate, ShoppingCart shoppingCart, Date createdDate){
		this.name=name;
		this.isEmployee=isEmployee;
		this.isAffiliate=isAffiliate;
		this.shoppingCart=shoppingCart;
		this.createdDate=createdDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getIsEmployee() {
		return isEmployee;
	}
	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public Boolean getIsAffiliate() {
		return isAffiliate;
	}
	public void setIsAffiliate(Boolean isAffiliate) {
		this.isAffiliate = isAffiliate;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public Double calculateTotal(){
		List<Item> items = shoppingCart.items;
		Double sum = 0.00;
		Double sumNotAllowDiscount = 0.00;
		for(Item item : items){
			if (!item.getItemCode().startsWith("211")){
				sum += item.getPrice();
			} else {
				sumNotAllowDiscount += item.getPrice();
			}
		}
		
		// Calendar twoPrevYear
		Calendar calTwoPrevYear = Calendar.getInstance();
		calTwoPrevYear.add(Calendar.YEAR, -2); // calendar get 2 years from now
		
		// Calendar createdDate
		Calendar calCreatedDate = Calendar.getInstance();
		calCreatedDate.setTime(createdDate); // calendar createdDate

		boolean isOverTwoYearsCustomer = false;
		if (calCreatedDate.before(calTwoPrevYear)){
			isOverTwoYearsCustomer = true;
		}
		
		if (isEmployee == true){
			Double discount = sum * 18/100; // 18 percent for employee 
			sum = sum - discount;
		} else if (isAffiliate == true){
			Double discount = sum * 15/100; // 15 percent for affiliate
			sum = sum - discount;
		} else if (isOverTwoYearsCustomer){ // > 2 years become customer
			Double discount = sum * 10/100;
			sum = sum - discount;
		} else {
			Double temp = sum / 100;
			int discount = Integer.valueOf(temp.intValue());
			int intDiscount = discount * 5; 
			
			sum = sum - intDiscount;
		}
		
		sum = sum + sumNotAllowDiscount; // total net payable amount = sum discount + sum not allow discount
		
		return sum;
	}
	
	public void pay(PaymentStrategy paymentMethod){
		Double amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}
