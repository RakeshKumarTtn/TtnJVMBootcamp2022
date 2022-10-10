package com.java.collection.secondQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class salaryWiseSortComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee, Employee t1) {
        if (employee.getEmpSalary() > t1.getEmpSalary()) return 1;
        else if (employee.getEmpSalary() < t1.getEmpSalary()) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class EmployeeComparator {


    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Pulkit Singh", 29, 125000));
        employees.add(new Employee("Mohit Sharma", 23, 88000));
        employees.add(new Employee("Sunny Singh", 27, 54000));
        employees.add(new Employee("Shushant Singh", 33, 13000));
        employees.add(new Employee("Deepak Gera", 44, 30500));
        employees.add(new Employee("Amit Rajput", 56, 39000));

        Collections.sort(employees, new salaryWiseSortComparator());
        for (Employee employee : employees) {
            System.out.println("Employee Name : " + employee.getEmpName());
            System.out.println("Employee Age : " + employee.getEmpAge());
            System.out.println("Employee Salary : " + employee.getEmpSalary() + "\n");
        }
    }
}
