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

    @FindBy(xpath = "//a[normalize-space()='Dynamic Controls']")
    WebElement dynamiccontrols;

    @FindBy(xpath = "//a[normalize-space()='Entry Ad']")
    WebElement entryadd;

    @FindBy(xpath = "//a[normalize-space()='Exit Intent']")
    WebElement exitintent;

    @FindBy(xpath = "//a[normalize-space()='File Download']")
    WebElement filedownload;

    @FindBy(xpath = "//a[normalize-space()='File Upload']")
    WebElement fileupload;

    @FindBy(xpath = "//a[normalize-space()='Horizontal Slider']")
    WebElement horizontalslider;

    @FindBy(xpath = "//a[normalize-space()='Hovers']")
    WebElement hovers;

    @FindBy(xpath = "//a[normalize-space()='Infinite Scroll']")
    WebElement infinitescroll;

    @FindBy(xpath = "//a[normalize-space()='Inputs']")
    WebElement inputs;

    @FindBy(xpath = "//a[normalize-space()='JavaScript Alerts']")
    WebElement alerts;

    @FindBy(xpath = "//a[normalize-space()='Key Presses']")
    WebElement keypress;

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

    public void clickdynamiccontrols()
    {
        dynamiccontrols.click();
    }

    public void clickentryadd()
    {
        entryadd.click();
    }

    public void clickexitintent()
    {
        exitintent.click();
    }

    public void clickfiledownload()
    {
        filedownload.click();
    }

    public void clickfileupload()
    {
        fileupload.click();
    }

    public void clickhorizontalslider()
    {
        horizontalslider.click();
    }

    public void clickhover(){
        hovers.click();
    }

    public void clickinfinitescroll()
    {
        infinitescroll.click();
    }

    public void clickinputs()
    {
        inputs.click();
    }

    public void clickalerts()
    {
        alerts.click();
    }

    public void clickkeypress()
    {
        keypress.click();
    }

}
