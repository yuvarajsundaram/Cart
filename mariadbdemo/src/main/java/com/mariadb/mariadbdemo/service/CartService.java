package com.mariadb.mariadbdemo.service;

import java.util.List;

import com.mariadb.mariadbdemo.model.CustomerDetail;
import com.mariadb.mariadbdemo.model.Data;
import com.mariadb.mariadbdemo.model.Order;

public interface CartService {

	Data getCustomerData(Integer id);

	List<Data> getAllCustomers();

	CustomerDetail addCustomer(CustomerDetail customerDetail);

	CustomerDetail updateCustomer(CustomerDetail customerDetail);

	Order addItem(Order order);

	Data orderItem(Data data);

	boolean deleteOrder(Integer custId, Integer itemId);

}
