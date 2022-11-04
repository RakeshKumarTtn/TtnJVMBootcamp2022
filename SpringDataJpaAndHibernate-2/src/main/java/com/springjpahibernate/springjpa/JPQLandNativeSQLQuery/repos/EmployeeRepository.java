package com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.repos;

import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();

    /************ JAVA PERSISTENCE QUERY LANGUAGE ************/
    /*
         Display the first name, last name of all employees having salary greater than average salary ordered
         in ascending by their age and in descending by their salary.
    */
    @Query("FROM Employee emp WHERE emp.salary > (SELECT AVG(e.salary) FROM Employee e) ORDER BY emp.age ASC,emp.salary DESC")
    public List<Employee> findEmployeeBySalaryGreaterThanAverageSalary();

    //function for finding the AVERAGE salary of an employee
    @Query("SELECT AVG(emp.salary) FROM Employee emp")
    public Optional<Double> findAverageSalary();

    //function for finding the MIN salary of an employee
    @Query("SELECT MIN(emp.salary) FROM Employee emp")
    public Optional<Double> findMinSalary();

    /*
         Update salary of all employees by a salary passed as
         a parameter whose existing salary is less than the average salary.
    */
    @Modifying
    @Query("UPDATE Employee emp SET emp.salary = :avgSal WHERE emp.salary < :averageSal")
    public void updateEmployeesSalaryWhoseSalaryLessThanAverageSalary(@Param("avgSal") double empSalary, @Param("averageSal") double avgSalary);

    /*
        Delete all employees with minimum salary.
    */
    @Modifying
    @Query("Delete from Employee emp where emp.salary <=:minSalary")
    void deleteEmployeesWithMinimumSalary(@Param("minSalary") Double minSalary);

    //function for finding the AVERAGE salary of employee
    @Query("select avg(emp.salary) from Employee emp")
    Double getAvgSalary();

    //function for finding the MIN salary among the employees
    @Query("select min(emp.salary) from Employee emp")
    Double getMinSalary();

    /************ NATIVE SQL QUERIES ************/
    /*
       1. Display the id, first name, age of all employees where last name ends with "singh"
    */
    @Query(value = "Select emp.emp_Id,emp.emp_first_name,emp.emp_age from employee_table emp where emp.emp_last_name Like :str", nativeQuery = true)
    List<Object[]> getAllEmployeesWhoseLastNameIsSingh(@Param("str") String str);

    /*
        2. Delete all employees with age greater than 45(Should be passed as a parameter)
    */
    @Modifying
    @Query(value = "delete from employee_table emp where emp.emp_age >:age", nativeQuery = true)
    void deleteAllEmployeeAgeGreaterThan45(@Param("age") Integer age);
}
