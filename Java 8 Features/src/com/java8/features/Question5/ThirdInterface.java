package com.java8.features.Question5;

public interface ThirdInterface extends FirstInterface, SecondInterface {
    default void display() {
        FirstInterface.super.display();
        SecondInterface.super.display();
        System.out.println("Default Method of MyInterface3");
    }
}
