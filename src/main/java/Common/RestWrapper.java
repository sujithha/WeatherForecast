
package Common;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import io.restassured.builder.*;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class RestWrapper {

   private ValidatableResponse response;
    private Logger logger=Logger.getLogger(this.getClass().getName());
    public String posCallHttps(String host, String endPointUrl, String postBody, Map<String,String> headers) throws Exception {
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri(host);
        builder.setBody(postBody);
        builder.setBasePath(endPointUrl);
        builder.setConfig(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()));
        builder.setUrlEncodingEnabled(false);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec=builder.build();
        response=given().spec(requestSpec).headers(headers).post().then().log().status();
        int responsecode=response.extract().statusCode();
        logger.info("Service url: "+host+endPointUrl);
        if(responsecode!=200 && responsecode!=202 && responsecode!=201 && responsecode!=204 ){
            throw new Exception(String.format("Call endpoint %1s%2s got error with response code %3s for Post Body -%4s",host,endPointUrl,responsecode,response.extract().body().asString()));
        }
        return  response.extract().body().asString();
    }
    public String getCallHttps(String host, String endPointUrl, Map<String,String> headers) throws Exception {

        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri(host);
        builder.setBasePath(endPointUrl);
        builder.setConfig(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()));
        builder.setUrlEncodingEnabled(false);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec=builder.build();
        response=given().spec(requestSpec).headers(headers).get().then().log().status();
        int responsecode=response.extract().statusCode();
        logger.info("Service url: "+host+endPointUrl);
        if(responsecode!=200 && responsecode!=202 && responsecode!=201 && responsecode!=204 ){
            throw new Exception(String.format("Call endpoint %1s%2s got error with response code %3s for Post Body -%4s",host,endPointUrl,responsecode,response.extract().body().asString()));
        }
        return  response.extract().body().asString();
    }
    public String getCallHttp(String host, String endPointUrl, Map<String,String> headers,Map<String,String> params) throws Exception {
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri(host);
        builder.setBasePath(endPointUrl);
        builder.setUrlEncodingEnabled(true);
        builder.setContentType(ContentType.JSON);
        builder.addParams(params);
        RequestSpecification requestSpec=builder.build();
        response=given().spec(requestSpec).headers(headers).get().then().log().status();
        int responsecode=response.extract().statusCode();
        logger.info("Service url: "+host+endPointUrl);
        if(responsecode!=200 && responsecode!=202 && responsecode!=201 && responsecode!=204 ){
            throw new Exception(String.format("Call endpoint %1s%2s got error with response code %3s for Post Body -%4s",host,endPointUrl,responsecode,response.extract().body().asString()));
        }
        return  response.extract().body().asString();
    }
    public Map<String,String> setHeaders(){
        Map<String,String> headers= new HashMap<String, String>();
        headers.put("Content-Type","application/json");
        return  headers;
    }

}

