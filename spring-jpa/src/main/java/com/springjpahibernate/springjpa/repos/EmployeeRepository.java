package com.springjpahibernate.springjpa.repos;

import com.springjpahibernate.springjpa.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//(2) Set up EmployeeRepository with Spring Data JPA
public interface EmployeeRepository extends CrudRepository<Employee, Integer>,
PagingAndSortingRepository<Employee, Integer> {
    List<Employee> findByName(String name);

    List<Employee> findByNameLike(String character);

    List<Employee> findByAgeBetween(Integer start, Integer end);
}
