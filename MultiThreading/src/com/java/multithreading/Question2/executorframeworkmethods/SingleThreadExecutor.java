package com.java.multithreading.Question2.executorframeworkmethods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***SingleThreadExecutor creates an executor which executes a single task at a time ***/
class SingleThreadExecutorDemo {
    public static void execute() {
        Runnable r1 = new Work("Task 1");
        Runnable r2 = new Work("Task 2");
        Runnable r3 = new Work("Task 3");

        /*** A single thread pool can be obtained by calling newSingleThreadExecutor() method **/
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
    }
}

public class SingleThreadExecutor {
    public static void main(String[] args) {
        SingleThreadExecutorDemo.execute();
    }
}
