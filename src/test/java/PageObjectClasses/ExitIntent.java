package PageObjectClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ExitIntent extends BaseClass {
    public ExitIntent(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//body")
    WebElement pagebody;

    @FindBy(xpath = "//p[normalize-space()='Close']")
    WebElement close;

    @FindBy(xpath = "//h3[normalize-space()='This is a modal window']")
    WebElement adwindow;

    public void pagezoomin()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='200%'");


    }

    public void clickclose()
    {
        close.click();
    }

    public boolean adstatus()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        boolean adstatuswin= adwindow.isDisplayed();
        return adstatuswin;
    }
}
