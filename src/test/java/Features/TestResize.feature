Feature: Resize and verify elements



  @stable
  Scenario: Resize and verify
    Given I'm on the Travelex website
    When I resize the window
    And I Swipe left on the slider
    Then The displayed item is the third one

