package com.rakesh.restfultest.controller;

import com.rakesh.restfultest.exception_handling.ResourceNotFoundException;
import com.rakesh.restfultest.entity.Employee;
import com.rakesh.restfultest.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //This is the request for fetching all the employees
    @RequestMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    //This is the request for fetching the employee according to the given id
    @RequestMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) throw new ResourceNotFoundException("User With Id : " + id + " is Not Found");
        else return employee;
    }

    //This is the request for saving a new record in the employee list
    @PostMapping("/employees")
    public void saveEmployee(@Valid @RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    //This is the request for deleting an employee according to the provided id
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeRecordById(@PathVariable int id) {
        employeeService.deleteEmployeeRecordById(id);
    }

    //THis method is used for updating an employee record according to the ID
    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployeeById(@Valid @RequestBody Employee employee, @PathVariable int id) {
        boolean condition = employeeService.updateEmployeeById(employee, id);
        return condition == true ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    //This is the request for fetching the employee according to the given id
    @RequestMapping("/employees/employee/{name}")
    public Employee getEmployeeByName(@PathVariable String name) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeByName(name);

        if (employee == null) throw new ResourceNotFoundException("User With Id : " + name + " is Not Found");
        else return employee;
    }

    //This is the request for deleting an employee according to the provided NAME
    @DeleteMapping("/employees/employee/{name}")
    public void deleteEmployeeRecordByName(@PathVariable String name) {
        employeeService.deleteEmployeeRecordByName(name);
    }

    //THis method is used for updating an employee record according to the NAME
    @PutMapping("/employees/employee/{name}")
    public ResponseEntity<Object> updateEmployeeByName(@Valid @RequestBody Employee employee, @PathVariable String name) {
        boolean condition = employeeService.updateEmployeeByName(employee, name);
        return condition == true ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
