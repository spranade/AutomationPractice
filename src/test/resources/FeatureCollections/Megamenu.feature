#Author: swanand ranade


@Megamenu
Feature: Megamenu feature
  
  Background: 
    When user opens the "chrome" browser
    And user enter the url "http://automationpractice.com/"

   @SmokeTest
  Scenario: To Check whether Megamenu works 
    Given user is on the application home page
    When user clicks on Dresses link
    And user clicks on Summer dresses link
    And user selects sort by "Price: Highest first" value 
    Then product grid gets loaded successfully
    And product grid is arranged properly by price value  
    Then close the Browser