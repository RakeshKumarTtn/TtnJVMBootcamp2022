package com.java9_java17_features.Question1;

public class Main implements UseOfPrivateMethod {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        UseOfPrivateMethod useOfPrivateMethod = new Main();
        double arrayAverage = useOfPrivateMethod.findAverage(array);
        System.out.println(arrayAverage);
    }
}
