package com.michal.employeemanagment.service;

import com.michal.employeemanagment.exceptions.UserNotFoundException;
import com.michal.employeemanagment.model.Employee;
import com.michal.employeemanagment.repo.EmployeeRepo;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  private final EmployeeRepo employeeRepo;

  @Autowired
  public EmployeeService(EmployeeRepo employeeRepo) {
    this.employeeRepo = employeeRepo;
  }

  public Employee addEmployee(Employee e){
    e.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(e);
  }

  public List<Employee> findAllEmployees(){
    return employeeRepo.findAll();
  }

  public Employee updateEmployee(Employee e){
    return employeeRepo.save(e);
  }

  public void deleteEmployee(Long id){
    employeeRepo.deleteEmployeeById(id);
  }

  public Employee findEmployee(Long id){
    return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("No employee with id: "+id+" was found"));
  }

}
