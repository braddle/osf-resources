# BDD

## Application

We are going to create a simple bank account application

## Setup

- Ensure you have **openjdk 16+** installed
- Open a terminal and navigate into the **003-BDD** directory: `cd 003-BDD`
- Run `./mvnw clean install` to install the dependencies
- Run the application `./mvnw spring-boot:run`
- Ensure you can visit the application in the browser `http://localhost:8080/search/a`
- You should see two results with first names that begin with 'a'.

## How do the tests work?

### CucumberIntegration set up

We have created a [BankCucumberTest.java](src/test/java/com/kata/bddtdd/BankCucumberTest.java) class in the test 
directory. This enables us to run our Cucumber tests with JUnit. We can see the annotation @CucumberOptions where we're specifying 
the location of the Gherkin file which is also known as the feature file. At this point, Cucumber recognises the Gherkin 
language

### Add features and Spring-Cucumber Integration
We have created a [bank_acount.feature](src/test/resources/bank_account.feature) file in the resource subdirectory 
inside the test directory as `src/test/resources`.

We now need to link the scenario steps to actual code. We created another class called 
[StepDefinition.java](src/test/java/com/kata/bddtdd/StepDefinition.java) and added the below step definitions which are 
code implementation of the feature that we have added.
Our BDD test requirement is to call an GET API to retrieve student details with a given name prefix and assert that.

### Testing the application
From your terminal execute below command to run the tests.

```bash
./mvnw test
```

Expected output:
```bash
Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```

## Requirements

You need to implement the functionality of the [BankAccount.java](src/main/java/com/kata/bddtdd/BankAccount.java) class
that will enable customers to 

  - A customer must deposit at least £100 to open an account
  - A customer should be able to check their current balance
  - The customer should be able to get a statement printout. It will show all transactions in the following format
```text
Transation|Amount|Balance
0001|+500|500
0002|-100|400
```
  - A customer should not be able to withdraw more money than is available

### Bonus Points
  - A customer can open an account with an over draft upto £300
  - Any overdraft should be added to the balance when displayed
  - A customer can reduce their overdraft if the amount to be reduced by is not being used.
    - i.e. if the customer has an overdraft of £200 and is using £100 of it they can only reduce it to £100

