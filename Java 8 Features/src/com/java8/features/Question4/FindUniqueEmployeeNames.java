package com.java8.features.Question4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindUniqueEmployeeNames {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee("Rajendra Pratap Singh", 7000, "Punjab");
        Employee employee2 = new Employee("Sonali Kumari Singh", 3000, "Punjab");
        Employee employee3 = new Employee("Raju Singh Kohli", 3500, "Delhi");
        Employee employee4 = new Employee("Rakesh Kumar", 4500, "Delhi");
        Employee employee5 = new Employee("Raju Kumar Singh", 2200, "Delhi");
        Collections.addAll(list, employee1, employee2, employee3, employee4, employee5);

        list.stream()
                .filter(e -> e.getSalary() < 5000)
                .filter(e -> e.getCity()
                .equalsIgnoreCase("DELHI"))
                .map(Employee::getFullName)
                .map(Employee.FullName::getFirstName)
                .distinct()
                .forEach(System.out::println);
    }
}
