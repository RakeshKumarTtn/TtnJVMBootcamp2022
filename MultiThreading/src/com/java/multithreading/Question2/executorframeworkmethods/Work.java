package com.java.multithreading.Question2.executorframeworkmethods;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
  Question 2): Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool()
               to submit a list of tasks and wait for completion of all tasks.
*/

public class Work implements Runnable {
    private String name;

    public Work(String s) {
        name = s;
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
            if (i == 0) {
                System.out.println(name + " started at " + ft.format(d));
            }

            if (i == 5) {
                System.out.println(name + " completed at " + ft.format(d));
            }
        }
    }
}
