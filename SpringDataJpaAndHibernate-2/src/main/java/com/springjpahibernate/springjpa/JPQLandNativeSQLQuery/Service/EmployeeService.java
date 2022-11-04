package com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Service;

import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.entities.Employee;
import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //Store employees list into database table
    public ResponseEntity<Employee> createDummyEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/employees")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //List out all the Data from Employee table
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /************ JAVA PERSISTENCE QUERY LANGUAGE ************/
    /*
         Display the first name, last name of all employees having salary greater than average salary ordered
         in ascending by their age and in descending by their salary.
    */
    public List<Employee> findEmployeeBySalaryGreaterThanAverageSalary() {
        return employeeRepository.findEmployeeBySalaryGreaterThanAverageSalary();
    }

    /*
         Update salary of all employees by a salary passed as
         a parameter whose existing salary is less than the average salary.
    */
    @Transactional
    public void updateSalaryAllEmployeeLessThanAverageSalary(Double setSalary) {
        Double avgSalary = employeeRepository.findAverageSalary().get();
        employeeRepository.updateEmployeesSalaryWhoseSalaryLessThanAverageSalary(setSalary, avgSalary);
    }

    /*
        Delete all employees with minimum salary.
    */
    @Transactional
    public void deleteEmployeeWithMinSalary() {
        Double minSalary = employeeRepository.getMinSalary();
        employeeRepository.deleteEmployeesWithMinimumSalary(minSalary);
    }

    /************ NATIVE SQL QUERIES ************/
    /*
       1. Display the id, first name, age of all employees where last name ends with "singh"
    */
    public List<Object[]> getAllEmployeesWhoseLastNameIsSingh(String str) {
        return employeeRepository.getAllEmployeesWhoseLastNameIsSingh(str);
    }

    /*
       2. Delete all employees with age greater than 45(Should be passed as a parameter)
    */
    @Transactional
    public void deleteAllEmployeeAgeGreaterThan45(Integer age) {
        employeeRepository.deleteAllEmployeeAgeGreaterThan45(age);
    }
}