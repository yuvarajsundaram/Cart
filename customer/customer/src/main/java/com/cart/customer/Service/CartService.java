package com.cart.customer.Service;

import java.util.List;

import com.cart.customer.Model.Data;

public interface CartService {

	List<Data> getCustomers();

	Data getCustomersById(Integer custId);

	Data saveCustomer(Data data);

	Integer deleteCustomer(Integer custId);

}
