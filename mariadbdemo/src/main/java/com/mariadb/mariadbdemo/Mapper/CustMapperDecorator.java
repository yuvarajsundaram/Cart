package com.mariadb.mariadbdemo.Mapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mariadb.mariadbdemo.entity.Customer;
import com.mariadb.mariadbdemo.model.Data;

public abstract class CustMapperDecorator implements CustMapper {
	
	@Autowired
	private CustMapper delegate;

	public Data customerToData(Customer customer) {
		Data data = delegate.customerToData(customer);
		data.setOrders(delegate.customerItemAssnToOrder(customer.getCustomerItemAssns()));
		return data;
	}
	
	public List<Data> customersToDatas(List<Customer> customers) {
		List<Data> datas = delegate.customersToDatas(customers);
		for(Data data : datas) {
			Optional<Customer> opCustomer = customers.stream().filter(cust -> cust.getCustId().equals(data.getCustId())).findFirst();
			if(opCustomer.isPresent()) {
				data.setOrders(delegate.customerItemAssnToOrder(opCustomer.get().getCustomerItemAssns()));
			}
		}
		return datas;
	}

}
