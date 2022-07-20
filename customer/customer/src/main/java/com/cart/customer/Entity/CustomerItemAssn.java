package com.cart.customer.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerItemAssn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="custId", nullable=false)
	private Customer customer;
	
	@Id
	@ManyToOne
	@JoinColumn(name="itemId", nullable=false)
	private Item item;
	
	private Integer quantity;
	
	public CustomerItemAssn() {
		
	}

	public CustomerItemAssn(Customer customer, com.cart.customer.Entity.Item item, Integer quantity) {
		super();
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
