Feature: As a user I want to get ability to see article page

  @smoke
  Scenario: Search results should contains article links
    Given the user opens Cucumber website
    When the user clicks on the "Search" icon
    When the user enter "Announces" in the "Search" field
    When the user filters search results by "Blog" param
    And the user click the first search result link
    Then page with title "Article Name" is displayed