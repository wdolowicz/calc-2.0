# calc 2.0 tests

This repo contains java tests for web2.0calc.com. Test suite consists of couple equations.

Whole development was made on a Linux running machine (Pop!_OS 20.10) and thus it works on Linux for sure, but it should work on any other OS as well (only if the must haves for target OS are met)

Must haves:

1. JDK (http://jdk.java.net/15/)
2. JAVA_HOME environment variable properly set
3. Maven (https://maven.apache.org/download.cgi)
4. chromedriver v87, Selenium RC Standalone & TestNG - libs are included but in case of trouble, there might be a need to install those separately
5. Google Chrome v87 (https://www.google.com/chrome/?brand=CHBD&brand=BNSD&gclid=CjwKCAiA_eb-BRB2EiwAGBnXXsuWg7CMa-6VZbpRAYsj6kgYnB8NREyJtx_ziwUjIIXqorp2IksBQxoCuHwQAvD_BwE&gclsrc=aw.ds)

Usage:

1. Clone repo
2. Navigate to main repo folder (/calc-2.0)
3. Open terminal
4. Execute following:
      mvn clean test -DsuiteXmlFile=testng.xml
5. Tests should perform
