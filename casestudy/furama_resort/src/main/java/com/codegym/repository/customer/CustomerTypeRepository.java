package com.codegym.repository.customer;

import com.codegym.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    @Query(value = "select * from customer_type where status = 1", nativeQuery = true)
    List<CustomerType> findAll();
}
