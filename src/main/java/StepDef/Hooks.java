package StepDef;

import BasePackages.BaseTestSession;
import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    public static TestContext testContext=null;
    BaseTestSession session=null;
   public Hooks(TestContext testContext){
        this.testContext=testContext;
        this.session=testContext.getBaseTestSession();
    }
    @Before
    public void beforeSuite(Scenario scenario)  {
        testContext.setScenario(scenario);
        session.setScenario(scenario);
    }
       
    @After
    public void afterSuite(Scenario scenario) throws Throwable {
       if(scenario.isFailed()){
           session.takeScreenShot();
       }
        session.closeBrowser();
     }
    
}


