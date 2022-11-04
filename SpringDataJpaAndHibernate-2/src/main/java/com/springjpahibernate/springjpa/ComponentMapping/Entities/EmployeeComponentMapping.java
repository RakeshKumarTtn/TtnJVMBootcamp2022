package com.springjpahibernate.springjpa.ComponentMapping.Entities;

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

import javax.persistence.*;

@Entity
public class EmployeeComponentMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @Embedded
    private Salary salary;

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*
        Here we Override the toString Method for printing the User_Friendly
        Information about the object not the CLASSNAME@Hexadecimal Equivalent of hashcode.
    */
    @Override
    public String toString() {
        return String.format(
                "EmployeeComponentMapping[id = %d," +
                        "\n\t\t\t\t\t firstName = '%s',\n\t\t\t\t\t " +
                        "lastName = '%s',\n\t\t\t\t\t age = '%d'" +
                        ",\n\t\t\t\t\t basicSalary = %.2f" +
                        ",\n\t\t\t\t\t bonusSalary = %.2f " +
                        ",\n\t\t\t\t\t taxAmount = %.2f" +
                        ",\n\t\t\t\t\t specialAllowanceSalary = %.2f" +
                        "\n]", id, firstName, lastName, age, salary.getBasicSalary(),
                salary.getBonusSalary(), salary.getTaxAmount(), salary.getSpecialAllowanceSalary());
    }
}

