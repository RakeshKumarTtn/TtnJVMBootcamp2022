package com.springjpahibernate.springjpa.entities;

/*
    (1) Create an Employee Entity which contains following fields
        Name
        Id
        Age
        Location

    (2) Set up EmployeeRepository with Spring Data JPA
    (3) Perform Create Operation on Entity using Spring Data JPA
    (4) Perform Update Operation on Entity using Spring Data JPA
    (5) Perform Delete Operation on Entity using Spring Data JPA
    (6) Perform Read Operation on Entity using Spring Data JPA
    (7) Get the total count of the number of Employees
    (8) Implement Pagination and Sorting on the bases of Employee Age
    (9) Create and use finder to find Employee by Name
    (10) Create and use finder to find Employees starting with A character
    (11) Create and use finder to find Employees Between the age of 28 to 32
*/

import javax.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String location;

    public Employee() {

    }

    public Employee(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{\n\t " +
                "id=" + id +
                ",\n\t name='" + name + '\'' +
                ",\n\t age=" + age +
                ",\n\t location='" + location + '\'' +
                "\n}";
    }
}
