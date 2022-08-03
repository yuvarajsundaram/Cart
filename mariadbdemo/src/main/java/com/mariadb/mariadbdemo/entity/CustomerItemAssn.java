package com.mariadb.mariadbdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CustomerItemAssn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CustItemAssnId custItemAssnId;

	@MapsId("custid")
	@ManyToOne
	@JoinColumn(name="custid", nullable=false)
	private Customer customer;
	
	@MapsId("itemid")
	@ManyToOne
	@JoinColumn(name="itemid", nullable=false)
	private Item item;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	public CustomerItemAssn() {
		
	}
	
	

public CustomerItemAssn(CustItemAssnId custItemAssnId, Integer quantity) {
		super();
		this.custItemAssnId = custItemAssnId;
		this.quantity = quantity;
	}



//	public CustomerItemAssn(Customer customer, Item item, Integer quantity) {
//		super();
////		this.customer = customer;
////		this.item = item;
//		this.quantity = quantity;
//	}

	
	
	public CustItemAssnId getCustItemAssnId() {
		return custItemAssnId;
	}

	public void setCustItemAssnId(CustItemAssnId custItemAssnId) {
		this.custItemAssnId = custItemAssnId;
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

