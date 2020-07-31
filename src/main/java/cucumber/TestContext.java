package cucumber;

import BasePackages.BaseTestSession;
import Common.PropertyReader;
import Common.RestWrapper;

public class TestContext {

    PropertyReader propertyReader=null;
    BaseTestSession baseTestSession=null;
    RestWrapper restWrapper=null;
    ApiObjectManager apiObjectManager=null;
    PageObjectManager pageObjectManager=null;
    public TestContext()  {
        this.propertyReader = new PropertyReader();
        this.baseTestSession=new BaseTestSession("chrome",propertyReader);
        this.restWrapper= new RestWrapper();
        this.pageObjectManager=new PageObjectManager(baseTestSession);
        this.apiObjectManager=new ApiObjectManager(restWrapper);
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
