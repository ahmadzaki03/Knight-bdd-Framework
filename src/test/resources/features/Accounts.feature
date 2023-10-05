@Regression
Feature: Validate Accounts Table

  Background: Login step repeat for each scenario
    Given Login with username as "supervisor" and password as "tek_supervisor"
    When Wait 2 Second

  @US_9
  Scenario: Validate account table rows
    When Click on "Accounts" Link
    When Wait 60 Second
    Then Validate accounts table have 10 rows

  @US_10
  Scenario: Validate Change Item per page
    When Click on "Accounts" Link
    When Wait 60 Second
    Then Validate accounts table have 10 rows
    When change item per page to "25"
    When Wait 2 Second
    Then Validate accounts table have 25 rows
    When change item per page to "100"
    When Wait 2 Second
    Then Validate accounts table have 100 rows


  @US_12
  Scenario: Validate account table headers
    When Click on "Accounts" Link
    When Wait 60 Second
    Then Validate Accounts table headers
      | Delete | Email | Full Name | Gender | Martial Status | Employement Status | Date of Birth | Account Detail |