package MainClass;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.Bank;
import com.customer.Customer;
import com.exception.InsufficientAmountException;
import com.transaction.Transaction;
import enums.AccountType;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class RunnerClass {
    static List<Customer> customers = new ArrayList<>();

    public static void bankRunner() throws IOException {
        customers.add(new Customer("Rakesh", 25, 157753256789L, AccountType.CURRENT));
        customers.add(new Customer("Mukesh", 48, 157753254578L,AccountType.SAVINGS));
        customers.add(new Customer("Sapna Singh", 28, 157798206789L,AccountType.CURRENT));
        customers.add(new Customer("Parul Gupta", 29, 157980254578L,AccountType.SAVINGS));
        customers.add(new Customer("Vikash Mahajan", 65, 157000056789L,AccountType.SAVINGS));
        customers.add(new Customer("Manish Kumar", 22, 100753254578L,AccountType.CURRENT));

        for (Customer customer : customers) {
            Bank.openAccount(customer);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("We Have " + customers.size() + " Account. Are you Want to Create More Account ? Y|N");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Enter the Account Holder Name...");
            String name = scanner.nextLine();
            System.out.println("Enter the Account Holder Age...");
            int age = scanner.nextInt();
            System.out.println("Enter the Account Holder Aadhar Card Number...");
            long aadharNumber = scanner.nextLong();
            scanner.nextLine();
            System.out.println("Enter the Account Type...");
            String accountType = scanner.nextLine();
            Customer customer;
            if(accountType.equalsIgnoreCase(AccountType.SAVINGS.toString()) || accountType.equalsIgnoreCase(AccountType.CURRENT.toString())){
                customer = new Customer(name, age, aadharNumber,AccountType.valueOf(accountType));
            }else{
                customer = new Customer(name, age, aadharNumber,AccountType.SAVINGS);
            }
            customers.add(customer);
            Bank.openAccount(customer);
        }

        int choice;
        do {
            System.out.println("\nBanking System Application");
            System.out.println(
                    "\t 1. Display all account details \n\t 2. Deposit the amount \n\t 3. Withdraw the amount \n\t 4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Customer customer : customers) {
                        Bank.showAccount(customer);
                    }
                    break;
                case 2:
                    System.out.println("Enter the Account Number and Account Holder Name to Deposit");
                    long accountNumber = scanner.nextLong();
                    scanner.nextLine();
                    String accountHolderName = scanner.nextLine();
                    for (Customer customer : customers) {
                        if (customer.getAccountNumber() == accountNumber && customer.getCustomerName().equalsIgnoreCase(accountHolderName)) {
                            File file = new File("/home/rakesh/Desktop/"+customer.getCustomerName()+".txt");
                            file.createNewFile();

                            Path fileName;
                            fileName = Paths.get("/home/rakesh/Desktop/"+customer.getCustomerName()+".txt");
                            Files.write(fileName,"".getBytes());
                            Files.write(fileName, Bank.transactionHistory(customer).toString().getBytes(),StandardOpenOption.APPEND);
                            Transaction.deposit(customer);
                            Files.write(fileName, Transaction.transactionHistory(customer).toString().getBytes(),StandardOpenOption.APPEND);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the Account Number and Account Holder Name for Withdrawn");
                    accountNumber = scanner.nextLong();
                    scanner.nextLine();
                    accountHolderName = scanner.nextLine();
                    for (Customer customer : customers) {
                        if (customer.getAccountNumber() == accountNumber && customer.getCustomerName().equalsIgnoreCase(accountHolderName)) {
                            try {
                                File file = new File("/home/rakesh/Desktop/"+customer.getCustomerName()+".txt");
                                file.createNewFile();

                                Path fileName;
                                fileName = Paths.get("/home/rakesh/Desktop/"+customer.getCustomerName()+".txt");
                                Files.write(fileName,"".getBytes());
                                Files.write(fileName, Bank.transactionHistory(customer).toString().getBytes(),StandardOpenOption.APPEND);
                                Transaction.withdrawn(customer);
                                Files.write(fileName, Transaction.transactionHistory(customer).toString().getBytes(),StandardOpenOption.APPEND);
                            } catch (InsufficientAmountException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("See You Soon...");
                    break;
                default:
                    System.out.println("Enter Valid Input...");
            }
        } while (choice != 4);
    }
}
