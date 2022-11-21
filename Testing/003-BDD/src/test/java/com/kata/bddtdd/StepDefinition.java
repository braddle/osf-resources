package com.kata.bddtdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {

    private BankAccount account;
    @When("{string} opens a bank account with {int} pounds")
    public void opens_a_bank_account_with_pounds(String name, Integer openingBalance) {
        account = new BankAccount(name, openingBalance);
    }

    @Then("{string} account is created")
    public void account_is_created(String expectedNamed) {
        assertEquals(expectedNamed, account.getHolderName());
    }

    @Then("the balance is {int} pounds")
    public void the_balance_is_pounds(int int1) {
        assertEquals(int1, account.getBalance());
    }
}
