package com.customer;

import enums.AccountType;

public class Customer {
    private String customerName;
    private int age;
    private long aadharNo;
    private long accountNumber;
    private AccountType accountType;
    private int intialBalance = 2000;

    public Customer(String customerName, int age, long aadharNo,AccountType accountType) {
        super();
        this.customerName = customerName;
        this.age = age;
        this.aadharNo = aadharNo;
        this.accountType =  accountType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(long aadharNo) {
        this.aadharNo = aadharNo;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = AccountType.valueOf(accountType);
    }

    public int getIntialBalance() {
        return intialBalance;
    }

    public void setIntialBalance(int intialBalance) {
        this.intialBalance = intialBalance;
    }

    @Override
    public String toString() {
        return "Customer [customerName=" + customerName + ", age=" + age + ", aadharNo=" + aadharNo + ", accountNumber="
                + accountNumber + "]";
    }

}
