package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class draganddrop extends BaseClass {

        public draganddrop(WebDriver driver)
        {
            super(driver);
        }

        @FindBy(xpath = "(//div[@id='column-a'])[1]")
        WebElement draggable;

        @FindBy(xpath = "(//div[@id='column-b'])[1]")
        WebElement targetlocation;

        @FindBy(tagName = "header")
        WebElement header;

        public void actiondraganddrop()
        {
            Actions act=new Actions(driver);
            act.dragAndDrop(draggable,targetlocation).build().perform();
        }

        public String fetchfirstboxattribute()
        {
           /*String text= draggable.getText();
           return text;*/
            String text= header.getText();
            return text;
        }
    }

