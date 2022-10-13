#Author: Swanand Ranade


@registration
Feature: Registration Feature

  Background: 
    When user opens the "chrome" browser
    And user enter the url "http://automationpractice.com/"

  

@SmokeTest
  Scenario: Registration using valid email address
    Given user is on the application home page
    When user clicks Sign in link
    Then user is on registration page
    And user enters "abc444@xyz444.com" as emailid
    And user clicks on Create an account button
    Then registration form gets loaded
    Then user enters invalid account details as "Male" "abc" "xyz"  "test" "20" "2" "2018" "abc" "xyz" "wipro" "Address1" "Address2" "New York" "New York" "12345" "United States" "Test" "12345678" "1234567890" "xyzxyz@abcabc.com" 
    Then user clicks on register button
    #Then user does not get registered successfully
    And user gets the error message starting with "There are" on the top
    Then close the Browser

@SmokeTest
  Scenario: Registration using Invalid email address
    Given user is on the application home page
    When user clicks Sign in link
    Then user is on registration page
    And user enters "abc333@xyz333..com" as emailid
    And user clicks on Create an account button
    Then error message is displayed starting with "Invalid email address" on top
    Then close the Browser
    
    
#@SmokeTest
  #Scenario: Registration using valid email address
    #Given user is on the application home page
    #When user clicks Sign in link
    #Then user is on registration page
    #And user enters "abc444@xyz444.com" as emailid
    #And user clicks on Create an account button
    #Then registration form gets loaded
    #Then user enters account details as "Male" "abc" "xyz"  "test@123" "20" "2" "2018" "abc" "xyz" "wipro" "Address1" "Address2" "New York" "New York" "12345" "United States" "Test" "12345678" "1234567890" "xyzxyz@abcabc.com" 
    #Then user clicks on register button
    #Then user gets registered successfully
    #And user gets the message starting with "Welcome to your account" on the top
    #Then close the Browser
    