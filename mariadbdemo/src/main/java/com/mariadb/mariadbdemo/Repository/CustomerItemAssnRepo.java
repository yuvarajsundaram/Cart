package com.mariadb.mariadbdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariadb.mariadbdemo.entity.CustItemAssnId;
import com.mariadb.mariadbdemo.entity.CustomerItemAssn;

@Repository
public interface CustomerItemAssnRepo extends JpaRepository<CustomerItemAssn, CustItemAssnId> {

}
