Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check searching product by name
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that search results contain keyword '<keyword2>'

    Examples:
      | homePage                            | keyword      | keyword2
      | https://www.amazon.com/ref=nav_logo | Lego         | Lego



  Scenario Outline: Check add product to cart from search result
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User chooses product from search result list
    And User clicks add to cart button
    Then User checks that amount of products in cart are '<amountOfProducts>'

    Examples:
      | homePage                            | keyword       | amountOfProducts |
      | https://www.amazon.com/ref=nav_logo | Smartwatch    | 1                |


  Scenario Outline: Try to increase qty of product in cart more then available
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User chooses product from search result list
    And User clicks add to cart button
    And User go to cart page
    And User increases qty of product on '<bigQtyOfProduct>'
    Then System displays a massage with available qty of product

    Examples:
      | homePage                            | keyword       | bigQtyOfProduct |
      | https://www.amazon.com/ref=nav_logo | Smartwatch          | 900             |

    Scenario Outline: Delete product from cart
      Given User opens '<homePage>' page
      And User checks search field visibility
      When User makes search by keyword '<keyword>'
      And User clicks search button
      And User chooses product from search result list
      And User clicks add to cart button
      And User go to cart page
      Then User delete product from cart


      Examples:
        | homePage                            | keyword       |
        | https://www.amazon.com/ref=nav_logo | Smartwatch          |


      Scenario Outline: Enable to login on the site
        Given User opens '<homePage>' page
        And User checks button Account&List visibility
        And User clicks on button Account&List
        And User inputs '<email>' and continue
        Then System enables to inputs '<password>' for sign-in

        Examples:
          | homePage                            | name       | email                              | password
          | https://www.amazon.com/ref=nav_logo | Olga       | automation.test.cucumber@gmail.com | Cucumber313


  Scenario Outline: Try to create account with existing email address
        Given User opens '<homePage>' page
        And User checks button Account&List visibility
        And User clicks on button Account&List
        And User clicks on create account button
        And User inputs '<name>', existing '<email>', '<password>' to create account
        And User continue registration
        Then System displays massage that email already existed

        Examples:
          | homePage                            | name       | email                              | password
          | https://www.amazon.com/ref=nav_logo | Olga       | automation.test.cucumber@gmail.com | Cucumber313

  Scenario Outline: Add to cart product from menu
    Given User opens '<homePage>' page
    And User clicks menu button
    And User chooses category of product
    And User chooses subcategory of product
    And User chooses product from result page
    And User clicks add to cart button
    Then User checks that amount of products in cart are '<amountOfProducts>'

    Examples:
      | homePage                             | amountOfProducts |
      | https://www.amazon.com/ref=nav_logo  | 1                |

   Scenario Outline: Filter product by Brand
     Given User opens '<homePage>' page
     And User clicks menu button
     And User chooses category of product
     And User chooses subcategory of product
     And User makes filter by brand
     Then User checks that after filtering products contains name of chosen brand

     Examples:
       | homePage                            |
       | https://www.amazon.com/ref=nav_logo |

     Scenario Outline: After adding product to cart user sees content of the cart on the inner pages
       Given User opens '<homePage>' page
       And User clicks menu button
       And User chooses category of product
       And User chooses subcategory of product
       And User chooses product from result page
       And User clicks add to cart button
       Then User checks that amount of products in cart are '<amountOfProducts>'
       And User goes to inner page
       Then User can see on inner page content of the cart

       Examples:
         | homePage                             | amountOfProducts |
         | https://www.amazon.com/ref=nav_logo  | 1                |


     Scenario Outline: Customer service page contains 9 blocks and field for input
       Given User opens '<homePage>' page
       And User clicks on customer service button
       And User checks that customer service page contains '<numberOfBoxes>'
       And User checks that customer service page contains field for input
       Then User input '<checkWord>' in input field

       Examples:
         | homePage                             | numberOfBoxes | checkWord
         | https://www.amazon.com/ref=nav_logo  | 9             | help

