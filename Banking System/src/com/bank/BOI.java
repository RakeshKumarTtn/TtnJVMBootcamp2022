package com.bank;

import enums.AccountType;

public class BOI extends Bank{
    private static double annualInterestRate = 7.0;
    private final static String startYear = "7 Sept 1906";

    public static void getDetails() {
        System.out.print("ACCOUNT TYPE -> ");
        for (AccountType accountTypeEnum : AccountType.values()) {
            System.out.print(accountTypeEnum + " ");
        }
        System.out.print("\nInterest -> " + annualInterestRate + " Per annual");
    }


    public static void printDetails() {
        System.out.println("Bank Name : "+new Object(){}.getClass().getEnclosingClass().getSimpleName());
        System.out.println("Account Type : "+ AccountType.values()[0] +","+AccountType.values()[1]);
        System.out.println("Rate of Interest : "+annualInterestRate);
        System.out.println("Founded in "+startYear);
    }

    @Override
    public double rateOfInterest() {
        return annualInterestRate;
    }
}
