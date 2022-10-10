package com.java.collection.thirdQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpecialStackTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the Initial Capacity of the Stack...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SpecialStack specialStack = new SpecialStack(n);
        String str;
        boolean condition = true;

        while (condition) {
            System.out.println("\nChoose the Below Operation...");

            System.out.println("\t1: Push an Element to the Special Stack...");
            System.out.println("\t2: Pop an Element from the Special Stack...");
            System.out.println("\t3: Check Stack is Full or Not...");
            System.out.println("\t4: Check Stack is Empty or Not...");
            System.out.println("\t5: Display Special Stack...");
            System.out.println("\t6: Check Size of the Stack...");
            System.out.println("\t7: Find the Top Element from the Stack...");
            System.out.println("\t8: Find the Minimum Element from the Stack...");
            System.out.println("\t9: For Termination...");

            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter element to be push");
                    int val = Integer.parseInt(br.readLine());
                    specialStack.push(val);
                    break;
                case 2:
                    int poppedValue = specialStack.pop();
                    if (poppedValue != -1) {
                        System.out.println(poppedValue);
                    }
                    break;
                case 3:
                    System.out.println(specialStack.isFull());
                    break;
                case 4:
                    System.out.println(specialStack.isEmpty());
                    break;
                case 5:
                    specialStack.display();
                    break;
                case 6:
                    System.out.println(specialStack.size());
                    break;
                case 7:
                    int topOfStackValue = specialStack.top();
                    if (topOfStackValue != -1) {
                        System.out.println(topOfStackValue);
                    }
                    break;
                case 8:
                    System.out.println("The Minimum Element of the stack is "+specialStack.getMinElement());
                    break;
                case 9:
                    condition = false;
                    break;
                default:
                    System.out.println("Enter a Valid Input");
                    break;
            }
        }
    }
}
