package com.java8.features.Question3;

import java.util.stream.IntStream;

public class CreateThreadUsingLambda {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

            int[] array = IntStream.rangeClosed(1, 20).toArray();
            // Implementation of run() method to print only prime numbers
            for (int i = 0; i <= array.length; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even Number Thread : " + i + " Thread ID: " + Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        System.out.println(thread);
    }
}





