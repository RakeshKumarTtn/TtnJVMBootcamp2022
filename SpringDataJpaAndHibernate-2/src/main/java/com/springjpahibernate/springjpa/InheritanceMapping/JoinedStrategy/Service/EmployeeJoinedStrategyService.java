package com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Service;

import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.ContractEmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.EmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.PermanentEmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Repository.EmployeeJoinedStrategyRepository;
import com.springjpahibernate.springjpa.InheritanceMapping.Seed.EmployeeSeedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeJoinedStrategyService {

    /*
       Here Autowired the reference of EmployeeJoinedStrategyRepository Interface which is present
       in the package com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Repository
   */
    @Autowired
    private EmployeeJoinedStrategyRepository employeeJoinedStrategyRepository;

    /*
       Here Autowired the reference of EmployeeSeedClass class which is present
       in the com.springjpahibernate.springjpa.InheritanceMapping.Seed Package.
       We Autowire this class Reference because we have to use method which will create
       the records in the database table.
   */
    @Autowired
    private EmployeeSeedClass employeeSeed;

    /*
        Function which help to call the findAll() method of the EmployeeJoinedStrategyRepository
        Repository which will return all the employees and this function will Return_Back the records to the
        Controller and Controller return employees list to the EndPoint AS WELL AS print on the console.
    */
    public List<EmployeeJoinedStrategy> getAllEmployee() {
        return employeeJoinedStrategyRepository.findAll();
    }

    /*
        Method Which is called by Controller and this method call getEmployees method
        which will create records in the database according to the value of no.
    */
    public void createDummyEmployee(Integer no) {
        employeeSeed.getEmployeesJoinedStrategy(no);
    }

    /*
        Function which help to call the findById() method of the EmployeeJoinedStrategyRepository
        Repository which will return an employee according to provided id if any employee present with that id
        and this function will Return_Back the record to the
        Controller and Controller return that employee record to the EndPoint AS WELL AS print on the console.
    */
    public EmployeeJoinedStrategy getEmployeeById(Integer id) {
        return employeeJoinedStrategyRepository.findById(id).get();
    }

    /*
       Method used for creating a record in the database table permanentJoinedEmployee.
       Object will be passed in the form of JSON Format without id because id
       is primary key should be Auto_Generated.
    */
    public void createEmployeePermanent(PermanentEmployeeJoinedStrategy permanentEmployeeTablePerClassStrategyData) {
        employeeJoinedStrategyRepository.save(permanentEmployeeTablePerClassStrategyData);
    }

    /*
        Method used for creating a record in the database table contractJoinedEmployee.
        Object will be passed in the form of JSON Format without id because id
        is primary key should be Auto_Generated.
    */
    public void createEmployeeContract(ContractEmployeeJoinedStrategy contractEmployeeData) {
        employeeJoinedStrategyRepository.save(contractEmployeeData);
    }
}