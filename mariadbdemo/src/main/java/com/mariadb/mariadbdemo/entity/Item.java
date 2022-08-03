package com.mariadb.mariadbdemo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemid")
	private Integer itemId;
	
	@Column(name = "itemname")
	private String itemName;
	
	@Column(name = "price")
	private float price;
	
	@OneToMany(mappedBy = "item")
	private Set<CustomerItemAssn> customerItemAssns = new HashSet<>();
	
	public Item() {
		
	}

	public Item(Integer id, String name, float price) {
		super();
		this.itemId = id;
		this.itemName = name;
		this.price = price;
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

