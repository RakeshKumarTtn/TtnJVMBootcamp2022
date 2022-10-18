package com.java.multithreading.Question2.executorframeworkmethods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*** CachedThreadPool is used when tasks submitted for processing should not wait and needs to be
 * addressed as soon as submitted.
 */
class CachedThreadPoolDemo {
    public static void execute() {

        Runnable r1 = new Work("Task 1");
        Runnable r2 = new Work("Task 2");
        Runnable r3 = new Work("Task 3");

        /*** A Cached thread pool can be obtained by calling newCachedThreadPool() method **/
        ExecutorService executor = Executors.newCachedThreadPool();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
        System.out.println("No. of threads scheduled : " + pool.getTaskCount());
        executor.shutdown();

    }
}

public class CachedThreadPool {
    public static void main(String[] args) {
        CachedThreadPoolDemo.execute();
    }
}
