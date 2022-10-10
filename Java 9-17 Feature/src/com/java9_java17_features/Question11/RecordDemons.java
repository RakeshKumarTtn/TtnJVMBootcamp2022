package com.java9_java17_features.Question11;


import java.util.Objects;

/*
use record to create an immutable represent of student(name, id, age) and use its  constructor for
initialization,equals to compare 2 students methods. Also keep a static counter to keep the count of objects created.
*/
record Student(String name, Integer id, Integer age) {
    static int counter = 0;

    static void incrementCounter() {
        counter++;
    }

    Student {
        Objects.requireNonNull(name);
        incrementCounter();
    }
}

public class RecordDemons {
    public static void main(String[] args) {
        Student student1 = new Student("Peter", 1, 24);
        Student student2 = new Student("Peter", 2, 24);
        System.out.println(student1);
        System.out.println(student1.age());
        System.out.println(student1.id());
        System.out.println(student1.name());
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student1.equals(student2));
        System.out.println(Student.counter);
    }
}
