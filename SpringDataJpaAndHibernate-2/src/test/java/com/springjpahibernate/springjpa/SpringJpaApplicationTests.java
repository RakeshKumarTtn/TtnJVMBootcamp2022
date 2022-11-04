package com.springjpahibernate.springjpa;

import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Seed.EmployeeSeed;
import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.entities.Employee;
import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.repos.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    //(3) Perform Create Operation on Entity using Spring Data JPA
    @Test
    public void testCreate() {
        List<Employee> employees = new EmployeeSeed().getEmployeeList(100);
        employeeRepository.saveAll(employees);
    }

    //(4) Perform Update Operation on Entity using Spring Data JPA
    @Test
    public void testUpdate() {
        Employee employee = employeeRepository.findById(3).get();
        employee.setAge(30);
        employee.setFirstName("Sourabh");
        employeeRepository.save(employee);
    }

    //(5) Perform Delete Operation on Entity using Spring Data JPA
    @Test
    public void testDelete() {
        Employee employee = employeeRepository.findById(3).get();
        employeeRepository.delete(employee);
    }

    //(6) Perform Read Operation on Entity using Spring Data JPA
    @Test
    public void testRead() {
        Employee employee = employeeRepository.findById(2).get();
        Assertions.assertNotNull(employee);
        Assertions.assertEquals("Amrit", employee.getFirstName());
    }

    @Test
    public void testRead1() {
        Iterable<Employee> employee = employeeRepository.findAll();
        Iterator iterator = employee.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //(7) Get the total count of the number of Employees
    @Test
    public void testCounting() {
        long count = employeeRepository.count();
        System.out.println("Total Employees in Employee Table = " + count);
    }

    //(8) Implement Pagination and Sorting on the bases of Employee Age
    @Test
    public void testPagination() {
        Pageable sortedByAge = PageRequest.of(0, 1, Sort.by("age"));
        List<Employee> empData = new ArrayList<>();
        employeeRepository.findAll().forEach(empData::add);
        System.out.println(empData);
    }
}
