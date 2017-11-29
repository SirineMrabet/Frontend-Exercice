Feature: search for a word in the wiki


  @stable
  Scenario Outline: search a word in wiki
    Given I'm in the wiki home page
	When I search <word>
    Then The result of the search displays

    Examples:
      | word           |
      | furry rabbits  |