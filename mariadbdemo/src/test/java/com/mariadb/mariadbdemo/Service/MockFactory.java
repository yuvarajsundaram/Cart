package com.mariadb.mariadbdemo.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mariadb.mariadbdemo.entity.CustItemAssnId;
import com.mariadb.mariadbdemo.entity.Customer;
import com.mariadb.mariadbdemo.entity.CustomerItemAssn;
import com.mariadb.mariadbdemo.entity.Item;
import com.mariadb.mariadbdemo.model.CustomerDetail;
import com.mariadb.mariadbdemo.model.Data;
import com.mariadb.mariadbdemo.model.Order;

public class MockFactory {

	
	public static Data getData() {
		Data data = new Data(1,"yuvaraj","sundaram","Bangalore",new HashSet<Order>());
		Order order = new Order(11,"Iphone",75000.0f,2,150000.0f);
		data.getOrders().add(order);
		return data;
	}
	
	public static Optional<Data> getOptionalData() {
		Optional<Data> opData = Optional.of(getData());
		return opData;
	}
	
	public static Customer getCustomer() {
		Customer customer = new Customer(1,"yuvaraj","sundaram","Bangalore");
		Item item = getItem();
		CustItemAssnId custItemAssnId = new CustItemAssnId(1,11);
		CustomerItemAssn customerItemAssn = new CustomerItemAssn(custItemAssnId,2);
		customerItemAssn.setCustomer(customer);
		customerItemAssn.setItem(item);
		customer.getCustomerItemAssns().add(customerItemAssn);
		item.getCustomerItemAssns().add(customerItemAssn);
		return customer;
	}
	
	public static Optional<Customer> getOptionalCustomer() {
		Optional<Customer> opCustomer = Optional.of(getCustomer());
		return opCustomer;
	}
	
	public static Item getItem() {
		Item item = new Item(11,"Iphone",75000.0f);
		return item;
	}
	
	public static List<Data> getAllDatas() {
		List<Data> datas = new ArrayList<>();
		datas.add(getData());
		return datas;
	}
	
	public static List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(getCustomer());
		return customers;
	}
	
	public static Data getDataOrderInput() {
		Data data = getData();
		data.getOrders().stream().collect(Collectors.toList()).get(0).setQuantity(3);
		Order order = new Order(12,"Dell laptop",80000.0f,2,160000.0f);
		data.getOrders().add(order);
		return data;
	}
	
	public static CustomerDetail getCustomerDetail() {
		CustomerDetail customerDetail = new CustomerDetail(null,"yuvaraj","sundaram","bangalore");
		return customerDetail;
	}
}
