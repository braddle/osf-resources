# TDD Password Validator

## Goal 
We are going to use TDD to implement a password validator. The user stories given below must be implemented in a TDD methodology.

## Setup
- Ensure you have **openjdk 16+** installed
- Open a terminal and navigate into the **001-TDD** directory: `cd 001-TDD`
- Run `./mvnw clean install` to install the dependencies
- Open the PasswordValidatorTest class and start implementing the tests!
- Once you have written a test you can run the test class or specific unit test by pressing either of the green buttons shown on the left below.  
  ![Running tests](resources/runTests.png)
- Or run all tests with `./mvnw test`

## Activity

### Sprint 1
The accounts team have requested that we enforce a password policy for new users and sent through the following user story.  

> #### TDD-FEAT-492
> As an account's admin team member, I want new users to have a strong password, so that account security is enforced.  
> #### Acceptance Criteria
>- [ ] Password contains more than 8 characters
>- [ ] Password contains ≥ 1 uppercase letter
>- [ ] Password contains ≥ 1 number
>- [ ] Password contains ≥ 1 special character

### Sprint 2
Since successfully delivering the feature in the first sprint, the accounts team have received a number of complaints about the new password policy being confusing and customers are not sure why their passwrods are not acceptable. We have a new set of requirements to show a list of reasons why the password does not meet the criteria.

> #### TDD-FEAT-517
> As an account's admin team member, I want new users to know why their password is not strong enough, so that they can easily implement a password satisfying the rules.
> #### Acceptance Criteria
>- [ ] `isValid()` is deprecated
>- [ ] New method `validate()` returns a `ValidatedPassword` object
>- [ ] `ValidatedPassword` object has attributes: `boolean isValid` and `List<String> reasons`

### Tip
Remember the <span style="color:red">red</span> <span style="color:green">green</span> <span style="color:cyan">refactor</span> cycle.  
1. Write a failing test
2. Implement the simplest code to make it pass
3. Refactor code as needed
4. Test again
5. Repeat


## Further help
If you are not sure how to do implement a test in JUnit or not sure which annotation to use, JUnit has a great user guide linked [here](https://junit.org/junit5/docs/current/user-guide/#writing-tests), or feel free to ask me 🙂