package com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Repository;

import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities.EmployeeSingleTableStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
    EmployeeSingleTableStrategyRepository is the interface which extends another interface CrudRepository
    Which provide several method for Creation, Retrieval, Updation and Deletion data on the database.
*/
public interface EmployeeSingleTableStrategyRepository extends CrudRepository<EmployeeSingleTableStrategy, Integer> {
    List<EmployeeSingleTableStrategy> findAll();
}
