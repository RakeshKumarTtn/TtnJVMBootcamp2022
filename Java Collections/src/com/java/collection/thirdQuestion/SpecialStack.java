package com.java.collection.thirdQuestion;

import java.util.Arrays;

public class SpecialStack {

    private int[] data;
    private int[] minData;
    private int topOfStack;
    private int count = 0;

    public SpecialStack(int capacity) {
        this.data = new int[capacity];
        this.minData = new int[capacity];
        this.topOfStack = -1;
    }

    public int size() {
        return this.topOfStack + 1;
    }

    public void display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = topOfStack; i >= 0; i--) {
            stringBuilder.append(data[i] + " ");
        }
        String finalOutput = stringBuilder.toString().trim().concat("]");
        System.out.println(finalOutput);
    }

    public void push(int val) {
        if (topOfStack == data.length - 1) {
            System.out.println("Stack Overflow");
        } else {
            topOfStack++;
            data[topOfStack] = val;
            if (topOfStack < 1) {
                minData[topOfStack] = val;
            } else {
                if (val < minData[count]) {
                    count++;
                    minData[count] = val;
                }
            }
        }
    }

    public int pop() {
        if (topOfStack == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int val = data[topOfStack];
            topOfStack--;
            return val;
        }
    }

    public int top() {
        if (topOfStack == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return data[topOfStack];
        }
    }

    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (topOfStack == data.length - 1) {
            return true;
        }
        return false;
    }

    public int getMinElement() {
        return minData[count];
    }
}
