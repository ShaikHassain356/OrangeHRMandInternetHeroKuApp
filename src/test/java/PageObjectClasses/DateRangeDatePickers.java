package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DateRangeDatePickers extends BaseClass{
    public DateRangeDatePickers(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='start-date']")
    WebElement startdatedatepickers;

    @FindBy(xpath = "//input[@id='end-date']")
    WebElement enddatedatepicker;

    @FindBy(xpath = "//button[@class='submit-btn']")
    WebElement submit;


}
