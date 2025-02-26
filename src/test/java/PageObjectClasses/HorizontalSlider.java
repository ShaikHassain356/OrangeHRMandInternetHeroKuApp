package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HorizontalSlider extends BaseClass{
    public HorizontalSlider(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@value='0']")
    WebElement slider;

    @FindBy(id = "range")
    WebElement rangeofslider;

    public void slidingslider()
    {
        Actions act=new Actions(driver);
        act.clickAndHold(slider).moveByOffset(10,0).release().build().perform();
    }

    public String fetchsliderrange()
    {
        String sliderrange= rangeofslider.getText();
        return sliderrange;
    }
}
