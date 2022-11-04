package com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Controller;

import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Seed.EmployeeSeed;
import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Service.EmployeeService;
import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //Create employee list using EmployeeSeed class and store them into database table
    @PostMapping("/create/employees")
    public ResponseEntity<Employee> createDummyEmployees(@Param("count") Integer count) {
        List<Employee> employees = new EmployeeSeed().getEmployeeList(count);
        return employeeService.createDummyEmployees(employees);
    }

    //Retrieve Employees List from the Database
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        Iterator iterator = employees.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        return employees;
    }

    /************ JAVA PERSISTENCE QUERY LANGUAGE ************/
    /*
         Display the first name, last name of all employees having salary greater than average salary ordered
         in ascending by their age and in descending by their salary.
    */
    @RequestMapping(value = "/employees/salary", method = RequestMethod.GET)
    public List<Employee> findEmployeeBySalaryGreaterThanAverageSalary() {
        List<Employee> employees = employeeService.findEmployeeBySalaryGreaterThanAverageSalary();
        Iterator iterator = employees.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        return employees;
    }

    /*
         Update salary of all employees by a salary passed as
         a parameter whose existing salary is less than the average salary.
    */
    @PutMapping("/employees/updateSalary")
    public ResponseEntity<Employee> updateSalaryAllEmployeeLessThanAverageSalary(@Param("setSalary") Double setSalary) {
        employeeService.updateSalaryAllEmployeeLessThanAverageSalary(setSalary);
        return ResponseEntity.accepted().build();
    }

    /*
        Delete all employees with minimum salary.
    */
    @DeleteMapping("/employees/deleteEmployee")
    public ResponseEntity<Employee> deleteEmployeeWithMinSalary() {
        employeeService.deleteEmployeeWithMinSalary();
        return ResponseEntity.accepted().build();
    }

    /************ NATIVE SQL QUERIES ************/
    /*
       1. Display the id, first name, age of all employees where last name ends with "singh"
    */
    @RequestMapping(value = "/employees/lastNameSingh/{str}", method = RequestMethod.GET)
    public List<Object[]> getAllEmployeesWhoseLastNameIsSingh(@PathVariable("str") String str) {
        List<Object[]> employees = employeeService.getAllEmployeesWhoseLastNameIsSingh(str);

        for (Object[] objects : employees) {
            String message = "[\n\tempId = " + objects[0] + ",\n\t" + "empFirstName = " +
                    objects[1] + ",\n\t" + "empAge = " + objects[2] + "\n]";
            System.out.println(message);
        }
        return employees;
    }

    /*
            Delete all employees with age greater than 45(Should be passed as a parameter)
    */
    @DeleteMapping("/employees/age")
    public ResponseEntity<Employee> deleteAllEmployeeAgeGreaterThan45(@Param("Age") Integer Age) {
        employeeService.deleteAllEmployeeAgeGreaterThan45(Age);
        return ResponseEntity.accepted().build();
    }
}
