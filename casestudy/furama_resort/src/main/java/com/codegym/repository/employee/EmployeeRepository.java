package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select e.* from `employee` e where e.`status`=1 ", nativeQuery = true)
    List<Employee> findAll();
}
