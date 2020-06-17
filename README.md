# Check Security Headers using Serenity BDD 

This tutorial show you how to Check Security Headers using Serenity BDD. 

## Get the code



### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                                Test runners and supporting code
    + resources
      + features                          Feature files 
        check_security_headers.feature 
      + templates                         Freemarker templates and properties files                

```

## The list of security headers to be checked is in the check_security_headers.feature file.

### Feature: Security Headers


  ### Scenario Outline: Check Security Headers
    ### Given the application is running
    ### When I check the application status
    ### Then the API should return for the following Securityheadername <Securityheadername> with the value <Securityheadervalue>

    ### Examples:
      | Securityheadername |  Securityheadervalue |
      | X-Content-Type-Options | nosniff |
      | X-Frame-Options | DENY |
      | X-Xss-Protection | 1; mode=block |
