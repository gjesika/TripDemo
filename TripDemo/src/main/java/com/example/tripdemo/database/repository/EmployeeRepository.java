package com.example.tripdemo.database.repository;

import com.example.tripdemo.database.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{

    Optional<Employee> findByUsername(String userName);
}
