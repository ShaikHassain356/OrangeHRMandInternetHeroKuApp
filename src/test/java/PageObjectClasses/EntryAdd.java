package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdd extends BaseClass {

    public EntryAdd(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "(//p[normalize-space()='Close'])[1]")
    WebElement close;

    @FindBy(xpath = "(//a[normalize-space()='click here'])[1]")
    WebElement restartad;

    @FindBy(xpath = "//h3[normalize-space()='This is a modal window']")
    WebElement ad;

    public void clickclose()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        close.click();
    }

    public void clickrestartad()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        restartad.click();
    }

    public boolean adddisplayed()
    {
        boolean adstatus= ad.isDisplayed();
        return adstatus;
    }
}
