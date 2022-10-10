package com.java.collection.secondQuestion;

public class Employee implements Comparable {

    private double empAge, empSalary;
    private String empName;

    /*Employee Class Constructor*/
    public Employee(String empName, double empAge, double empSalary) {
        this.empName = empName;
        this.empAge = empAge;
        this.empSalary = empSalary;
    }

    /* Overriding compareTo method here */
    @Override
    public int compareTo(Object o) {
        Employee emp = (Employee) o;
        return this.empName.compareTo(emp.empName);
    }

    /*getters and setters of employee class*/
    public double getEmpAge() {
        return empAge;
    }

    public void setEmpAge(double empAge) {
        this.empAge = empAge;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
