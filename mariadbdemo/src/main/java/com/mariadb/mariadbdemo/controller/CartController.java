package com.mariadb.mariadbdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariadb.mariadbdemo.model.CustomerDetail;
import com.mariadb.mariadbdemo.model.Data;
import com.mariadb.mariadbdemo.model.Order;
import com.mariadb.mariadbdemo.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/customer/{id}")
	@PreAuthorize("hasRole('user')")
	public Data getCustomerById(@PathVariable Integer id) {
		return cartService.getCustomerData(id);
	}
	
	@GetMapping("/customers")
	@PreAuthorize("hasRole('admin')")
	public List<Data> getAllCustomers() {
		return cartService.getAllCustomers();
	}
	
	@PostMapping(value = "/addCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('user')")
	public CustomerDetail addCustomer(@RequestBody CustomerDetail customerDetail) {
		return cartService.addCustomer(customerDetail);
	}
	
	@PutMapping(value = "/updateCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('user')")
	public CustomerDetail updateCustomer(@RequestBody CustomerDetail customerDetail) {
		return cartService.updateCustomer(customerDetail);
	}
	
	@PostMapping(value = "/addItem",consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('admin')")
	public Order addItem(@RequestBody Order order) {
		return cartService.addItem(order);
	}
	
	@PostMapping(value = "/orderItem",consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('user')")
	public Data orderItem(@RequestBody Data data) {
		return cartService.orderItem(data);
	}
	
	@DeleteMapping("/deleteOrder/{custId}/{itemId}")
	@PreAuthorize("hasRole('user')")
	public boolean deleteOrder(@PathVariable Integer custId, @PathVariable Integer itemId) {
		return cartService.deleteOrder(custId,itemId);
	}

}
