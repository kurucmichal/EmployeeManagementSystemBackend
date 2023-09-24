package com.michal.employeemanagment.controllers;

import com.michal.employeemanagment.model.Employee;
import com.michal.employeemanagment.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

  private final EmployeeService service;

  public EmployeeResource(EmployeeService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees(){
    List<Employee> employees = service.findAllEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
    Employee employee = service.findEmployee(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    Employee newEmployee = service.addEmployee(employee);
    return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
    Employee updatedEmployee = service.updateEmployee(employee);
    return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id){
    service.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
