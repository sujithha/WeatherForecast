package StepDef;

import BasePackages.BaseTestSession;
import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class StepInit {

    public static TestContext testContext=null;
    BaseTestSession session=null;
   public StepInit(TestContext testContext){
        this.testContext=testContext;
        this.session=testContext.getBaseTestSession();
    }
    @Before
    public void beforeSuite(Scenario scenario)  {
        testContext.setScenario(scenario);
    }
       
    @After
    public void afterSuite(Scenario scenario) throws Throwable {
       if(scenario.isFailed()){

       }
        session.takeScreenShot(scenario);
        session.closeBrowser();
     }
    
}


