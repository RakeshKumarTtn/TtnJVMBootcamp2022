package com.java9_java17_features.Question5;

import java.util.stream.IntStream;

/*
Use ifPresentOrElse Operation with Optional:
ifPresentOrElse is the method in the stream which is Check if some result from the resultSet come or not
if the result of the resultSet come then it will print the result otherwise it will perform another operation
ifPresentOrElse method takes 2 argument
first argument is the Consumer and the second argument is the runnable
*/
public class PresentOrElse {
    public static void main(String[] args) {
        IntStream
                .rangeClosed(14, 16)
                .filter(PresentOrElse::isPrime)
                .findFirst().ifPresentOrElse(
                        (e) -> System.out.println(e),
                        () -> System.out.println(-1)
                );
    }

    public static boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
