Feature: User account tests


  Scenario: Verify user information
    Given I am on the login page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then account holder name should be "Test Librarian 12"

    # TEST CASE
  @wip
  Scenario Outline: Verify user information 2
    Given I am on the login page
    When I login using "<email>" and "<password>"
    Then account holder name should be "<name>"

   #TEST DATA
    Examples:
      | email             | password | name            |
      | student26@library | JTvaF3br | Test Student 26 |








#  Test Student 26 student26@library   JTvaF3br
#  Test Student 27 student27@library   kkMksO2i
#  Test Student 28 student28@library   19Ceq2sT
#  Test Student 29 student29@library   WyIUNpDI
#  Test Student 30 student30@library   IaT9YI0I
#  Test Librarian 13   librarian13@library 9rf6axdD
#  Test Librarian 14   librarian14@library 87x8afWY
#  Test Librarian 15   librarian15@library S5Ejblg1
#  Test Librarian 16   librarian16@library 8BzUhhaU
#  Test Librarian 17   librarian17@library tXqOoIOS
#  Test Librarian 18   librarian18@library rKG2sP88
#  Test Librarian 19   librarian19@library 6M0J2Wr7
#  Test Librarian 20   librarian20@library XXJTMgzA
#  Test Librarian 21   librarian21@library aZ849tSZ
#  Test Librarian 22   librarian22@library bJRnAAyp
#  Test Student 31 student31@library   yOPdSR0u
#  Test Student 32 student32@library   GYLemAba
#  Test Student 33 student33@library   a1aI3VDj
#  Test Student 34 student34@library   eEQDhR9C
#  Test Student 35 student35@library   TNb5zpGn
#  Test Student 36 student36@library   qR3brbb1
#  Test Student 37 student37@library   GpaUyXJQ
#  Test Student 38 student38@library   r3sqckHs
#  Test Student 39 student39@library   GCTOZ0Yk
#  Test Student 40 student40@library   sK7ctVOS
#  Test Student 41 student41@library   MhQEHwP8
#  Test Student 42 student42@library   zCm83mcJ
#  Test Student 43 student43@library   7F1rV4W8
#  Test Student 44 student44@library   BIXPElK5
