package com.rakesh.restfultest.controller;

import com.rakesh.restfultest.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    //Get a single entity
    //List of entities
    //Update the entity
    //Delete an entity

    @GetMapping("/employees1/{id}")
    public Employee getEmployeeObject(@PathVariable int id) {
        Employee employee = .get(id);
        return employee;
    }

    @PutMapping("/employee/update/{id}")
    public Employee updateEmployeeObject(@RequestBody Employee employee, @PathVariable int id) {
        Employee employee1 = employeeHashMap.get(id);
        if (employee.getName() != null)
            employee1.setName(employee.getName());
        if (employee.getAge() > 0)
            employee1.setAge(employee.getAge());
        return employee1;
    }
}
