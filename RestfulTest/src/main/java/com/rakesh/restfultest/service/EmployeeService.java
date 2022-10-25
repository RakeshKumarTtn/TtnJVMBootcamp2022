package com.rakesh.restfultest.service;

import com.rakesh.restfultest.seed.EmployeeSeed;
import com.rakesh.restfultest.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EmployeeService {
    static List<Employee> employees = new ArrayList<>();
    private static int counter;

    //This is static method which is called by jvm when our class gets loaded in the memory
    static {
        EmployeeSeed employeeSeed = new EmployeeSeed();
        employees.addAll(employeeSeed.getEmployeesList());
        counter = employees.size();
    }

    //This method will return all the employees to the controller
    public List<Employee> getAllEmployee() {
        return employees;
    }

    //This method save an employee provided by controller to the employees list
    public Employee saveEmployee(Employee employee) {
        if (employee.getId() == 0) {
            employee.setId(++counter);
        }
        employees.add(employee);
        return employee;
    }

    //This method will return an employee to the controller according to given id
    public Employee getEmployeeById(int id) {
        Predicate<Employee> predicate = employee -> employee.getId() == id;
        return employees.stream().filter(predicate).findFirst().orElse(null);
    }

    //This method is responsible for deleting an employee from the existing list
    public boolean deleteEmployeeRecordById(int id) {
        Predicate<Employee> predicate = employee -> employee.getId() == id;
        return employees.removeIf(predicate);
    }

    //This method save an employee provided by controller to the employees list
    public boolean updateEmployeeById(Employee employee, int id) {
        boolean condition = false;
        for (Employee employee1 : employees) {
            if (employee1.getId() == id) {
                employee1.setId(employee.getId());
                employee1.setAge(employee.getAge());
                employee1.setName(employee.getName());
                condition = true;
            }
        }
        return condition;
    }

    //This method is responsible for get an employee from the existing list According to the name
    public Employee getEmployeeByName(String name) {
        Predicate<Employee> predicate = employee -> employee.getName().equalsIgnoreCase(name);
        return employees.stream().filter(predicate).findFirst().orElse(null);
    }

    //This method is responsible for deleting an employee from the existing list According to the name
    public boolean deleteEmployeeRecordByName(String name) {
        Predicate<Employee> predicate = employee -> employee.getName().equalsIgnoreCase(name);
        return employees.removeIf(predicate);
    }

    //This method save an employee provided by controller to the employees list
    public boolean updateEmployeeByName(Employee employee, String name) {
        boolean condition = false;
        for (Employee employee1 : employees) {
            if (employee1.getName().equalsIgnoreCase(name)) {
                employee1.setId(employee.getId());
                employee1.setAge(employee.getAge());
                employee1.setName(employee.getName());
                condition = true;
            }
        }
        return condition;
    }
}

/*
    //This method is used for creating the initial list of employees
    private static void addInitialSomeEmployees() {
        Collections.addAll(employees, new Employee(++counter, "Rakesh", 25),
                new Employee(++counter, "Sohan", 30),
                new Employee(++counter, "Deepak", 52),
                new Employee(++counter, "Geeta", 32),
                new Employee(++counter, "Salman", 19),
                new Employee(++counter, "Rocky", 22)
        );
    }*/
