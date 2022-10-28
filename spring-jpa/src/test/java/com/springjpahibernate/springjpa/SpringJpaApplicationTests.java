package com.springjpahibernate.springjpa;

import com.springjpahibernate.springjpa.entities.Employee;
import com.springjpahibernate.springjpa.repos.EmployeeRepository;
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
import java.util.Collections;
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
        Employee employee1 = new Employee("Rakesh", 25, "Faridabad");
        Employee employee2 = new Employee("Amrit", 29, "Delhi");
        Employee employee3 = new Employee("Vijay", 26, "Punjab");
        Employee employee4 = new Employee("Simran", 49, "Mumbai");
        Employee employee5 = new Employee("Shivani", 15, "Faridabad");
        List<Employee> list = new ArrayList<>();
        Collections.addAll(list, employee1, employee2, employee3, employee4, employee5);
        employeeRepository.saveAll(list);
    }

    //(4) Perform Update Operation on Entity using Spring Data JPA
    @Test
    public void testUpdate() {
        Employee employee = employeeRepository.findById(3).get();
        employee.setAge(30);
        employee.setName("Sourabh");
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
        Employee employee = employeeRepository.findById(8).get();
        Assertions.assertNotNull(employee);
        Assertions.assertEquals("Vijay", employee.getName());
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
        employeeRepository.findAll(sortedByAge).forEach(empData::add);
        System.out.println(empData);
    }

    //(9) Create and use finder to find Employee by Name
    @Test
    public void testFindByName() {
        List<Employee> employeeList = employeeRepository.findByName("Simran");
        Iterator iterator = employeeList.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    //(10) Create and use finder to find Employees starting with A character
    @Test
    public void testFindByStartingCharacter() {
        List<Employee> employeeList = employeeRepository.findByNameLike("S%");
        Iterator iterator = employeeList.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    //(11) Create and use finder to find Employees Between the age of 28 to 32
    @Test
    public void testFindByAgeBetweenRange() {
        List<Employee> employeeList = employeeRepository.findByAgeBetween(20, 30);
        Iterator iterator = employeeList.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
