package com.springjpahibernate.springjpa.ComponentMapping.Repository;

import com.springjpahibernate.springjpa.ComponentMapping.Entities.EmployeeComponentMapping;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
    EmployeeComponentMappingRepository is the interface which extends another interface CrudRepository
    Which provide several method for Creation, Retrieval, Updation and Deletion data on the database.
*/
public interface EmployeeComponentMappingRepository extends CrudRepository<EmployeeComponentMapping,Integer> {
    List<EmployeeComponentMapping> findAll();
}
