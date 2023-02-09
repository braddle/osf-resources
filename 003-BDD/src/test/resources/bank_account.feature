Feature: Bank account

  Requirements
  ------------
  This account only allow you to work in whole pounds.
  To open a bank account you must deposit at least £100
  A bank account can be open with an over draft
  An account with an overdraft should add the overdraft to the balance

  Scenario: The one where the customer does have enough money to open a bank account
    When "Dade Murphy" opens a bank account with 100 pounds
    Then "Dade Murphy" account is created
    And  the balance is 100 pounds
    # TODO: Check the statement

#  Scenario: The one where the customer does not have enough money to open a bank account
#    When "Kate Libby" opens a bank account with 99 pounds

