package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginbutton;


    public void passingusername(String email)
    {
        username.sendKeys(email);
    }

    public void passingpassword(String pass)
    {
        password.sendKeys(pass);
    }

    public void clicklogin()
    {
        loginbutton.click();
    }
}
