package com.java9_java17_features.Question1;

public interface UseOfPrivateMethod {

    private static int arraySum(int[] array) {
        int sum = 0;
        for (int val : array) {
            sum += val;
        }
        return sum;
    }

    default double findAverage(int[] array) {
        return (arraySum(array) / (double) array.length);
    }
}
