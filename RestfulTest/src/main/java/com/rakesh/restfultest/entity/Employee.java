package com.rakesh.restfultest.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

    private int id;

    @Size(min = 2, message = "Name should have AtLeast 2 characters")
    @NotBlank
    private String name;

    @Min(value = 1, message = "Age must be greater than 1")
    @Max(value = 120, message = "Age must be less than 120s")
    private int age;

    public Employee() {
    }

    public Employee(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
