package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
    WebElement MyInfo;

    public void searchmyinfo()
    {
        search.sendKeys("My Info");
    }

    public void clickmyinfo()
    {
        MyInfo.click();
    }


}
