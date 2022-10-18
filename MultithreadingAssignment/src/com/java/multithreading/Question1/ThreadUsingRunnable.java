package com.java.multithreading.Question1;

public class ThreadUsingRunnable {
    public static void main(String[] args) throws InterruptedException {

        //Created a thread by implementing Runnable interface
        CreateThreadByRunnable createThreadByRunnable = new CreateThreadByRunnable();
        Thread thread = new Thread(createThreadByRunnable);

        Thread thread1 = new Thread(createThreadByRunnable);
        thread.setName("Thread-1");
        thread.start();
        Thread.sleep(1000L);
        thread.join();
        thread1.start();
        System.out.println(thread.getName());
    }
}

/*
 Here I have created a class by implementing Runnable interface
*/
class CreateThreadByRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable Thread is Starting");
    }
}
