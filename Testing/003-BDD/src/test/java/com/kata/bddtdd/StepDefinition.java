package com.kata.bddtdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinition {

    private BankAccount account;
    private Exception lastExecption;

    @Given("{string} has an account with {int} pounds")
    public void has_an_account_with_pounds(String name, Integer openingBalance) throws Exception {
        account = new BankAccount(name, openingBalance);
    }

    @When("{string} opens a bank account with {int} pounds")
    public void opens_a_bank_account_with_pounds(String name, Integer openingBalance) {
        try {
            account = new BankAccount(name, openingBalance);
        } catch (Exception e) {
            lastExecption = e;
        }
    }

    @When("they deposit {int} pounds into the account")
    public void they_deposit_pounds_into_the_account(Integer money) {
        account.deposit(money);
    }

    @When("they withdraw {int} pounds from the account")
    public void they_withdraw_pounds_from_the_account(Integer money) {
        try {
            account.withdraw(money);
        } catch (Exception e) {
            lastExecption = e;
        }
    }

    @Then("{string} account is created")
    public void account_is_created(String expectedNamed) {
        assertEquals(expectedNamed, account.getHolderName());
    }

    @Then("the balance is {int} pounds")
    public void the_balance_is_pounds(int int1) {
        assertEquals(int1, account.getBalance());
    }

    @Then("the account is not opened")
    public void the_account_is_not_opened() {
        assertNotNull(lastExecption);
    }

    @Then("the account statement should be:")
    public void the_account_statement_should_be(String expectedStatment) {
        assertEquals(expectedStatment, account.getStatement());
    }

    @Then("the money cannot be withdrawn")
    public void theMoneyCannotBeWithdrawn() {
        assertNotNull(lastExecption);
    }
}
