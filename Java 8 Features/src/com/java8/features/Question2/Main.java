package com.java8.features.Question2;

public class Main {
    public static void main(String[] args) {
        MathOperation mathOperation = new MathematicalOperation()::addition;
        System.out.println(mathOperation.performMathOperation(1, 2));

        mathOperation = new MathematicalOperation()::substract;
        System.out.println(mathOperation.performMathOperation(10, 2));

        mathOperation = MathematicalOperation::multiply;
        System.out.println(mathOperation.performMathOperation(10, 2));
    }
}
