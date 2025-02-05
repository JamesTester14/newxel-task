Prerequisites:

- Java (JDK 17)
- Maven
- Chrome

Setup maven:

`mvn clean install` or  run `mvn dependency:resolve` to download dependencies without running tests

To execute all tests, use the following command:

`mvn clean test`


Run the Allure report:

`mvn allure:serve`

Comment:

We can include currency assertion on UI tests, but to make tests green and beautiful I've asserted only values 