package ApiObject;

import Common.RestWrapper;
import com.google.gson.internal.LinkedHashTreeMap;
import com.jayway.jsonpath.JsonPath;

import java.util.Map;

public class WeatherForeCastApiObj {
    RestWrapper restWrapper=null;
    public WeatherForeCastApiObj(RestWrapper restWrapper){
      this.restWrapper=  restWrapper;
    }

    public Double fetchTheTeperatureFromApi(String host,String endPoint,String city,String key) throws Exception {
        Map<String,String> requestParams=new LinkedHashTreeMap<String, String>();
        requestParams.put("q",city);
        requestParams.put("appid",key);
       String response= restWrapper.getCallHttp(host,endPoint,restWrapper.setHeaders(),requestParams);
        Double temperatureInK=JsonPath.read(response,"$.main.temp");
        Double tempInCelcius=temperatureInK-273;
        return tempInCelcius;
    }
    public Boolean compareTempWthVarianceLogic(Double temp1,Double temp2,Double varience){
        if(Math.abs(temp1-temp2)<=varience){
            return true;
        }
        else {
            return false;
        }
    }
}