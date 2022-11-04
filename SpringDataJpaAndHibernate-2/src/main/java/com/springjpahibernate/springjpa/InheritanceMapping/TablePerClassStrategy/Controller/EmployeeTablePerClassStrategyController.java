package com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Controller;

import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.ContractEmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.EmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.PermanentEmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Service.EmployeeTablePerClassStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeTablePerClassStrategyController {

    /*
        Here Autowired the reference of EmployeeSingleTableStrategyRepository Interface which is present
        in the package com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Service
    */
    @Autowired
    EmployeeTablePerClassStrategyService employeeTablePerClassStrategyService;

    /*
       EndPoint for Creating records in the database table.
       Count of the record to be created will be passed as the parameter when hitting the EndPoint
    */
    @PostMapping("/create/employeeTablePerClassStrategy")
    public ResponseEntity<EmployeeTablePerClassStrategy> createDummyEmployee(@Param("no") Integer no) {
        employeeTablePerClassStrategyService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeTablePerClassStrategy")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
        EndPoint for Getting records from the database table.
        Records Getting form the database will be return to the EndPoint as well as
        Print on the Console.
    */
    @GetMapping("/employeeTablePerClassStrategy")
    public List<EmployeeTablePerClassStrategy> getEmployee() {
        List<EmployeeTablePerClassStrategy> employees = employeeTablePerClassStrategyService.getAllEmployee();
        Iterator iterator = employees.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        return employees;
    }

    /*
       EndPoint for Creating records in the database table.
       Count of the record to be created will be passed as the PathVariable(
       at the end of the EndPoint like localhost:8080/employeeTablePerClassStrategy/4)
       when hitting the EndPoint
   */
    @GetMapping("/employeeTablePerClassStrategy/{id}")
    public EmployeeTablePerClassStrategy getEmployeeById(@PathVariable("id") Integer id) {
        EmployeeTablePerClassStrategy employee = employeeTablePerClassStrategyService.getEmployeeById(id);
        System.out.println(employee);
        return employee;
    }

    /*
        EndPoint for Creating record in the database table permanentEmployee.
        Record to be Created Passed in the form of JSON object when hitting the URL
        Remember Donot pass the id in JSON Object Because id is the primary key should be Auto_Generated.
    */
    @PostMapping("/employeeTablePerClassStrategy/create/permanent")
    public ResponseEntity<EmployeeTablePerClassStrategy> createEmployeePermanent(
            @RequestBody PermanentEmployeeTablePerClassStrategy permanentEmployeeTablePerClassStrategyData
    ) {
        employeeTablePerClassStrategyService.createEmployeePermanent(permanentEmployeeTablePerClassStrategyData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeTablePerClassStrategy/" + permanentEmployeeTablePerClassStrategyData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
       EndPoint for Creating record in the database table contractEmployee.
       Record to be Created Passed in the form of JSON object when hitting the URL
       Remember Donot pass the id in JSON Object Because id is the primary key should be Auto_Generated.
   */
    @PostMapping("/employeeTablePerClassStrategy/create/contract")
    public ResponseEntity<EmployeeTablePerClassStrategy> createEmployeeContract(
            @RequestBody ContractEmployeeTablePerClassStrategy contractEmployeeData
    ) {
        employeeTablePerClassStrategyService.createEmployeeContract(contractEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeTablePerClassStrategy/" + contractEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
