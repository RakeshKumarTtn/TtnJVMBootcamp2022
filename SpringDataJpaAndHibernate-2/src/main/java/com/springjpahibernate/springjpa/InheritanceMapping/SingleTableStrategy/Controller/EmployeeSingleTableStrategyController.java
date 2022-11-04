package com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Controller;

import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities.ContractEmployee;
import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities.EmployeeSingleTableStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities.PermanentEmployee;
import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Service.EmployeeSingleTableStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeSingleTableStrategyController {

    /*
        Here Autowired the reference of EmployeeSingleTableStrategyRepository Interface which is present
        in the com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Service Package
    */
    @Autowired
    EmployeeSingleTableStrategyService employeeSingleTableStrategyService;

    /*
        EndPoint for Creating records in the database table.
        Count of the record to be created will be passed as the parameter when hitting the EndPoint
    */
    @PostMapping("/create/employeeSingleTableStrategy")
    public ResponseEntity<EmployeeSingleTableStrategy> createDummyEmployee(@Param("no") Integer no) {
        employeeSingleTableStrategyService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeSingleTableStrategy")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
        EndPoint for Getting records from the database table.
        Records Getting form the database will be return to the EndPoint as well as
        Print on the Console.
    */
    @GetMapping("/employeeSingleTableStrategy")
    public List<EmployeeSingleTableStrategy> getEmployee() {
        List<EmployeeSingleTableStrategy> employees = employeeSingleTableStrategyService.getAllEmployee();
        Iterator iterator = employees.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        return employees;
    }

    /*
        EndPoint for Creating records in the database table.
        Count of the record to be created will be passed as the PathVariable(
        at the end of the EndPoint like localhost:8080/employeeSingleTableStrategy/4)
        when hitting the EndPoint
    */
    @GetMapping("/employeeSingleTableStrategy/{id}")
    public EmployeeSingleTableStrategy getEmployeeById(@PathVariable("id") Integer id) {
        return employeeSingleTableStrategyService.getEmployeeById(id);
    }

    /*
        EndPoint for Creating record in the database table permanentEmployee.
        Record to be Created Passed in the form of JSON object when hitting the URL
        Remember Donot pass the id in JSON Object Because id is the primary key should be Auto_Generated.
    */
    @PostMapping("/employeeSingleTableStrategy/create/permanent")
    public ResponseEntity<EmployeeSingleTableStrategy> createEmployeePermanent(
            @RequestBody PermanentEmployee permanentEmployeeData
    ) {
        employeeSingleTableStrategyService.createEmployeePermanent(permanentEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeSingleTableStrategy/" + permanentEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
        EndPoint for Creating record in the database table contractEmployee.
        Record to be Created Passed in the form of JSON object when hitting the URL
        Remember Donot pass the id in JSON Object Because id is the primary key should be Auto_Generated.
    */
    @PostMapping("/employeeSingleTableStrategy/create/contract")
    public ResponseEntity<EmployeeSingleTableStrategy> createEmployeeContract(
            @RequestBody ContractEmployee contractEmployeeData
    ) {
        employeeSingleTableStrategyService.createEmployeeContract(contractEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeSingleTableStrategy/" + contractEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
