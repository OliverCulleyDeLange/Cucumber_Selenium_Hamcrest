@RequiresSelenium
Feature: Checking links on Splash Page
  Scenario: Testing website link
    Given I am on oliverdelange home page
    When I click the about me link
    Then I will be redirected to oliverdelange about me

