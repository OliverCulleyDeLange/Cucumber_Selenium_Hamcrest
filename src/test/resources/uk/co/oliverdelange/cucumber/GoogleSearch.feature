@RequiresSelenium
Feature: Searching Google for random strings
  Scenario Outline: Google Search Test
    Given I am on google search page
    When I search for <text>
    Then I will see results related to <text>
  Examples:
    |text       |
    |Hello World|

