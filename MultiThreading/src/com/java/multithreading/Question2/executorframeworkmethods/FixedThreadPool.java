package com.java.multithreading.Question2.executorframeworkmethods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*** FixedThreadPool is used when you need to execute n number of tasks at a single time ***/
class FixedThreadPoolDemo {
    public static void execute() {
        Runnable r1 = new Work("Task 1");
        Runnable r2 = new Work("Task 2");
        Runnable r3 = new Work("Task 3");

        /*** A Fixed thread pool can be obtained by calling newFixedThreadPool() method **/
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(r1);
        pool.submit(r2);
        pool.submit(r3);

        /**When shutdown method is called, it stops accepting new tasks, waits for previous tasks to
         * complete and then terminates the executor **/
        pool.shutdown();
    }
}

public class FixedThreadPool {
    public static void main(String[] args) {
        FixedThreadPoolDemo.execute();
    }
}

