package StepDef;
import ApiObject.WeatherForeCastApiObj;
import Common.PropertyReader;
import PageObjects.HomePage;
import PageObjects.WeatherPage;
import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


import java.util.List;

public class WeatherForeCastStepDef {
     HomePage homePage= null;//StepInit.testContext.getPageObjectManager().getHomePage();
    WeatherPage weatherPage=null;//StepInit.testContext.getPageObjectManager().getWeatherPage();
    WeatherForeCastApiObj weatherForeCastApiObj=null;//StepInit.testContext.getApiObjectManager().getWeatherForeCastApiObj();
    PropertyReader propertyReader=null;//StepInit.testContext.getPropertyReader();
    Integer tempFromUi=null;
    Double tempFromApi=null;
    TestContext testContext=null;


   public WeatherForeCastStepDef(TestContext testContext)  {
       this.testContext=testContext;
       this.homePage=this.testContext.getPageObjectManager().getHomePage();
       this. weatherPage=this.testContext.getPageObjectManager().getWeatherPage();
       this.weatherForeCastApiObj= this.testContext.getApiObjectManager().getWeatherForeCastApiObj();
       this.propertyReader= this.testContext.getPropertyReader();
    }

    @And("^I click on weather$")
    public void iClickOnWeather() {
        homePage.clickOnWeather();
    }

    @When("^I click on more button$")
    public void iClickOnMoreButton() {
        homePage.clickOnGetBreakingNews();
        homePage.clickOnMoreOption();
    }

    @Then("^I search the the \"([^\"]*)\" and select it$")
    public void iSearchTheTheAndSelectIt(String city) throws Throwable {
        weatherPage.searchAndSelectCity(city);
    }

    @And("^I click on the \"([^\"]*)\" on the map and capture the temperature$")
    public void iClickOnTheOnTheMapAndCaptureTheTemperature(String city) throws Throwable {

        tempFromUi= weatherPage.fetchTemperatureAndClickCityInMap(city);
    }

    @Then("^I verify the following fields are displayed on the weather window$")
    public void iVerifyTheFollowingFieldsAreDisplayedOnTheWeatherWindow(DataTable dataTable) {
        List<String> labels=dataTable.asList(String.class);
        for(String label:labels){
            Assert.assertTrue(weatherPage.verifyFieldInPopup(label),"Verifying the field "+label+" on popup");
        }

    }
    @Then("^I hit the api with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" and fetch the temperature from the api$")
    public void iHitTheApiWithAndAndFetchTheTemperatureFromTheApi(String host, String endpoint, String city, String apiKey) throws Throwable {
         tempFromApi = weatherForeCastApiObj.fetchTheTeperatureFromApi(propertyReader.readProperty(host), propertyReader.readProperty(endpoint), city, propertyReader.readProperty(apiKey));
    }

    @Then("^I verify the temperature from ui and the end point is matching with the variance$")
    public void iVerifyTheTemperatureFromUiAndTheEndPointIsMatchingWithThe() throws Throwable {
      Boolean verify= weatherForeCastApiObj.compareTempWthVarianceLogic(Double.valueOf(tempFromUi),Double.valueOf(tempFromApi),Double.valueOf(propertyReader.readProperty("variance")));
      Assert.assertTrue(verify,"The temperatures from UI ("+tempFromUi+") and temperature from Api ("+tempFromApi+") are not matching with for the variance "+propertyReader.readProperty("variance"));
    }


}
