package com.mariadb.mariadbdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustItemAssnId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "custid")
	private Integer customer;
	@Column(name = "itemid")
	private Integer item;
	
	public CustItemAssnId(Integer custId, Integer itemId) {
		this.customer = custId;
		this.item = itemId;
	}
	
	public CustItemAssnId() {
		
	}
	
	public Integer getCustomer() {
		return customer;
	}
	public void setCustomer(Integer customer) {
		this.customer = customer;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
	
	
}
