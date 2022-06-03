Feature: Standard operations expected for our Bank app.

  Scenario: User want to make a deposit on specific account
    Given an account with amount  1000.50 euros
    When he make a deposit of 500.0 euros on account
    Then  the final amount account should be 1500.50 euros

  Scenario: User want to make a withdrawal on specific account
    Given an account with amount  1022.0 euros
    When he make a withdrawal 502.0 euros on account
    Then  the final amount account should be 520.0 euros

  Scenario: User want to show history
    Given an account with amount  1000.0 euros
    When he executes the following operations :
      | Amount | Operation Type |
      | 200    | DEPOSIT        |
      | 100    | WITHDRAWAL     |
    Then  the size of statements should be 2
    And  the show history should be contains the following statement:
      | Operation Type | Amount | Balance |
      | DEPOSIT        | 200    | 1200.0  |
      | WITHDRAWAL     | 100    | 1100.0  |