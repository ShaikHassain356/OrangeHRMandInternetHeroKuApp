package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuth extends BaseClass {

    public BasicAuth(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(text(),'Congratulations! You must have the proper credenti')]")
    WebElement afterbasicauth;

    public void sendingcreds(String UN,String PW)
    {
       String url=  "https://"+UN+":"+PW+"@the-internet.herokuapp.com/basic_auth";
       driver.get(url);

    }

    public String fetchtext()
    {
        String text= afterbasicauth.getText();
        return text;
    }
}
