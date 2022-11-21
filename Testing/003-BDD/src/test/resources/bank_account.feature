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
    And the balance is 100 pounds
    And the account statement should be:
    """
    Dade Murphy:

    Transaction|Amount|Balance
    0001|+100|100
    """

  Scenario: The one where the customer does not have enough money to open a bank account
    When "Kate Libby" opens a bank account with 99 pounds
    Then the account is not opened

  Scenario: The one where the customer deposits more money into their account
    Given "Joey Pardella" has an account with 150 pounds
    When they deposit 100 pounds into the account
    Then the balance is 250 pounds
    And the account statement should be:
    """
    Joey Pardella:

    Transaction|Amount|Balance
    0001|+150|150
    0002|+100|250
    """

  Scenario: The one where the customer withdraws money from their account
    Given "Paul Cook" has an account with 150 pounds
    When they withdraw 75 pounds from the account
    Then the balance is 75 pounds
    And the account statement should be:
      """
      Paul Cook:

      Transaction|Amount|Balance
      0001|+150|150
      0002|-75|75
      """

  Scenario: The one where the customer tries to withdraw more money than is in the account
    Given "Paul Cook" has an account with 100 pounds
    When they withdraw 101 pounds from the account
    Then the money cannot be withdrawn
    And the balance is 100 pounds

