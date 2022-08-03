package com.mariadb.mariadbdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariadb.mariadbdemo.entity.Item;

@Repository
public interface ItemRepo  extends JpaRepository<Item, Integer>  {

}
