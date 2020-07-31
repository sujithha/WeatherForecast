package PageObjects;

import BasePackages.BaseTestSession;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;


public class WeatherPage implements Xpath.WeatherPage {
	BaseTestSession session=null;
	WebDriver driver=null;
	Double tempFromUi=null;

	private Logger logger=Logger.getLogger(this.getClass().getName());
	public WeatherPage(BaseTestSession session) {
		this.session=session;
		driver=session.driver;
	}
	public Double getTempFromUi() {
		return tempFromUi;
	}

	public void setTempFromUi(Double tempFromUi) {
		this.tempFromUi = tempFromUi;
	}

	public void searchAndSelectCity(String city){
		session.getVisibeltyOfElementLocated(searchBox);
        session.getVisibleElement(searchBox).sendKeys(city);
		session.getVisibleElement(searchBox).click();
		session.getVisibleElement(searchBox).sendKeys(Keys.ENTER);
		String checkBox=String.format(searchCheckBox,city.substring(0,1).toUpperCase()+city.substring(1));
		logger.info("Searched the city "+city);
     try {
		 session.scrollToElelemt(By.xpath(checkBox));
		 session.getVisibleElement(By.xpath(checkBox)).getAttribute("checked");
		 logger.info(city +" is already selected");
	 }
     catch (Exception e){
		 session.getVisibleElement(By.xpath(checkBox)).click();
		 logger.info("Checked the city check box");
	 }
		session.takeScreenShot();
	}
	
	public Double fetchTemperatureAndClickCityInMap(String city) {
		String temperatureOnMap=String.format(temperatureInDegree,city.substring(0,1).toUpperCase()+city.substring(1));
		session.scrollToElelemt(By.xpath(temperatureOnMap));
		String temperature=session.getVisibleElement(By.xpath(temperatureOnMap)).getText().trim().replace("℃","");
		session.getVisibleElement(By.xpath(temperatureOnMap)).click();
		logger.info("Fetched the temperature from map as "+temperatureOnMap+" and clicked on temperature");
		session.takeScreenShot();
		setTempFromUi(Double.valueOf(temperature));
		return  Double.valueOf(temperature);

	}

	public boolean verifyFieldInPopup(String field){
		logger.info("Verifying "+field+" on weather popup");
		return session.verifyElementIsDisplayed(By.xpath(String.format(labels,field)));


	}
	
}
