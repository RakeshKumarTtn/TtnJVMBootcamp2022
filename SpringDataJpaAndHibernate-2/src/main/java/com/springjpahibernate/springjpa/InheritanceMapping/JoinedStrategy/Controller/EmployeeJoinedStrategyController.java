package com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Controller;

import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.ContractEmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.EmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.PermanentEmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Service.EmployeeJoinedStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeJoinedStrategyController {

    /*
        Here Autowired the reference of EmployeeJoinedStrategyService Interface which is present
        in the package com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Service
    */
    @Autowired
    EmployeeJoinedStrategyService employeeJoinedStrategyService;

    /*
        EndPoint for Creating records in the database table.
        Count of the record to be created will be passed as the parameter when hitting the EndPoint
    */
    @PostMapping("/create/employeeJoinedStrategyService")
    public ResponseEntity<EmployeeJoinedStrategy> createDummyEmployee(@Param("no") Integer no) {
        employeeJoinedStrategyService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeJoinedStrategyService")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
        EndPoint for Getting records from the database table.
        Records Getting form the database will be return to the EndPoint as well as
        Print on the Console.
    */
    @GetMapping("/employeeJoinedStrategyService")
    public List<EmployeeJoinedStrategy> getEmployee() {
        List<EmployeeJoinedStrategy> employees = employeeJoinedStrategyService.getAllEmployee();
        Iterator iterator = employees.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        return employees;
    }

    /*
        EndPoint for Creating records in the database table.
        Count of the record to be created will be passed as the PathVariable(
        at the end of the EndPoint like localhost:8080/employeeJoinedStrategyService/4)
        when hitting the EndPoint
    */
    @GetMapping("/employeeJoinedStrategyService/{id}")
    public EmployeeJoinedStrategy getEmployeeById(@PathVariable("id") Integer id) {
        EmployeeJoinedStrategy employee = employeeJoinedStrategyService.getEmployeeById(id);
        System.out.println(employee);
        return employee;
    }

    /*
        EndPoint for Creating record in the database table permanentJoinedEmployee.
        Record to be Created Passed in the form of JSON object when hitting the URL
        Remember Donot pass the id in JSON Object Because id is the primary key should be Auto_Generated.
    */
    @PostMapping("/employeeJoinedStrategyService/create/permanent")
    public ResponseEntity<EmployeeJoinedStrategy> createEmployeePermanent(
            @RequestBody PermanentEmployeeJoinedStrategy permanentEmployeeTablePerClassStrategyData
    ) {
        employeeJoinedStrategyService.createEmployeePermanent(permanentEmployeeTablePerClassStrategyData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeJoinedStrategyService/" + permanentEmployeeTablePerClassStrategyData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
       EndPoint for Creating record in the database table contractJoinedEmployee.
       Record to be Created Passed in the form of JSON object when hitting the URL
       Remember Donot pass the id in JSON Object Because id is the primary key should be Auto_Generated.
   */
    @PostMapping("/employeeJoinedStrategyService/create/contract")
    public ResponseEntity<EmployeeJoinedStrategy> createEmployeeContract(
            @RequestBody ContractEmployeeJoinedStrategy contractEmployeeData
    ) {
        employeeJoinedStrategyService.createEmployeeContract(contractEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeJoinedStrategyService/" + contractEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }
}


