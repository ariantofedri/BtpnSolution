package com.fedri.btpn.solution;

public class CreditCardStrategy implements PaymentStrategy{
	
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	
	@Override
	public void pay(Double amount) {
		// TODO Auto-generated method stub
		System.out.println(amount +" paid with credit/debit card");
	}

}
