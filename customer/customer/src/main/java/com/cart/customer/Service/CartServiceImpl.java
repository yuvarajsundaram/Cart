package com.cart.customer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cart.customer.Entity.Customer;
import com.cart.customer.Model.Data;
import com.cart.customer.Model.Order;
import com.cart.customer.Repository.CustomerRepo;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<Data> getCustomers() {
		List<Customer> customers = customerRepo.findAll();
		List<Data> datas = new ArrayList<>();
		customers.stream().forEach(cust -> {
			datas.add(getData(cust));
		});
		return datas;
	}
	
	@Override
	public Data getCustomersById(Integer custId) {
		Optional<Customer>  Customer = customerRepo.findById(custId);
		if(Customer.isPresent()) {
			return getData(Customer.get());
		} else {
			return null;
		}
	}
	
	@Override
	public Data saveCustomer(Data data) {
		Customer customer = getDataToCustomer(data);
		customerRepo.save(customer);
		data.setCustomerId(customer.getCustId());
		return data;
	}
	
	@Override
	public Integer deleteCustomer(Integer custId) {
		customerRepo.deleteById(custId);
		return custId;
	}
	
	private Customer getDataToCustomer(Data data) {
		return new Customer(data.getFirstName(), data.getLastName(), data.getCity());
	}

	private Data getData(Customer customer) {
		List<Order> orders = new ArrayList<>();
		customer.getCustomerItemAssns().forEach(assn -> {
			Order order = new Order(assn.getItem().getItemId(), assn.getItem().getName(), assn.getItem().getPrice(), 
					assn.getQuantity(), (assn.getItem().getPrice() * assn.getQuantity()));
			orders.add(order);
			
		});
		Data data = new Data(customer.getCustId(), customer.getFirstName(), customer.getLastName(), 
				customer.getCity(), orders);
		
		return data;
	}
}
