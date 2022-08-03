package com.mariadb.mariadbdemo.model;

import java.util.HashSet;
import java.util.Set;

public class Data {
	
	private Integer custId;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private Set<Order> orders = new HashSet<>();
	
	public Data() {
		
	}

	public Data(Integer custId, String firstName, String lastName, String address, Set<Order> orders) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.orders = orders;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	

}
