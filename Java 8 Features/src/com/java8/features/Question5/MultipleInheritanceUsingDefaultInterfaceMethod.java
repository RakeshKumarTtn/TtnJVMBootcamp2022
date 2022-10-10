package com.java8.features.Question5;

public class MultipleInheritanceUsingDefaultInterfaceMethod implements ThirdInterface {

    @Override
    public void display() {
        ThirdInterface.super.display();
        System.out.println("Default Method of Main Class");
    }

    public static void main(String[] args) {
        new MultipleInheritanceUsingDefaultInterfaceMethod().display();
    }
}
