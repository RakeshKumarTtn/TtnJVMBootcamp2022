package MainClass;

/*
Implement a banking system using java.

        Create 3 sub class of Bank : SBI,BOI,ICICI

        All 4 should have following methods:

        getDetails which provide their specific details like rateofinterest etc
        printDetails of every bank.
        Every bank account should have a type (enum): SAVINGS, CURRENT
        Implement a feature to deduct amount from account. Throw InsufficientAmountException if amount being deducted is less than the current balance.
        Every banking transaction should be saved in a file of each bank's transaction log which would have all details of the transaction like (time of transaction,account number,amount withdrawn, amount before deduction, amount after deduction,transaction status (can also be enum), failure reason if any)
*/

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RunnerClass.bankRunner();
    }
}


