
![Logo](https://www.browserstack.com/images/layout/browserstack-logo-600x315.png)


# BrowserStack Inception Assignment
## Workflow To Automate
1) Using BrowserStack Live, go to www.google.com and search for “BrowserStack”.

2) Write a BrowserStack Automate test that completes Step #1:

3) Log in to www.browserstack.com

4) Start a Live session

5) Within the Live session, perform a Google search for BrowserStack

6) Execute the above Selenium test in 3 different browsers (Chrome, Firefox, IE)

7) Run the test across all 3 browsers in parallel.

8) Add BrowserStack’s REST API to your script to automatically mark any passing tests as “passed” and any failing tests as “failed” in the Automate Dashboard
## Tools and Technologies
1) Selenium
2) Java - Programming language
3) TestNG
4) Maven
5) Jenkins
6) BrowserStack Live & Automate
## How to run?
1) Enter your userName and AccessKey in conf/parallel.conf.js file
2) Run testng.xml 
3) See the results on Browserstack Automate page.
4) You can run it via command prompt using 
4.1) mvn compile

4.2) mvn test -P parallel

5) You can also create a freestyle job in jenkins, Set JAVA_HOME,M2_HOME,install Browserstack and enter its credentials.
6) In Build section of Jenkin Go to Build-> Add build step -> Select Invoke Top level maven targets -> select maven version -> enter goal as test
7) In the Post-Build action choose Browserstack report

## Documentation

[TestNG browserstack](https://www.browserstack.com/docs/automate/selenium/getting-started/java/testng#integrating-your-tests-with-browserstack)

[TestNG parallel](https://www.browserstack.com/docs/automate/selenium/getting-started/java/testng/run-tests-in-parallel)

[Jenkins](https://www.browserstack.com/docs/automate/selenium/jenkins#introduction)

## Authors

- [@Aniket Khaire](https://github.com/Anic10)

