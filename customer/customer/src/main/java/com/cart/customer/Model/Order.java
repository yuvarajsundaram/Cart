package com.cart.customer.Model;

public class Order {
	
	private Integer itemId;
	
	private String itemName;
	
	private float price;
	
	private Integer quantity;
	
	private float totalPrice;
	
	public Order() {
		
	}

	public Order(Integer itemId, String itemName, float price, Integer quantity, float totalPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
