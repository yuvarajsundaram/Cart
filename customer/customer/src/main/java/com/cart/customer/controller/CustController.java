package com.cart.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cart.customer.Model.Data;
import com.cart.customer.Service.CartService;

@RestController
@CrossOrigin
public class CustController {
	
	@Autowired
	private CartService cartService;

	
	@GetMapping(value = "/customer")
	public List<Data> getCustomer() {
		return cartService.getCustomers();
	}
	
	@GetMapping(value = "/customer/{custId}")
	public Data getCustomerById(@PathVariable Integer custId) {
		return cartService.getCustomersById(custId);
	}
	
	@PostMapping(value = "/customer")
	public Data saveCustomer(@RequestBody Data data) {
		return cartService.saveCustomer(data);
	}
	
	@DeleteMapping(value = "/customer/{custId}")
	public Integer deleteCustomer(@PathVariable Integer custId) {
		return cartService.deleteCustomer(custId);
	}
}

//class Customer {
//	 private String name;
//	 
//	 public Customer() {
//		 
//	 }
//	 
//	 public Customer(String name) {
//		 this.name = name;
//	 }
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	 
//	 
//}
