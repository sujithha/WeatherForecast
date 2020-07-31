package cucumber;

import BasePackages.BaseTestSession;
import Common.PropertyReader;
import Common.RestWrapper;
import cucumber.api.Scenario;

public class TestContext {

    PropertyReader propertyReader=null;
    BaseTestSession baseTestSession=null;
    RestWrapper restWrapper=null;
    ApiObjectManager apiObjectManager=null;
    PageObjectManager pageObjectManager=null;
    Scenario scenario=null;
    public TestContext() throws Exception {
        this.propertyReader = new PropertyReader();
        propertyReader.initialisePropertyFile();
        this.baseTestSession=new BaseTestSession(propertyReader.readProperty("browser"),propertyReader);
        this.restWrapper= new RestWrapper();
        this.pageObjectManager=new PageObjectManager(baseTestSession);
        this.apiObjectManager=new ApiObjectManager(restWrapper);
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    public Scenario getScenario() {
        return scenario;
    }
    public PropertyReader getPropertyReader() {
        return propertyReader;
    }

    public BaseTestSession getBaseTestSession() {
        return baseTestSession;
    }

    public RestWrapper getRestWrapper() {
        return restWrapper;
    }

    public ApiObjectManager getApiObjectManager() {
        return apiObjectManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
