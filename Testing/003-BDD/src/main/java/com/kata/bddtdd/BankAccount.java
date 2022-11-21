package com.kata.bddtdd;

public class BankAccount {


    private String accountHolder;
    private int balance;

    public BankAccount(String accountHolder, int openingBalance) {
        this.accountHolder = accountHolder;
        this.balance = openingBalance;
    }

    public String getHolderName() {
        return accountHolder;
    }

    public int getBalance() {
        return balance;
    }
}
