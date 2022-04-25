@homePage

  Feature: test feature

Background:
Given I navigate to Google home page

Scenario Outline: scenario 1
When I click on the "<maninMenu>" menu link
And I click on the "<maninMenu>" sub menu link

Examples:
  |maninMenu|maninMenu|
  |         |         |