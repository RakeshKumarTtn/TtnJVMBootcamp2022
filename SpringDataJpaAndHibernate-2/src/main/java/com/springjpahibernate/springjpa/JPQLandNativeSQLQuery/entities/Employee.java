package com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.entities;

/*
     Instructions for JPQL and Native SQL Query
     Create an employeeTable table with the following fields: empId, empFirstName, empLastName, empSalary, empAge.
     Create an Employee entity having following fields: id, firstName, lastName, salary, age which maps to the table columns given in above.

     JPQL:

        1. Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
        2. Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
        3. Delete all employees with minimum salary.

     Native SQL Query:

         Display the id, first name, age of all employees where last name ends with "singh"
         Delete all employees with age greater than 45(Should be passed as a parameter)

     Inheritance Mapping:

         Implement and demonstrate Single Table strategy.
         Implement and demonstrate Joined strategy.
         Implement and demonstrate Table Per Class strategy.

     Component Mapping:

         Implement and demonstrate Embedded mapping using employee table having following fields: id, firstName, lastName, age, basicSalary, bonusSalary, taxAmount, specialAllowanceSalary.
*/


import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_Id")
    private int id;

    @NonNull
    @Size(min = 2)
    @Column(name = "emp_first_name")
    private String firstName;

    @NonNull
    @Size(min = 2)
    @Column(name = "emp_last_name")
    private String lastName;

    @NonNull
    @Min(10000)
    @Column(name = "emp_salary", precision = 2)
    private double salary;

    @NonNull
    @Min(20)
    @Max(100)
    @Column(name = "emp_age")
    private int age;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
        Here we Override the toString Method for printing the User_Friendly
        Information about the object not the CLASSNAME@Hexadecimal Equivalent of hashcode.
    */
    @Override
    public String toString() {
        return String.format(
                "Employee[id = %d," +
                        "\n\t\t firstName = '%s',\n\t\t " +
                        "lastName = '%s',\n\t\t salary = '%.2f'" +
                        ",\n\t\t age = %d\n]", id, firstName, lastName, salary, age);
    }
}