package com.java.multithreading.Question4;
/*
    Question 4) WAP to show usage of Callable and demonstrate how it is different from Runnable
                Explanation : A thread can be created using Runnable interface, but one thing which lacks in Runnable is
                that thread doesn't return result when run() method completes. For this feature, callable is present in java.
                Whenever you want runnable interface run method return something then you should use callable
 */

import java.util.concurrent.*;

public class DemonstrateCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future result20 = executorService.submit(new FactorialCalculation(20));
        Future result15 = executorService.submit(new FactorialCalculation(15));
        Future result25 = executorService.submit(new FactorialCalculation(25));

        //It will output false here, that means Future objects don't have any values yet
        System.out.println("Factor of 25 is calculated : " + result25.isDone());
        System.out.println("Factor of 15 is calculated : " + result15.isDone());
        System.out.println("Factor of 20 is calculated : " + result20.isDone() + "\n");

        System.out.println("factorial of 20 is " + result20.get());

        //It will also return false, that means factor of 25 is still not calculated.
        System.out.println("Factor of 25 is calculated : " + result25.isDone());
        System.out.println("factorial of 15 is " + result15.get());
        System.out.println("factorial of 25 is " + result25.get() + "\n");

        // It will return true here, that means factor of all numbers is calculated
        System.out.println("Factor of 25 is calculated : " + result25.isDone());
        System.out.println("Factor of 15 is calculated : " + result15.isDone());
        System.out.println("Factor of 20 is calculated : " + result20.isDone() + "\n");
        executorService.shutdown();
    }
}

//Here i have created a class by implementing Callable interface
class FactorialCalculation implements Callable {
    private int number;

    public FactorialCalculation(int num) {
        this.number = num;
    }

    /*
          When this call() method completes, it returns an answer that needs to be stored, so it is
          stored in the Future object. It is an object that holds the result, it may not hold it right now,
          but it will hold in the future, once the callable() returns.
    */
    public Long call() throws Exception {
        return factorial(this.number);
    }

    private long factorial(int n) throws InterruptedException {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
            Thread.sleep(100);
        }
        return result;
    }
}
