package com.bank;

import com.customer.Customer;
import enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public abstract class Bank {
    private static long accountNumber = 1000L;
    static List<Customer> list = new ArrayList<>();
    public static StringBuilder message = new StringBuilder();

    public abstract double rateOfInterest();
    public static void openAccount(Object customer) {
        if (customer instanceof Customer) {
            ((Customer) customer).setAccountNumber(accountNumber);
            accountNumber++;
            list.add((Customer) customer);
        }
    }

    public static void showAccount(Object customer) {
        if (customer instanceof Customer) {
            System.out.println("\nName of account Holder : " + ((Customer) customer).getCustomerName());
            System.out.println("Account Number : " + ((Customer) customer).getAccountNumber());
            System.out.println("Account type : " + ((Customer) customer).getAccountType());
            System.out.println("Balance : " + ((Customer) customer).getIntialBalance());
            System.out.println("Age of Account Holder : " + ((Customer) customer).getAge());
            System.out.println("----------------------------------------------------------");
        }
    }

    public static StringBuilder transactionHistory(Object customer) {
        if (customer instanceof Customer) {
            message.append("\nBefore Transaction Account Details...")
                    .append("\n\tName of account Holder : " + ((Customer) customer).getCustomerName())
                    .append("\n\tAccount Number : " + ((Customer) customer).getAccountNumber())
                    .append("\n\tAccount type : " + ((Customer) customer).getAccountType())
                    .append("\n\tBalance : " + ((Customer) customer).getIntialBalance())
                    .append("\n\tAge of Account Holder : " + ((Customer) customer).getAge())
                    .append("\n\t----------------------------------------------------------");
        }
        return message;
    }
}
