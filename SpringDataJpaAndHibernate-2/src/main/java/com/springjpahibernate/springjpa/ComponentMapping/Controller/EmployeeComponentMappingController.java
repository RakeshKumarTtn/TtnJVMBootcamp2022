package com.springjpahibernate.springjpa.ComponentMapping.Controller;

import com.springjpahibernate.springjpa.ComponentMapping.Entities.EmployeeComponentMapping;
import com.springjpahibernate.springjpa.ComponentMapping.Service.EmployeeComponentMappingService;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.EmployeeJoinedStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeComponentMappingController {

    /*
       Here Autowired the reference of EmployeeComponentMappingService Interface which is present
       in the package com.springjpahibernate.springjpa.ComponentMapping.Service
   */
    @Autowired
    EmployeeComponentMappingService employeeComponentMappingService;

    /*
        EndPoint for Creating records in the database table.
        Count of the record to be created will be passed as the parameter when hitting the EndPoint
    */
    @PostMapping("/create/employeeComponentMapping")
    public ResponseEntity<EmployeeComponentMapping> createDummyEmployee(@Param("no") Integer no) {
        employeeComponentMappingService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeComponentMapping")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
       EndPoint for Getting records from the database table.
       Records Getting form the database will be return to the EndPoint as well as
       Print on the Console.
   */
    @GetMapping("/employeeComponentMapping")
    public List<EmployeeComponentMapping> getEmployee() {
        List<EmployeeComponentMapping> employees =
                employeeComponentMappingService.getAllEmployee();
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
    @GetMapping("/employeeComponentMapping/{id}")
    public EmployeeComponentMapping getEmployeeById(@PathVariable("id") Integer id) {
        EmployeeComponentMapping employee =
                employeeComponentMappingService.getEmployeeById(id);
        System.out.println(employee);
        return employee;
    }

    /*
        EndPoint for Creating record in the database table EmployeeComponentMapping.
        Record to be Created Passed in the form of JSON object when hitting the URL
        Remember Donot pass the id in JSON Object Because id is the primary key should be Auto_Generated.
    */
    @PostMapping("/create/employeeComponentMappingRow")
    public ResponseEntity<EmployeeJoinedStrategy> createEmployeeComponentMapping(
            @RequestBody EmployeeComponentMapping employeeComponentMapping
    ) {
        employeeComponentMappingService.createEmployeeComponentMapping(employeeComponentMapping);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeComponentMapping/" + employeeComponentMapping.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
