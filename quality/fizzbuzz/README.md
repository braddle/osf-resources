# Open/Close Principle FizzBuzz

## Goal

To practise implementing some code that conforms to the Open-Closed Principle (Software entities should be open for 
extension, but closed for modification) of the SOLID principles.

For this lab we are going to implement the functionality of the FizzBuzz kata

## Approach

When completing this kata make use of Test Driven Development and implement the requirements of each stage in a new Rule
implementation.

Throughout this kata you should never need to edit any classes that already exist you should only need to create a new 
implement of rule that meets the next requirement/test.

## Functional requirements

  - [X] Non-positive numbers should not be converted and return an empty string `""`
  - [X] Positive numbers should be returned as a String
  - [ ] Numbers that are divisible by 3 should return "Fizz"
  - [ ] Numbers that are divisible by 5 should return "Buzz"
  - [ ] Numbers that are divisible by 3 & 5 should return "FizzBuzz"

We have started the kata and adding test for cover negative numbers not being allowed and returning
String the number given as a String.

## Running Test

To run the tests on this project you can use the Maven Wrapper

### Linux/Mac

- Install Dependencies `./mvnw.cmd clean install`
- Run Tests `./mvnw.cmd test`

### Windows

- Install Dependencies `./mvnw.cmd clean install`
- Run Tests `./mvnw.cmd test`