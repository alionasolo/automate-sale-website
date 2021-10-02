

Feature: Add to cart  and configure the order

  Scenario: Add a product to the cart and proceed to order

    Given User navigate to store page
    And User click on 'Women' menu
    And User click on 'Dresses'  submenu
    And User click on 'Casual Dresses' item
    And 'Casual dresses' category page is displayed
    When User click on More button from product preview
    And User selects size of product
    And User click on Add to cart button
    Then A popup with a success message is displayed
    When User click on Proceed to checkout button from popup
    And User click on Proceed to checkout button from 'SHOPPING-CART SUMMARY'
    And User log in from sign in page with valid data
    | andra@gmail.com | 123456789 |
    And User click on proceed to checkout button from 'Addresses' tab
    And User continue checkout from 'Shipping' tab
    Then User proceed to payment on '05. Payment' tab

