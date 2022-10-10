package com.java8.features.Question5;

public interface SecondInterface {
    default void display() {
        System.out.println("Default Method of MyInterface2");
    }
}
