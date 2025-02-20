package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class heroku_homepage extends BaseClass {

    public heroku_homepage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Add/Remove Elements']")
    WebElement addorremoveelement;

    @FindBy(xpath = "(//a[normalize-space()='Basic Auth'])[1]")
    WebElement basicauth;

    @FindBy(xpath = "//a[normalize-space()='Context Menu']")
    WebElement contextmenu;

    @FindBy(xpath = "//a[normalize-space()='Drag and Drop']")
    WebElement draganddrop;

    public void clickaddorremoveelement()
    {
        addorremoveelement.click();
    }

    public void clickbasicauth()
    {
        basicauth.click();
    }

    public void clickcontextmenu()
    {
        contextmenu.click();
    }

    public void clickdraganddrop()
    {
        draganddrop.click();
    }


}
