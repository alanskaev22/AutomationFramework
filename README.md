
## High level overview ##


### Apache Maven based. Easy to import in any IDE, simple to build on any continuous integration system. ###


* JUnit 5 for test execution

* Soft, Custom and fluent assertions through Assertj

* POM design pattern

* Selenide for easy web-automation

* Allure-reports for report generation

* Lombok to reduce boilerplate code

* Log4J  for logging (Can also use @SLF4J/LOG4J Annotation before class)

* Spotless for code cleanliness 

....More to come


## Requirements ##

* Java 8 or higher

* Lombok (Must install & enable annotation processor after installation: Preferences | Other Settings | Lombok plugin )


## Notes ##

* Run Test as usually do with maven 
```
  mvn clean compile test
  ```
* To run spotless, use commands 
```
  mvn spotless:check  
  mvn spotless:apply
  ```

* To generate Allure reports, use commands 
``` 
  mvn allure:report (generate in target folder) 
  mvn allure:serve (generate and open report)
  ```
  
  Alternatively, you can expand confguration in maven sidebar.
