package cucumber;

import ApiObject.WeatherForeCastApiObj;
import Common.PropertyReader;
import Common.RestWrapper;

public class ApiObjectManager {
    WeatherForeCastApiObj weatherForeCastApiObj=null;
    RestWrapper restWrapper=null;
    public ApiObjectManager(RestWrapper restWrapper){
        this.restWrapper=restWrapper;
        this.weatherForeCastApiObj=new WeatherForeCastApiObj(restWrapper);
    }
    public WeatherForeCastApiObj getWeatherForeCastApiObj() {
        return weatherForeCastApiObj;
    }
    public RestWrapper getRestWrapper() {
        return restWrapper;
    }
}
