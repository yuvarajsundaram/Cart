package com.cart.customer.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer itemId;
	
	private String name;
	
	private float price;
	
	@OneToMany(mappedBy = "item")
	private Set<CustomerItemAssn> customerItemAssns = new HashSet<>();
	
	public Item() {
		
	}

	public Item(Integer id, String name, float price) {
		super();
		this.itemId = id;
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	
	public Set<CustomerItemAssn> getCustomerItemAssns() {
		return customerItemAssns;
	}

	public void setCustomerItemAssns(Set<CustomerItemAssn> customerItemAssns) {
		this.customerItemAssns = customerItemAssns;
	}
	
	
	
}
