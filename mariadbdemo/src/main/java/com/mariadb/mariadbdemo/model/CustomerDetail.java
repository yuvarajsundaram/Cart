package com.mariadb.mariadbdemo.model;

public class CustomerDetail {
	
	private Integer custId;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	public CustomerDetail() {
		
	}

	public CustomerDetail(Integer custId, String firstName, String lastName, String address) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
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
	
	
}
