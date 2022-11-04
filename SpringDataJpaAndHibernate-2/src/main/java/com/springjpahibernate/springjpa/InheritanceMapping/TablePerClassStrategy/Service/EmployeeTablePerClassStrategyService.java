package com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Service;

import com.springjpahibernate.springjpa.InheritanceMapping.Seed.EmployeeSeedClass;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.ContractEmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.EmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.PermanentEmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Repository.EmployeeTablePerClassStrategyRepository;
import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Seed.EmployeeSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeTablePerClassStrategyService {

    /*
       Here Autowired the reference of EmployeeTablePerClassStrategyRepository Interface which is present
       in the package com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Repository
   */
    @Autowired
    private EmployeeTablePerClassStrategyRepository employeeTablePerClassStrategyRepository;

    /*
       Here Autowired the reference of EmployeeSeedClass class which is present
       in the com.springjpahibernate.springjpa.InheritanceMapping.Seed Package.
       We Autowire this class Reference because we have to use method which will create
       the records in the database table.
   */
    @Autowired
    private EmployeeSeedClass employeeSeed;

    /*
        Function which help to call the findAll() method of the EmployeeSingleTableStrategyRepository
        Repository which will return all the employees and this function will Return_Back the records to the
        Controller and Controller return employees list to the EndPoint AS WELL AS print on the console.
    */
    public List<EmployeeTablePerClassStrategy> getAllEmployee() {
        return employeeTablePerClassStrategyRepository.findAll();
    }

    /*
       Method Which is called by Controller and this method call getEmployees method
       which will create records in the database according to the value of no.
   */
    public void createDummyEmployee(Integer no) {
        employeeSeed.getEmployeeTablePerClassStrategy(no);
    }

    /*
        Function which help to call the findById() method of the EmployeeSingleTableStrategyRepository
        Repository which will return an employee according to provided id if any employee present with that id
        and this function will Return_Back the record to the
        Controller and Controller return that employee record to the EndPoint AS WELL AS print on the console.
    */
    public EmployeeTablePerClassStrategy getEmployeeById(Integer id) {
        return employeeTablePerClassStrategyRepository.findById(id).get();
    }

    /*
       Method used for creating a record in the database table permanentEmployee.
       Object will be passed in the form of JSON Format without id because id
       is primary key should be Auto_Generated.
   */
    public void createEmployeePermanent(PermanentEmployeeTablePerClassStrategy permanentEmployeeTablePerClassStrategyData) {
        employeeTablePerClassStrategyRepository.save(permanentEmployeeTablePerClassStrategyData);
    }

    /*
        Method used for creating a record in the database table contractEmployee.
        Object will be passed in the form of JSON Format without id because id
        is primary key should be Auto_Generated.
    */
    public void createEmployeeContract(ContractEmployeeTablePerClassStrategy contractEmployeeData) {
        employeeTablePerClassStrategyRepository.save(contractEmployeeData);
    }
}
