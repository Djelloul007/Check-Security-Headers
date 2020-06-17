Feature: Security Headers


  Scenario Outline: Check Security Headers
    Given the application is running
    When I check the application status
    Then the API should return for the following Securityheadername <Securityheadername> with the value <Securityheadervalue>

    Examples:
      | Securityheadername |  Securityheadervalue |
      | X-Content-Type-Options | nosniff |
      | X-Frame-Options | DENY |
      | X-Xss-Protection | 1; mode=block |



