package com.mariadb.mariadbdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.mariadb.mariadbdemo.Mapper.CustMapper;
import com.mariadb.mariadbdemo.Repository.CustomerItemAssnRepo;
import com.mariadb.mariadbdemo.Repository.CustomerRepo;
import com.mariadb.mariadbdemo.Repository.ItemRepo;
import com.mariadb.mariadbdemo.entity.CustItemAssnId;
import com.mariadb.mariadbdemo.entity.Customer;
import com.mariadb.mariadbdemo.entity.CustomerItemAssn;
import com.mariadb.mariadbdemo.entity.Item;
import com.mariadb.mariadbdemo.model.CustomerDetail;
import com.mariadb.mariadbdemo.model.Data;
import com.mariadb.mariadbdemo.model.Order;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustMapper custMapper;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${environmentVariables.customerUrl}")
	private String customerUrl;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private CustomerItemAssnRepo customerItemAssnRepo;
	
	@Override
	public Data getCustomerData(Integer id) {
//		Data data = webClientBuilder.build()
//		.get()
//		.uri(customerUrl+id)
//		.retrieve()
//		.bodyToMono(Data.class)
//		.block();
		Optional<Customer> optionalCustomer = customerRepo.findById(id);
		if(optionalCustomer.isPresent()) {
			return custMapper.customerToData(optionalCustomer.get());
		}
		return null;
	}
	
	@Override
	public List<Data> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return custMapper.customersToDatas(customers);
	}
	
	@Override
	public CustomerDetail addCustomer(CustomerDetail customerDetail) {
		Customer customer = custMapper.customerDetailToCustomer(customerDetail);
		customerRepo.save(customer);
		customerDetail.setCustId(customer.getCustId());
		return customerDetail;
	}
	
	@Override
	public CustomerDetail updateCustomer(CustomerDetail customerDetail) {
		Optional<Customer> optionalCustomer = customerRepo.findById(customerDetail.getCustId());
		if(optionalCustomer.isPresent()) {
			Customer customer = custMapper.customerDetailToCustomer(customerDetail);
			customerRepo.save(customer);
		}
		return customerDetail;
	}
	
	@Override
	public Order addItem(Order order) {
		Item item = custMapper.orderToItem(order);
		itemRepo.save(item);
		order.setItemId(item.getItemId());
		return order;
	}
	
	@Override
	public Data orderItem(Data data) {
		Optional<Customer> optionalCustomer = customerRepo.findById(data.getCustId());
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			data.getOrders().forEach(order -> {
				Optional<CustomerItemAssn> opCustomerItemAssn = customer.getCustomerItemAssns().
				stream().filter(assn -> assn.getCustItemAssnId().getItem().equals(order.getItemId())).findFirst();
				if(opCustomerItemAssn.isPresent()) {
					opCustomerItemAssn.get().setQuantity(order.getQuantity());
				} else {
					Optional<Item> opItem = itemRepo.findById(order.getItemId());
					if(opItem.isPresent()) {
						Item item = opItem.get();
						saveCustomerItemAssn(customer, order, item);
					}
				}
			});
		}
		return data;
	}

	private void saveCustomerItemAssn(Customer customer, Order order, Item item) {
		CustomerItemAssn customerItemAssn = custMapper.getCustomerItemAssn(customer, item, order);
		CustItemAssnId custItemAssnId = new CustItemAssnId(customer.getCustId(), item.getItemId());
		customerItemAssn.setCustItemAssnId(custItemAssnId);
		customerItemAssnRepo.save(customerItemAssn);
	}

	@Override
	public boolean deleteOrder(Integer custId, Integer itemId) {
		Optional<Customer> opCustomer = customerRepo.findById(custId);
		if(opCustomer.isPresent()) {
			Optional<CustomerItemAssn> opCustomerItemAssn = opCustomer.get().getCustomerItemAssns().stream().
					filter(assn -> assn.getItem().getItemId().equals(itemId)).findFirst();
			if(opCustomerItemAssn.isPresent()) {
				opCustomer.get().getCustomerItemAssns().remove(opCustomerItemAssn.get());
				opCustomerItemAssn.get().getItem().getCustomerItemAssns().remove(opCustomerItemAssn.get());
				customerItemAssnRepo.delete(opCustomerItemAssn.get());
				return true;
			}
		}
		return false;
	}

}
