package com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Repository;

import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.EmployeeTablePerClassStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
    EmployeeTablePerClassStrategyRepository is the interface which extends another interface CrudRepository
    Which provide several method for Creation, Retrieval, Updation and Deletion data on the database.
*/
public interface EmployeeTablePerClassStrategyRepository extends CrudRepository<EmployeeTablePerClassStrategy, Integer> {
    List<EmployeeTablePerClassStrategy> findAll();
}