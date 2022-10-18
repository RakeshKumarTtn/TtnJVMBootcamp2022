package com.java.multithreading.Question5;

/*
  Question 5) Write a program to simulate a deadlock in java
  and then improve the program to handle the deadlock using reentract lock.
  Explanation : Here I am solving the deadlock, by using a while loop. In operation1, first i am
  acquiring a lock on lock1 AND then it goes for lock2, if it is successful then it breaks the while loop,
  if it is not then it will BE in the loop until both locks are acquired by Thread1.
  Same goes for Thread2 and operation2. By this, it will not stuck in the loop
*/

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockSolution {

    private ReentrantLock lock1 = new ReentrantLock(true);
    private ReentrantLock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadLockSolution deadlock = new DeadLockSolution();
        new Thread(deadlock::operation1, "Thread1").start();
        new Thread(deadlock::operation2, "Thread2").start();
    }

    public void operation1() {
        while (true) {
            try {
                System.out.println("Acquiring lock1 by Thread1");
                if (lock1.tryLock()) {
                    System.out.println("Acquired lock1 by Thread1");
                    System.out.println("Acquiring lock2 by Thread1");
                    if (lock2.tryLock()) {
                        System.out.println("Acquired lock2 by Thread1");
                        break;
                    }
                }
            } finally {
                if (lock2.isHeldByCurrentThread()) lock2.unlock();
                if (lock1.isHeldByCurrentThread()) lock1.unlock();
            }
        }
    }

    public void operation2() {
        while (true) {
            try {
                System.out.println("Acquiring lock2 by Thread2");
                if (lock2.tryLock()) {
                    System.out.println("Acquired lock2 by Thread2");
                    System.out.println("Acquiring lock1 by Thread2");
                    if (lock1.tryLock()) {
                        System.out.println("Acquired lock1 by Thread2");
                        break;
                    }
                }
            } finally {

                if (lock1.isHeldByCurrentThread()) lock2.unlock();
                if (lock2.isHeldByCurrentThread()) lock1.unlock();
            }
        }
    }
}
