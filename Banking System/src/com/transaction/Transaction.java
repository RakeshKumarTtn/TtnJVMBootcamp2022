package com.transaction;

import java.util.Scanner;

import com.bank.Bank;
import com.customer.Customer;
import com.exception.InsufficientAmountException;

public class Transaction {

    static Scanner sc = new Scanner(System.in);
    private static String status = "SUCCESS";
    public static StringBuilder message = new StringBuilder();
    private static long amount;
    private static int intialAccountBalance;

    public static void deposit(Object customer) {

        if (customer instanceof Customer) {
            long amount;
            int intialAccountBalance = ((Customer) customer).getIntialBalance();
            System.out.println("Enter the amount you want to deposit: ");
            amount = sc.nextLong();
            intialAccountBalance = (int) (intialAccountBalance + amount);
            ((Customer) customer).setIntialBalance(intialAccountBalance);
        }
    }

    public static void withdrawn(Object customer) throws InsufficientAmountException {

        if (customer instanceof Customer) {
            intialAccountBalance = ((Customer) customer).getIntialBalance();
            System.out.println("Enter the amount you want to withdraw: ");
            amount = sc.nextLong();
            Bank.showAccount(customer);
            if (intialAccountBalance >= amount) {
                System.out.println("Status of Transaction : " + status);
                System.out.println("Withdrawn Amount : " + amount);
                System.out.println("Balance before Withdrawn : " + intialAccountBalance);
                intialAccountBalance = (int) (intialAccountBalance - amount);
                System.out.println("Balance after Withdrawn : " + intialAccountBalance);
                System.out.println("Date and Time of Transaction : " + new java.util.Date());
            } else {
                status = "FAILURE DUE TO Insufficient Amount";
                System.out.println("Status of Transaction : " + status);
                throw new InsufficientAmountException(
                        "Your balance is less than " + amount + "\tTransaction failed...!!");
            }
        }
    }

    public static StringBuilder transactionHistory(Object customer) {
        if (customer instanceof Customer) {
            message.append("\nAfter Transaction Account Details...")
                    .append("\n\tStatus of Transaction : " + status)
                    .append("\n\tAmount to be Withdrawn : " + amount)
                    .append("\n\tAmount Before Deduction : " + ((Customer) customer).getIntialBalance())
                    .append("\n\tAmount After Deduction : " + intialAccountBalance)
                    .append("\n\tDate and Time of Transaction : " + new java.util.Date())
                    .append("\n\t----------------------------------------------------------");
        }
        return message;
    }
}
