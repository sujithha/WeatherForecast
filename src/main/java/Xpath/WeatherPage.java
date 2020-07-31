package Xpath;

import org.openqa.selenium.By;

public interface WeatherPage {
    public String searchCheckBox="//input[@id='%s']";
    public String temperatureInDegree=" //div[@title='%s']//span[@class='tempRedText']";
    public By textWindow=By.xpath("//span[contains(text(),'Hyderabad')]");
    public String labels="//b[contains(text(),'%s')]";
    public By searchBox= By.xpath("//input[@id='searchBox']");
}
