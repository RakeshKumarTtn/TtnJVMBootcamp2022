package com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Repository;

import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.EmployeeJoinedStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
    EmployeeJoinedStrategyRepository is the interface which extends another interface CrudRepository
    Which provide several method for Creation, Retrieval, Updation and Deletion data on the database.
*/
public interface EmployeeJoinedStrategyRepository extends CrudRepository<EmployeeJoinedStrategy, Integer> {
    List<EmployeeJoinedStrategy> findAll();
}
