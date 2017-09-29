package com.fedri.btpn.solution;

public class PaypalStrategy implements PaymentStrategy{
	
	private String emailId;
	private String password;
	
	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}

	@Override
	public void pay(Double amount) {
		// TODO Auto-generated method stub
		System.out.println(amount + " paid using Paypal.");
	}

}
