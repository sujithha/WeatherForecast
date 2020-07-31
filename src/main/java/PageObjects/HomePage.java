package PageObjects;

import java.sql.Driver;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePackages.BaseTestSession;
import Common.PropertyReader;



public class HomePage implements Xpath.HomePage {
	BaseTestSession session=null;
	WebDriver driver=null;
	private Logger logger=Logger.getLogger(this.getClass().getName());
	public HomePage(BaseTestSession session) {
		this.session=session;
		driver=session.driver;
	}
	
	public void clickOnMoreOption(){
     session.getVisibleElement(moreOption).click();
     logger.info("Clicked on more button");
     session.takeScreenShot();
	}
	
	public void clickOnWeather() {
		session.getVisibleElement(weather).click();
		logger.info("Clicked on Weather");
		session.takeScreenShot();
	}
	public void clickOnGetBreakingNews(){
		try {
			session.getVisibeltyOfElementLocated(noThanksPopup);
			logger.info("Get Breaking news alert popup is visible");
			session.getVisibleElement(noThanksPopup).click();
			logger.info("Clicked on No thanks button");
		}
		catch (Exception e){
			logger.info("Get Breaking news alert popup is not displayed");
		}
	}
	
}
