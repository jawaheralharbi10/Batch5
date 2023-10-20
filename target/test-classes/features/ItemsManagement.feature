Feature: Items Management

  Background: 
    Given As An entity user, I am logged in

  @createItem
  Scenario: As a user, I am able to create an item or a service
    And I navigate to Items tab
    When I click on the Add Item button
    Then I should be on the item input page
    When I provide item information name "backpack", price "18", unit "pc", and description "a nice backpack"
    And I click Save Item button
    Then The Item is added to the Item list table
    And I delete the item

  @updateItem
  Scenario: As a user, I am able to update an item or a service
    And I navigate to Items tab
    When I click on the Add Item button
    Then I should be on the item input page
    When I provide item information name "Iphone 15", price "18", unit "pc", and description "black Iphone 15"
    And I click Save Item button
    Then The Item is added to the Item list table
    When I click on Edit button
    Then I should be on Edit items page
    When I update the items price to "2300"
    And I click on update item button
    Then Items price should be update to "2300"
    And I delete the item
    
    @ScenarioOutlineDemo
    Scenario Outline: As a user, I am able to create items with data table
    And I navigate to Items tab
    When I click on the Add Item button
    Then I should be on the item input page
    When I provide item information name "<itemName>", price "<itemPrice>", unit "<unitType>", and description "<itemDes>"
    And I click Save Item button
    Then The Item is added to the Item list table
    And I delete the item

    Examples: Items Data
    | ItemName    | itemPrice | unitType | itemDes            |
    | Dell Labtop | 5500      | pc       | Silver Labtop      |
    | Desk        | 3200      | pc       | office Desk        |
    | Coffee bean | 1500      | pc       | Arabic Coffee bean |