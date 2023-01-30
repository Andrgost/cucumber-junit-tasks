Feature: As a user I want to get ability to see article page

  @smoke
  Scenario: Search results should contains article links
    Given the user opens Cucumber website
    And the user click on the Allow all cookies button
    When the user clicks on the Search icon
    And the user searches for Announces
    And the user filters search results by "Blog" param
    And the user clicks the first search result
    Then page with title "Article Name" is displayed