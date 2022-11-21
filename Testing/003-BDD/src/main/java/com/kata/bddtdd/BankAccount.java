package com.kata.bddtdd;

public class BankAccount {


    private String accountHolder;
    private int balance;
    private int transactionCount = 0;
    private String[] transactions = new String[10];

    public BankAccount(String accountHolder, int openingBalance) throws Exception {
        if (openingBalance < 100) {
            throw new Exception("Opening balance must be atleast £100");
        }

        this.accountHolder = accountHolder;
        deposit(openingBalance);
    }

    public String getHolderName() {
        return accountHolder;
    }

    public int getBalance() {
        return balance;
    }

    public String getStatement() {
        String statement = accountHolder + ":\n\nTransaction|Amount|Balance\n";

        for (int i = 0; i < transactionCount; i++) {
            statement += transactions[i];
            if (i < (transactionCount - 1)) {
                statement += "\n";
            }
        }

        return statement;
    }

    public void deposit(Integer depositAmount) {
        balance += depositAmount;

        transactions[transactionCount] = "000" + Integer.toString(transactionCount+1) + "|+" + Integer.toString(depositAmount) +"|" + Integer.toString(balance);
        transactionCount++;
    }

    public void withdraw(Integer withdrawAmount) throws Exception {
        if (withdrawAmount > balance) {
            throw new Exception("Not enough money to withdraw");
        }

        balance -= withdrawAmount;

        transactions[transactionCount] = "000" + Integer.toString(transactionCount+1) + "|-" + Integer.toString(withdrawAmount) +"|" + Integer.toString(balance);
        transactionCount++;
    }
}
