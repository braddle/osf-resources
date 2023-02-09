# TDD Leap Year Calculator

## Goal 

This exercise involves building a Leap Year Calculator function using Test-Driven Development to evolve your design 
iteratively. TDD gives you continuous feedback on the quality of your design whilst building confidence in your code.

## Approach

When doing this exercise, try to implement the function using tests to convince yourself that the code you have written 
is correct.

Implement 1 test at a time, and then write the code needed to pass the test, as per the red-green-refactor cycle.

## Setup
- Ensure you have **openjdk 16+** installed
- Open a terminal and navigate into the **001-TDD** directory: `cd 001-TDD`
- Run `./mvnw clean install` to install the dependencies
- Open the PasswordValidatorTest class and start implementing the tests!
- Once you have written a test you can run the test class or specific unit test by pressing either of the green buttons shown on the left below.  
  ![Running tests](resources/runTests.png)
- Or run all tests with `./mvnw test`

## Functional requirements

You need to build a Leap Year Calculator function meeting the following requirements:

1. All years divisible by 400 ARE leap years
2. All years divisible by 100 but NOT by 400 ARE NOT leap years
3. All years divisible by 4 but Not by 100 ARE leap years 
4 .All years not divisible by 4 ARE NOT leap years

### Tip
Remember the <span style="color:red">red</span> <span style="color:green">green</span> <span style="color:cyan">refactor</span> cycle.  
1. Write a failing test
2. Implement the simplest code to make it pass
3. Refactor code as needed
4. Test again
5. Repeat

## Further help
If you are not sure how to do implement a test in JUnit or not sure which annotation to use, JUnit has a great user guide linked [here](https://junit.org/junit5/docs/current/user-guide/#writing-tests), or feel free to ask me 🙂