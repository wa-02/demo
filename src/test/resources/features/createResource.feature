Feature: Creation of Resources on schoology

  Scenario: create a resource of type: Add Test/Quiz without additional option.
    Given I log in as "ResourceInstructor01" user
    And I create an Add Test Quiz resource with:
      | name | MT_Quiz Template |
      | maxPoints | 80 |
    And I added a multiple choice question with:
      | question | What kind of animal is a feline |
      | choice_0 | Dog |
      | choice_1 | Elephant |
      | choice_2 | Cat |
      | is_answer | 3 |
      | number_of_options | 3 |

