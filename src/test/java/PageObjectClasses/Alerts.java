package PageObjectClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Alerts extends BaseClass{

    public Alerts(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Click for JS Alert']")
    WebElement jsalert;

    @FindBy(xpath = "//p[@id='result']")
    WebElement textofjsalert;

    @FindBy(xpath = "//button[normalize-space()='Click for JS Confirm']")
    WebElement jsconfirm;

    @FindBy(xpath = "//p[@id='result']")
    WebElement textofjsconfirm;

    @FindBy(xpath = "//button[normalize-space()='Click for JS Prompt']")
    WebElement jsprompt;

    @FindBy(xpath = "(//p[@id='result'])[1]")
    WebElement jsprompttext;

    public String clickjsalert() throws InterruptedException {
        jsalert.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        String alerttext= textofjsalert.getText();
        return alerttext;

    }

    public String canceljsconfirm() throws InterruptedException {
        jsconfirm.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);

        String textjsconfirm= textofjsconfirm.getText();
        return textjsconfirm;
    }

    public String textforjsprompt() throws InterruptedException {
        jsprompt.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hi Hello Hassain");
        Thread.sleep(2000);
        alert.accept();

        String text= jsprompttext.getText();
        return text;


    }



}
