package cucumber;

import BasePackages.BaseTestSession;
import PageObjects.HomePage;
import PageObjects.WeatherPage;

public class PageObjectManager {
    HomePage homePage=null;
    WeatherPage weatherPage=null;
    public PageObjectManager(BaseTestSession session){
        this.homePage= new HomePage(session);
        this.weatherPage=new WeatherPage(session);
    }

    public WeatherPage getWeatherPage() {
        return weatherPage;
    }


    public HomePage getHomePage() {
        return homePage;
    }

}
