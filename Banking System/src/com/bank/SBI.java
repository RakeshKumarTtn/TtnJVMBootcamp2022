package com.bank;

import enums.AccountType;

public class SBI extends Bank{
    private static double annualInterestRate = 6.5;
    private final static String startYear = "1 July 1955";

    public static void getDetails() {
        System.out.print("ACCOUNT TYPE -> ");
        for (AccountType accountTypeEnum : AccountType.values()) {
            System.out.print(accountTypeEnum + " ");
        }
        System.out.println("\nInterest -> " + annualInterestRate + " Per annual");
    }

    public static void printDetails() {
        System.out.println("Bank Name : " + new Object() {
        }.getClass().getEnclosingClass().getSimpleName());
        System.out.println("Account Type : " + AccountType.values()[0] + "," + AccountType.values()[1]);
        System.out.println("Rate of Interest : " + annualInterestRate);
        System.out.println("Founded in " + startYear);
    }

    @Override
    public double rateOfInterest() {
        return annualInterestRate;
    }
}
