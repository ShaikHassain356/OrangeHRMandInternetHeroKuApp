package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControls extends BaseClass {
    public DynamicControls(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//button[normalize-space()='Remove']")
    WebElement removecheckbox;

    @FindBy(xpath = "//p[@id='message']")
    WebElement textaftercheckboxremoved;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addcheckboxagain;

    @FindBy(xpath = "//p[@id='message']")
    WebElement textaftercheckboxadded;

    @FindBy(xpath = "//input[@id='checkbox']")
    WebElement checkboxonceagainadded;

    @FindBy(xpath = "//input[@type='text']")
    WebElement inputfield;

    @FindBy(xpath = "//button[normalize-space()='Enable']")
    WebElement enablebutton;

    @FindBy(xpath = "//p[@id='message']")
    WebElement textafterenabled;

    @FindBy(xpath = "//button[normalize-space()='Disable']")
    WebElement disablebutton;

    @FindBy(xpath = "//p[@id='message']")
    WebElement textafterdisabled;

    public void clickcheckbox()
    {
        checkbox.click();
    }

    public void clickremovecheckbox()
    {
        removecheckbox.click();
    }

    public String gettextaftercheckboxremoved()
    {
        String text= textaftercheckboxremoved.getText();
        return text;
    }

    public void addcheckboxagain()
    {
        addcheckboxagain.click();
    }

    public String gettextaftercheckboxadded()
    {
        String text2= textaftercheckboxadded.getText();
        return text2;
    }

    public void clickingcheckboxafteradded()
    {
        checkboxonceagainadded.click();
    }

    public boolean validatingfieldstatus()
    {
        boolean fieldstatus= inputfield.isEnabled();
        return fieldstatus;
    }

    public void sendingdatainfield(String fieldinput)
    {
        inputfield.sendKeys(fieldinput);
    }

    public boolean validatingfieldstatus2()
    {
        boolean fieldstatus2= inputfield.getAttribute("readonly")!=null;
        return fieldstatus2;
    }

    public void clickingonenablebutton()
    {
        enablebutton.click();
    }

    public String gettextafterfieldenabled()
    {
        String fieldtext= textafterenabled.getText();
        return fieldtext;
    }

    public void clickdisablebutton()
    {
        disablebutton.click();
    }

    public String gettextafterdisabled()
    {
        String textafterdisabledis= textafterdisabled.getText();
        return textafterdisabledis;
    }



}
