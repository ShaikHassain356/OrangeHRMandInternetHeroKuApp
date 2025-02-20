package PageObjectClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class contextmenu extends BaseClass{


    public contextmenu(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "(//div[@id='hot-spot'])[1]")
    WebElement contextmenubox;

    public void rightclickcontextmenu()
    {
        Actions act=new Actions(driver);

        act.contextClick(contextmenubox).build().perform();
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
}
