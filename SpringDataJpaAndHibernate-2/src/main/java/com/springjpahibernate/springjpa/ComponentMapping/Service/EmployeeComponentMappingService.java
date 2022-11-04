package com.springjpahibernate.springjpa.ComponentMapping.Service;

import com.springjpahibernate.springjpa.ComponentMapping.Entities.EmployeeComponentMapping;
import com.springjpahibernate.springjpa.ComponentMapping.Repository.EmployeeComponentMappingRepository;
import com.springjpahibernate.springjpa.InheritanceMapping.Seed.EmployeeSeedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeComponentMappingService {

    /*
       Here Autowired the reference of EmployeeComponentMappingRepository Interface which is present
       in the package com.springjpahibernate.springjpa.ComponentMapping.Repository
   */
    @Autowired
    EmployeeComponentMappingRepository employeeComponentMappingRepository;

    /*
      Here Autowired the reference of EmployeeSeedClass class which is present
      in the com.springjpahibernate.springjpa.InheritanceMapping.Seed Package.
      We Autowire this class Reference because we have to use method which will create
      the records in the database table.
    */
    @Autowired
    EmployeeSeedClass employeeSeed;

    /*
        Function which help to call the findAll() method of the EmployeeJoinedStrategyRepository
        Repository which will return all the employees and this function will Return_Back the records to the
        Controller and Controller return employees list to the EndPoint AS WELL AS print on the console.
    */
    public List<EmployeeComponentMapping> getAllEmployee() {
        return employeeComponentMappingRepository.findAll();
    }

    /*
        Method Which is called by Controller and this method call getEmployeeComponentMapping method
        which will create records in the database according to the value of no.
    */
    public void createDummyEmployee(Integer no) {
        employeeSeed.getEmployeeComponentMapping(no);
    }

    /*
        Function which help to call the findById() method of the EmployeeComponentMapping
        Repository which will return an employee according to provided id if any employee present with that id
        and this function will Return_Back the record to the
        Controller and Controller return that employee record to the EndPoint AS WELL AS print on the console.
    */
    public EmployeeComponentMapping getEmployeeById(Integer id) {
        return employeeComponentMappingRepository.findById(id).get();
    }

    /*
       Method used for creating a record in the database table EmployeeComponentMapping.
       Object will be passed in the form of JSON Format without id because id
       is primary key should be Auto_Generated.
   */
    public void createEmployeeComponentMapping(EmployeeComponentMapping employeeComponentMapping) {
        employeeComponentMappingRepository.save(employeeComponentMapping);
    }
}
