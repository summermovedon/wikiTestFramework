
Feature: Wikipedia's pages testing

  Background: I am on the main page
    Given I am on the "https://ru.wikipedia.org"

  Scenario: We can look for Krokodil page (TASK-1)
    Given "searchQuery" is set "Крокодил"
     When I fill "searchField" with "searchQuery" value
      And I click the "searchButton"
     Then "mainHeader" text contains "Крокодил"

  Scenario: We can look for Bulldog page (TASK-2)
    Given "searchQuery2" is set "Бульдог"
    When I fill "searchField" with "searchQuery2" value
      And I click the "searchButton"
    Then "mainHeader" text contains "Бульдог"

  Scenario: We can look for Hoover page (TASK-3)
    Given "searchQuery3" is set "Гувер"
      When I fill "searchField" with "searchQuery3" value
      And I click the "searchButton"
      Then "mainHeader" text contains "Гувер"

  Scenario: We can look for random page (TASK-4)
    Given I am on the randon page
    Then "mainHeader" text is random
