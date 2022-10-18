package com.java.multithreading.Question5;

/*
         Question 5) Write a program to simulate a deadlock in java
         and then improve the program to handle the deadlock using reentrant lock.

         Explanation : Here I am creating a situation, which will result into a deadlock and will stop the
         execution of the program
         Here, I have made two operations operation1 and operation2 and two threads Thread1 and Thread2.
         Thread1 is using operation1 and Thread2 is using Operation2.
         Thread1 will have a lock on lock1 and Thread2 will have a lock on lock2, so now Thread1 needs a lock
         on lock2 and Thread2 needs a lock on lock1, so both will be waiting for each other, resulting in deadlock.
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadLock deadlock = new DeadLock();
        new Thread(deadlock::operation1, "T1").start();
        new Thread(deadlock::operation2, "T2").start();
    }

    public void operation1() {
        lock1.lock();
        System.out.println("lock1 acquired, waiting to acquire lock2.");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        System.out.println("lock2 acquired");

        System.out.println("executing first operation.");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        lock2.lock();
        System.out.println("lock2 acquired, waiting to acquire lock1.");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock1.lock();
        System.out.println("lock1 acquired");

        System.out.println("executing second operation.");

        lock1.unlock();
        lock2.unlock();
    }
}

