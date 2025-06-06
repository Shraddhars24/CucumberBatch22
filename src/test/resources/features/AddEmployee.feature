Feature: Add employee

  Background:
    #Given user is able to access HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on Add employee option

  @sprint1 @sami
  Scenario: Adding the employee by firstname and lastname

    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

    @sprint2 @smoke @regression @sami
  Scenario: Adding the employee by firstname middlename and lastname

    And user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee added successfully

      @params @dbTesting
      Scenario: Adding the employee using parameters
        And user enters "Mark" and "Anthony" and "Jacob" in the application
        And user clicks on save button
        Then employee added successfully

        @example
        Scenario Outline: adding multiple employee
          And user add "<firstname>","<middlename>" and "<lastname>"
          And user clicks on save button
          And employee added successfully
          Examples:
            | firstname | middlename | lastname |
            |mark       |ms          |jacob     |
            |adam       |ms          |jacob     |
            |steve      |ms          |jacob     |

          @data
          Scenario: Adding multiple employees using data table
            When user adds multiple employees using data table and save them
            |firstName|middleName|lastName|
            |mark     |ms        |jacob   |
            |adam     |ms        |jacob   |
            |steve    |ms        |jacob   |

            @excel
         Scenario: adding employees using excel file
         When user adds multiple employees from excel file
