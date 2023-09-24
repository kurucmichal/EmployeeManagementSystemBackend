package com.michal.employeemanagment.repo;

import com.michal.employeemanagment.model.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

  void deleteEmployeeById(Long id);


  Optional<Employee> findEmployeeById(Long id);


}
