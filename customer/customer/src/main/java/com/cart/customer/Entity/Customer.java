package com.cart.customer.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@Id
	@SequenceGenerator(name = "mySeqGen", initialValue = 11, allocationSize = 3)
	@GeneratedValue(generator = "mySeqGen")
	private Integer custId;
	
	private String firstName;
	
	private String lastName;
	
	private String city;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CustomerItemAssn> customerItemAssns = new HashSet<>();

	public Customer(Integer custId, String firstName, String lastName, String city) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	
	public Customer(String firstName, String lastName, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	
	public Customer() {
		
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public Set<CustomerItemAssn> getCustomerItemAssns() {
		return customerItemAssns;
	}

	public void setCustomerItemAssns(Set<CustomerItemAssn> customerItemAssns) {
		this.customerItemAssns = customerItemAssns;
	}
	
	

}
