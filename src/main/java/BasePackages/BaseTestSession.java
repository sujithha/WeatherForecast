package BasePackages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.PropertyReader;
import org.testng.Reporter;

public class BaseTestSession  {
	
	public WebDriver driver=null;
	public PropertyReader properties=null;

	public  Scenario scenario=null;

    public BaseTestSession(String browser, PropertyReader propertyReader)  {
		this.properties=propertyReader;
		try {
			openBrowser(browser);
		}
		catch(Exception e){}
		applyImplicitWait(20);
	}
	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public WebDriver getDriver() {
        return driver;
    }

    public PropertyReader getProperties() {
        return properties;
    }

    public void waitForPageToLoad(){
		ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
	WebDriverWait wait=new WebDriverWait(driver, 120);
	wait.until(expectation);
	}
	public  WebDriver openBrowser(String browser) throws Exception {

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Opened Chrome Browser");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src/main//java//resources//geckodriver.exe");
			driver=new FirefoxDriver();
			Reporter.log("Opened firefox Browser");
		}
		else if(browser.equalsIgnoreCase("IE"))

		{   DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//src//main//java//resources//IEDriverServer.exe");
			driver=new InternetExplorerDriver(capabilities);
			Reporter.log("Opened IE Browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(properties.readProperty("url"));
 	    return driver;
	}
	
	public  void closeBrowser(){
		driver.quit();
	}
	
	public  void takeScreenShot(){
		final byte[] screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			getScenario().embed(screenshotFile,"image/png");

	}
	
	public WebElement getVisibleElement(By xpath){
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
		return element;	
	}
	public WebElement getVisibeltyOfElementLocated(By xpath){
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		return element;
	}
	public WebElement clickVisibleElement(By xpath){
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
		element.click();
		return element;	
	}
	
	public WebElement hoverOnElement(By xpath){
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
		Actions action= new Actions(driver);
		action.moveToElement(element).build().perform();
		return element;	
	}
	
	public List<WebElement> getElements(By xpath){
		 List<WebElement> elements=driver.findElements(xpath);
		 return elements;
			
	}
	
	public void applyImplicitWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public Boolean verifyElementIsDisplayed(By xpath){
		Boolean flag=false;
		try{
			flag=driver.findElement(xpath).isDisplayed();
		}catch(Exception e){
			flag=false;
		}
		return flag;	
	}
	public void scrollToElelemt(By xpath){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(xpath));
	}

}
