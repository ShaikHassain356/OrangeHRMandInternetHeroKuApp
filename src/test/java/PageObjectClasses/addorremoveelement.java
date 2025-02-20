package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addorremoveelement extends BaseClass {
    public addorremoveelement(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add Element']")
    WebElement addelement;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    WebElement deleteelement;

    public void clickaddelement()
    {
        addelement.click();
    }

    public void clickdeleteelement()
    {
        deleteelement.click();
    }
}
