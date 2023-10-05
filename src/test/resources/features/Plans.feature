@Regression
Feature: CSR Plans Page Feature

  Background: Login and navigate to Plans
    Given Login with username as "supervisor" and password as "tek_supervisor"
    When Wait 2 Second
    When Click on "Plans" Link
    When Wait 2 Second

  @US_8
  Scenario: Validate Plans are exist in table
    Then Validate Section title is "Plans"
    Then Validate Table row is 4
    And Validate All Plans are Valid

  @US_11
  Scenario: Validate plan code headers
    Then Validate Section title is "Plans"
    Then validate plan table header
      | Plan Type | Base Price | Date Expire | Created By | Date Created | Plan Expired |

  @US_13
  Scenario: Validate Plan Data
    Then Validate Section title is "Plans"
    Then Validate plan table data
      | Motorcycle | System | Valid |
      | Boat       | System | Valid |
      | Renters    | System | Valid |
      | Auto       | System | Valid |

  @US_14
  Scenario: Validate Plan Data using map data table
    Then Validate Section title is "Plans"
    Then Validate plan table data with maps
      | planType   | createdBy | isExpired |
      | Motorcycle | System    | Valid     |
      | Boat       | System    | Valid     |
      | Renters    | System    | Valid     |
      | Auto       | System    | Valid     |

  @US_15
  Scenario: Validate Plan Table header with single list.
    Then Validate Section title is "Plans"
    Then Validate table header with single list
      | Plan Type    |
      | Base Price   |
      | Date Expire  |
      | Created By   |
      | Date Created |
      | Plan Expired |

  @US_16
  Scenario: Validate Plan Table header with single map
    Then Validate Section title is "Plans"
    Then Validate Plan Data first row only with single map
      | planType  | Motorcycle |
      | createdBy | System     |
      | isExpired | Valid      |