package PageObjectClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Keypress extends BaseClass{
    public Keypress(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='target']")
    WebElement keypressbox;

    @FindBy(xpath = "//p[@id='result']")
    WebElement textafterkeypress;

    public String keypressactions(String keys) throws InterruptedException {
        Actions actions=new Actions(driver);
        Thread.sleep(3000);
        keypressbox.click();

        switch (keys.toLowerCase().trim())
        {
            case "enter":actions.sendKeys(Keys.ENTER).build().perform();break;
            case "arrowup":actions.sendKeys(Keys.UP).build().perform();break;
            case "arrowdown":actions.sendKeys(Keys.DOWN).build().perform();break;
            case "arrowright":actions.sendKeys(Keys.RIGHT).build().perform();break;
            case "arrowleft":actions.sendKeys(Keys.LEFT).build().perform();break;
            default:
                System.out.println("You have entered the wrong key");
        }

        String keypresstext= textafterkeypress.getText();
        return keypresstext;
    }

}
