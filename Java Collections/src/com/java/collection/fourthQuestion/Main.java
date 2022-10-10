package com.java.collection.fourthQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String name, designation;
        int age, salary;
        Map<Employee, Integer> employeeSalary = new HashMap<Employee, Integer>();

        /*** Making objects of Employee class here ***/
        Employee emp1 = new Employee("Pooja Negi", "JVM", 27);
        Employee emp2 = new Employee("Manish Kumar", "Data Engineer", 28);
        Employee emp3 = new Employee("Kajal Singh", "DevOps", 29);
        Employee emp4 = new Employee("Sapna Singh", "JVM-😘", 22);

        /*** Putting the necessary data in HashMap ***/
        employeeSalary.put(emp1, 25000);
        employeeSalary.put(emp2, 30000);
        employeeSalary.put(emp3, 27000);
        employeeSalary.put(emp4, 25000);

        /*** Printing employee name and employee salary  from the hashmap***/
        for (Employee key : employeeSalary.keySet()) {
            System.out.println("Key : " + key + " , " + "Value : " + employeeSalary.get(key));
        }
    }

}






