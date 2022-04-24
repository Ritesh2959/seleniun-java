@loanSignUp

Feature: Sign up Process as a new Borrower at Zopa

  Background:
    Given I navigate to zopa home page
    And I close cookies notifications at the end of page

  Scenario Outline: signup process for getting personalized loan
    When I click on the "<maninMenu>" menu link
    And I click on the "<subMenu>" sub menu link
    Then  I should be on Zopa Loan Page

#    When I enter the "<amount>" I want to borrow
#    And I select the "<termYear>" for my loan
    And I click on the Get My personalised rates button

#    Then I should see signup form for personal loan
    When I select the loan type "Home improvement"
    And I enter my email "test@test.com" Id in about you section
    And I select title "Mr" in about you section
    And I enter first name "Ritesh"
    And I enter last name "Kumar"
    And I enter date of birth "10" "10" "1980"
    When I select employment status "employedFullTime" from your finances section
    And I enter annual income as "56000"
    And I select home owner "withMortgage" section
    And I enter postcode "RM5 2LA"
    And I click on lookup address button
    And I select the address from the given list
    And I select monthe "January" and year "2015"
    And I click on the use this address button


    Examples:
      | maninMenu | subMenu | amount | termYear |
      | borrow    | loan    | 5000   | 3        |
#      | save      | Smart Saver | --     | --   |


