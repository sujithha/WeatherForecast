package StepDef;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class StepInit {

    public static TestContext testContext=null;
   public StepInit(TestContext testContext){
        this.testContext=testContext;
    }
    @Before
    public void beforeSuite() throws Throwable {
   // testContext =new TestContext();
    }
       
    @After
    public void afterSuite() throws Throwable {
    	/*session.takeScreenShot();
    	session.closeBrowser();*/
     }
    
}


