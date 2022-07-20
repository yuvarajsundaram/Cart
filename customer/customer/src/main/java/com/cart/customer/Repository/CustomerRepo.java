package com.cart.customer.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.customer.Entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


}
