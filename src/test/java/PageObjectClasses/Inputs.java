package PageObjectClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Inputs extends BaseClass{
    public Inputs(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='number']")
    WebElement inputbox;

    public String fetchingtextbox()
    {
        String text= inputbox.getAttribute("value");
        return text;
    }


    public void clickingupward()
    {
        Actions act=new Actions(driver);
        act.sendKeys(inputbox,Keys.ARROW_UP).build().perform();
    }

    public void clcikdownward()
    {
        Actions act=new Actions(driver);
        act.sendKeys(inputbox,Keys.ARROW_DOWN).build().perform();
    }
}
