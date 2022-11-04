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

import javax.persistence.Embeddable;

@Embeddable
public class Salary {
    private Double basicSalary;
    private Double bonusSalary;
    private Double taxAmount;
    private Double specialAllowanceSalary;

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(Double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getSpecialAllowanceSalary() {
        return specialAllowanceSalary;
    }

    public void setSpecialAllowanceSalary(Double specialAllowanceSalary) {
        this.specialAllowanceSalary = specialAllowanceSalary;
    }
}