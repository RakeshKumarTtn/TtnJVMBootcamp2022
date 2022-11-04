package com.springjpahibernate.springjpa.InheritanceMapping.Seed;

import com.springjpahibernate.springjpa.ComponentMapping.Entities.EmployeeComponentMapping;
import com.springjpahibernate.springjpa.ComponentMapping.Entities.Salary;
import com.springjpahibernate.springjpa.ComponentMapping.Repository.EmployeeComponentMappingRepository;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.ContractEmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.EmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Entities.PermanentEmployeeJoinedStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Repository.EmployeeJoinedStrategyRepository;
import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities.ContractEmployee;
import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities.EmployeeSingleTableStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities.PermanentEmployee;
import com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Repository.EmployeeSingleTableStrategyRepository;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.ContractEmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.EmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Entities.PermanentEmployeeTablePerClassStrategy;
import com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Repository.EmployeeTablePerClassStrategyRepository;
import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Seed.EmployeeSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/*
    This class play important role while creating data in the database
    This class contains method when we called that method it will generate the record which
    we passed as parameter to this method in the database
    This class take help from the EmployeeSeed class which I created in the JPQL Package for
    creating the random firstName, lastName, salary, location and designations.
*/
@Component
public class EmployeeSeedClass {

    /*
        Here Autowired the reference of EmployeeSeed class which is present
        in the com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Seed Package
    */
    @Autowired
    EmployeeSeed employeesSeed;

    /*
        Here Autowired the reference of EmployeeSingleTableStrategyRepository Interface which is present
        in the com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Repository Package
    */
    @Autowired
    EmployeeSingleTableStrategyRepository employeeSingleTableStrategyRepository;

    /*
        Here Autowired the reference of EmployeeTablePerClassStrategyRepository Interface which is present
        in the com.springjpahibernate.springjpa.InheritanceMapping.TablePerClassStrategy.Repository Package
    */
    @Autowired
    EmployeeTablePerClassStrategyRepository employeeTablePerClassStrategyRepository;

    /*
        Here Autowired the reference of EmployeeJoinedStrategyRepository Interface which is present
        in the com.springjpahibernate.springjpa.InheritanceMapping.JoinedStrategy.Repository Package
    */
    @Autowired
    EmployeeJoinedStrategyRepository employeeJoinedStrategyRepository;

    /*
        Here Autowired the reference of EmployeeSingleTableStrategyRepository class which is present
        in the com.springjpahibernate.springjpa.ComponentMapping.Repository Package
    */
    @Autowired
    EmployeeComponentMappingRepository employeeComponentMappingRepository;

    //This object helps for applying double precision in the double values like salaries
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //Help Creating data in the database table while performing Single_Table_Strategy Inheritance Mapping
    public void getEmployees(Integer no) {
        List<EmployeeSingleTableStrategy> employees = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i <= no; i++) {
            if (flag) {
                PermanentEmployee perEmp = new PermanentEmployee();
                perEmp.setName(employeesSeed.getEmployeeFirstNames() + " " + employeesSeed.getEmployeeLastNames());
                perEmp.setDesignation(employeesSeed.getDesignation());
                flag = false;
                employees.add(perEmp);
            } else {
                ContractEmployee conEmp = new ContractEmployee();
                conEmp.setName(employeesSeed.getEmployeeFirstNames() + " " + employeesSeed.getEmployeeLastNames());
                conEmp.setDesignation(employeesSeed.getDesignation());
                flag = true;
                employees.add(conEmp);
            }
        }
        employeeSingleTableStrategyRepository.saveAll(employees);
    }


    //Help Creating data in the database table while performing Table_Per_Class_Strategy Inheritance Mapping
    public void getEmployeeTablePerClassStrategy(Integer no) {
        List<EmployeeTablePerClassStrategy> employees = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i <= no; i++) {
            if (flag) {
                PermanentEmployeeTablePerClassStrategy perEmp = new PermanentEmployeeTablePerClassStrategy();
                perEmp.setName(employeesSeed.getEmployeeFirstNames() + " " + employeesSeed.getEmployeeLastNames());
                perEmp.setDesignation(employeesSeed.getDesignation());
                flag = false;
                employees.add(perEmp);
            } else {
                ContractEmployeeTablePerClassStrategy conEmp = new ContractEmployeeTablePerClassStrategy();
                conEmp.setName(employeesSeed.getEmployeeFirstNames() + " " + employeesSeed.getEmployeeLastNames());
                conEmp.setDesignation(employeesSeed.getDesignation());
                flag = true;
                employees.add(conEmp);
            }
        }
        employeeTablePerClassStrategyRepository.saveAll(employees);
    }


    //Help Creating data in the database table while performing Joined_Strategy Inheritance Mapping
    public void getEmployeesJoinedStrategy(Integer no) {
        List<EmployeeJoinedStrategy> employees = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i <= no; i++) {
            if (flag) {
                PermanentEmployeeJoinedStrategy perEmp = new PermanentEmployeeJoinedStrategy();
                perEmp.setName(employeesSeed.getEmployeeFirstNames() + " " + employeesSeed.getEmployeeLastNames());
                perEmp.setDesignation(employeesSeed.getDesignation());
                flag = false;
                employees.add(perEmp);
            } else {
                ContractEmployeeJoinedStrategy conEmp = new ContractEmployeeJoinedStrategy();
                conEmp.setName(employeesSeed.getEmployeeFirstNames() + " " + employeesSeed.getEmployeeLastNames());
                conEmp.setDesignation(employeesSeed.getDesignation());
                flag = true;
                employees.add(conEmp);
            }
        }
        employeeJoinedStrategyRepository.saveAll(employees);
    }

    //Help Creating data in the database table while performing Component Mapping
    public void getEmployeeComponentMapping(Integer no) {
        List<EmployeeComponentMapping> employees = new ArrayList<>();
        for (int i = 1; i <= no; i++) {
            EmployeeComponentMapping employeeComponentMapping = new EmployeeComponentMapping();
            employeeComponentMapping.setFirstName(employeesSeed.getEmployeeFirstNames());
            employeeComponentMapping.setLastName(employeesSeed.getEmployeeLastNames());
            employeeComponentMapping.setAge(employeesSeed.getRandomIndex(10, 90));

            Salary salary = new Salary();
            salary.setBasicSalary(Double.valueOf(df.format(employeesSeed.getRandomSalary(10000D, 50000D))));
            salary.setBonusSalary(Double.valueOf(df.format(employeesSeed.getRandomSalary(1000D, 5000D))));
            salary.setTaxAmount(Double.valueOf(df.format(employeesSeed.getRandomSalary(1000D, 5000D))));
            salary.setSpecialAllowanceSalary(Double.valueOf(df.format(employeesSeed.getRandomSalary(10000D, 15000D))));
            employeeComponentMapping.setSalary(salary);
            employees.add(employeeComponentMapping);
        }
        employeeComponentMappingRepository.saveAll(employees);
    }
}