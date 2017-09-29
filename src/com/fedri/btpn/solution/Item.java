package com.fedri.btpn.solution;
public class Item {
	private String itemName;
	private String itemCode;
	private String itemType;
	private Double price;
	
	public Item(String itemCode, String itemType, String itemName, Double price){
		this.itemName=itemName;
		this.itemCode=itemCode;
		this.itemType=itemType;
		this.price=price;
	}
	
	public String getItemName() {
		return itemName;
	}

	public String getItemCode() {
		return itemCode;
	}
	
	public String getItemType() {
		return itemType;
	}

	public Double getPrice() {
		return price;
	}
}
