package com.pottery_workshops.pottery_workshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pottery_workshops.pottery_workshops.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
