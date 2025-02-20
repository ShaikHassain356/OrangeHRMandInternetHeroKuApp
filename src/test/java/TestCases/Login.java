package TestCases;

import PageObjectClasses.BaseClass;
import PageObjectClasses.LoginPage;
import TestBase.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login extends BaseTest {


   @Test
   public void login() throws InterruptedException {
       LoginPage lp=new LoginPage(driver);

       lp.passingusername(p.getProperty("email"));
       Thread.sleep(3000);
       lp.passingpassword(p.getProperty("password"));
       Thread.sleep(3000);
       lp.clicklogin();
       Thread.sleep(3000);
   }
}
