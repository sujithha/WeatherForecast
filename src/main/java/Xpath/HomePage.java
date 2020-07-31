package Xpath;

import org.openqa.selenium.By;

public interface HomePage {
    public By moreOption=By.xpath("//*[@id='h_sub_menu']");
    public By weather=By.xpath("//a[contains(text(),'WEATHER')]");
    public By noThanksPopup=By.xpath("//a[contains(text(),'No Thanks')]");

}
