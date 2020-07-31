# WeatherForecast
The Above frmework is Cucumber java with maven framework. Use the below maven command to trigger the test Run
clean verify -Dtag=@regression -Denvironment=QA

Parameter detils:
tag = tag in the feature file for ex:@regression
       environment= is the evironment which test should be triggere ex: QA, DEV. This initialises different property files for the environment provided.
 
Framework Features:      
     1) We can easily customise the test run or test suites just by adding the tags on feature level or scenario level in feature file and can use it in maven command.
     2) The TestNg test runners aregenerated at the run time with the help of "cucumber-jvm-parallel-plugin".
     3) The  detailed cucumber report with attached screenshot for complete test run will be generated using maven-cucumber-reporting plugin.
     4) Easy to run the test in any environment just by passing the environment in mavencommand.
     
     Sample Test report:
     https://github.com/sujithha/WeatherForecast/blob/master/target/cucumber-report-html/cucumber-html-reports/feature-overview.html
     To check the report download target folder and open "feature-overview.html" file under cucumber-html-reports folder in any browser.
     
     Report Features:
     1) We can view the tag wise report
     2) Detailed report for failed scenarios
     3) Each scenario in report will replicate the steps in feature file and each steps will have the screenshots attached.
     4) Graph for each of the test run can be found in test report
     
     
     
