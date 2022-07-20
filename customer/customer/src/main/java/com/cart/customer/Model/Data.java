package com.cart.customer.Model;

import java.util.ArrayList;
import java.util.List;

public class Data {
  
	private Integer customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String city;
	
	private List<Order> orders =  new ArrayList<>();
	
	public Data() {
		
	}

	public Data(Integer customerId, String firstName, String lastName, String city, List<Order> orders) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.orders = orders;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
