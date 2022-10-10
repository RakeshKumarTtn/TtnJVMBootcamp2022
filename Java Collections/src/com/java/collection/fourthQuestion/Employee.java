package com.java.collection.fourthQuestion;

import java.util.Objects;

public class Employee {
    private String name, designation;
    private int age;

    /* Make constructor for class employee */
    public Employee(String name, String designation, int age) {
        this.name = name;
        this.designation = designation;
        this.age = age;
    }

    /* Overriding the Equals method, so that hashmap doesn't include two different objects which have the same values */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && name.equals(employee.name) && designation.equals(employee.designation);
    }

    @Override
    public String toString() {
        return new StringBuilder("[").append("Name:" + name + " , ").append("Designation:" + designation + " , ").append("Age:" + age).append("]").toString();
    }

    /* Overriding hashCode here */
    @Override
    public int hashCode() {
        return Objects.hash(name, designation, age);
    }
}

