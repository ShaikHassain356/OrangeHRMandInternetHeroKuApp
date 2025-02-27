package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Hovers extends BaseClass{
    public Hovers(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='row']//div[2]//img[1]")
    WebElement user;

    @FindBy(xpath = "//div[@class='row']//div[2]//div[1]//a[1]")
    WebElement viewprofile;

    public void hoveringuser()
    {
        Actions act=new Actions(driver);
        act.moveToElement(user).build().perform();
    }

    public void clickprofile()
    {
        viewprofile.click();
    }
}
