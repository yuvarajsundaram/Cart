package com.mariadb.mariadbdemo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mariadb.mariadbdemo.Mapper.CustMapper;
import com.mariadb.mariadbdemo.Repository.CustomerItemAssnRepo;
import com.mariadb.mariadbdemo.Repository.CustomerRepo;
import com.mariadb.mariadbdemo.Repository.ItemRepo;
import com.mariadb.mariadbdemo.entity.Customer;
import com.mariadb.mariadbdemo.entity.CustomerItemAssn;
import com.mariadb.mariadbdemo.entity.Item;
import com.mariadb.mariadbdemo.model.CustomerDetail;
import com.mariadb.mariadbdemo.model.Data;
import com.mariadb.mariadbdemo.service.CartServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {
	
	@InjectMocks
	private CartServiceImpl cartServiceImpl;
	
	@Mock
	private CustomerRepo customerRepo;
	
	@Mock
	private CustMapper custMapper;
	
	@Mock
	private ItemRepo itemRepo;
	
	@Mock
	private CustomerItemAssnRepo customerItemAssnRepo;
	
	@Test
	public void getCustomerDataTest() {
		Data data = MockFactory.getData();
		Optional<Customer> opCustomer = MockFactory.getOptionalCustomer();
		when(customerRepo.findById(any())).thenReturn(opCustomer);
		when(custMapper.customerToData(any())).thenReturn(data);
		assertEquals(1, cartServiceImpl.getCustomerData(1).getCustId());
	}
	
	@Test
	public void getCustomerDataTest2() {
		Optional<Customer> opCustomer = Optional.ofNullable(null);
		when(customerRepo.findById(any())).thenReturn(opCustomer);
		assertNull(cartServiceImpl.getCustomerData(1));
	}
	
	@Test
	public void getAllCustomersTest() {
		List<Data> datas = MockFactory.getAllDatas();
		List<Customer> customers = MockFactory.getAllCustomers();
		when(customerRepo.findAll()).thenReturn(customers);
		when(custMapper.customersToDatas(any())).thenReturn(datas);
		assertEquals(1,cartServiceImpl.getAllCustomers().size());
	}
	
	@Test
	public void orderItemTest() {
		Data data = MockFactory.getDataOrderInput();
		Optional<Customer> opCustomer = MockFactory.getOptionalCustomer();
		Item item = new Item(12,"Dell laptop",80000.0f);
		Optional<Item> opItem = Optional.of(item);
		when(customerRepo.findById(any())).thenReturn(opCustomer);
		when(itemRepo.findById(12)).thenReturn(opItem);
		when(custMapper.getCustomerItemAssn(any(), any(), any())).thenReturn(new CustomerItemAssn());
		assertEquals(2, cartServiceImpl.orderItem(data).getOrders().size());
	}
	
	@Test
	public void deleteOrderTest() {
		Optional<Customer> opCustomer = MockFactory.getOptionalCustomer();
		when(customerRepo.findById(any())).thenReturn(opCustomer);
		assertTrue(cartServiceImpl.deleteOrder(1, 11));
	}
	
	@Test
	public void deleteOrderTest2() {
		Optional<Customer> opCustomer = MockFactory.getOptionalCustomer();
		when(customerRepo.findById(any())).thenReturn(opCustomer);
		assertFalse(cartServiceImpl.deleteOrder(1, 12));
	}
	
	@Test
	public void addCustomerTest() {
		CustomerDetail customerDetail = MockFactory.getCustomerDetail();
		when(custMapper.customerDetailToCustomer(customerDetail)).thenReturn(MockFactory.getCustomer());
		assertEquals(1, cartServiceImpl.addCustomer(customerDetail).getCustId());
	}
	
	@Test
	public void updateCustomerTest() {
		CustomerDetail customerDetail = MockFactory.getCustomerDetail();
		customerDetail.setCustId(1);
		customerDetail.setAddress("pune");
		Optional<Customer> opCustomer = MockFactory.getOptionalCustomer();
		when(customerRepo.findById(any())).thenReturn(opCustomer);
		when(custMapper.customerDetailToCustomer(customerDetail)).thenReturn(opCustomer.get());
		assertNotNull(cartServiceImpl.updateCustomer(customerDetail));
	}

}
