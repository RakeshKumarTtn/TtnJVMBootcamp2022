package com.springjpahibernate.springjpa.InheritanceMapping.SingleTableStrategy.Entities;

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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "contract")
public class ContractEmployee extends EmployeeSingleTableStrategy {
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /*
        Here we Override the toString Method for printing the User_Friendly
        Information about the object not the CLASSNAME@Hexadecimal Equivalent of hashcode.
    */
    public String toString() {
        return String.format(
                "PermanentEmployee[\n\t\t\t\t\t id  = %d," +
                        "\n\t\t\t\t\t name = '%s',\n\t\t\t\t\t " +
                        "designation = '%s'" +
                        "\n]", super.getId(), super.getName(), designation);
    }
}
