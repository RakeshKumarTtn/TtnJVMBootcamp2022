package com.java.multithreading.Question1;

/*
Create and Run a Thread using Thread class and show usage of sleep and join methods in the created thread:

1). using sleep() method we can put a particular thread in the sleep mode means thread is running in the system
    but not performing the given task
2). using join method we tell the compiler that one thread is running after that another thread will execute, join
    method is like archive sequential execution between the threads
    sleep(1000) means sleep the thread for 1000 MILLISECONDS.
3). join() method in Java is provided by the java.lang.Thread class that
    permits one thread to wait until the other thread to finish its execution.
*/
public class ThreadUsingThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println("Run Method Called...");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadUsingThreadClass thread1 = new ThreadUsingThreadClass();
        ThreadUsingThreadClass thread2 = new ThreadUsingThreadClass();
        thread1.start();
        thread1.sleep(1000);
        System.out.println("Thread1 Executed...");
        thread1.join();
        thread2.start();
        System.out.println("Thread2 Executed...");
    }
}
