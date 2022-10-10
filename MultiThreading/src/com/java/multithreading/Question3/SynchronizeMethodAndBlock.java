package com.java.multithreading.Question3;

/*
 Question 3) : Use Synchronize method and synchronize block to enable synchronization
 between multiple threads trying to access method at same time.

 Explanation : Synchronization in Java allows to control the access of multiple threads over
 shared resources. Synchronized method is used to lock an object for any shared resource.
 When a thread invokes a SYNCHRONIZED method, it invokes a lock on that method and release it
 when its work is completed.
 */
class PrintTable {
    //Here I have made a printTable a synchronized method by using synchronized keyword
    synchronized void printTableSynchronizeMethod(int number) {
        System.out.println("Table of " + number + "+ :");
        for (int counter = 1; counter <= 10; counter++) {
            System.out.println(counter * number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Here i have made a synchronized block
    void printTableSynchronizedBlock(int number) {
        synchronized (this) {
            System.out.println("Table of " + number + " :");
            for (int counter = 1; counter <= 10; counter++) {
                System.out.println(number * counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

// Made a thread class here by the name of myThread1
class MyThread extends Thread {
    PrintTable T;

    MyThread(PrintTable T) {
        this.T = T;
    }

    public void run() {
        T.printTableSynchronizedBlock(8);
        T.printTableSynchronizeMethod(9);
    }
}

/*** Made a thread class here by the name of myThread2 **/
class MyThread2 extends Thread {
    PrintTable T;

    MyThread2(PrintTable T) {
        this.T = T;
    }

    public void run() {
        T.printTableSynchronizedBlock(12);
        T.printTableSynchronizeMethod(15);
    }
}

public class SynchronizeMethodAndBlock {
    public static void main(String[] args) {
        PrintTable obj = new PrintTable();
        MyThread T1 = new MyThread(obj);
        MyThread2 T2 = new MyThread2(obj);
        T1.start();
        T2.start();
    }
}