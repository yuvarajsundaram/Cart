package com.mariadb.mariadbdemo.Mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;

import com.mariadb.mariadbdemo.entity.Customer;
import com.mariadb.mariadbdemo.entity.CustomerItemAssn;
import com.mariadb.mariadbdemo.entity.Item;
import com.mariadb.mariadbdemo.model.CustomerDetail;
import com.mariadb.mariadbdemo.model.Data;
import com.mariadb.mariadbdemo.model.Order;

@Mapper(componentModel = "spring")
@DecoratedWith(CustMapperDecorator.class)
public interface CustMapper {
	
	Data customerToData(Customer customer);
	
	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	List<Data> customersToDatas(List<Customer> customer);
	
	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	Set<Order> customerItemAssnToOrder(Set<CustomerItemAssn> customerItemAssns);
	
	@Mappings({@Mapping(target="itemId", source="customerItemAssn.item.itemId"),
		@Mapping(target="itemName", source="customerItemAssn.item.itemName"),
		@Mapping(target="price", source="customerItemAssn.item.price"),
		@Mapping(target="quantity", source="customerItemAssn.quantity"),
		@Mapping(target="totalPrice", expression="java(customerItemAssn.getItem().getPrice()*customerItemAssn.getQuantity())")})
	Order customerItemAssnToOrder(CustomerItemAssn customerItemAssn);
	
	Customer customerDetailToCustomer(CustomerDetail customerDetail);
	
	Item orderToItem(Order order);
	
	@Mappings({@Mapping(target="customer", source="customer"), @Mapping(target="item", source="item"),
		@Mapping(target="quantity", source="order.quantity")})
	CustomerItemAssn getCustomerItemAssn(Customer customer, Item item, Order order);
}
