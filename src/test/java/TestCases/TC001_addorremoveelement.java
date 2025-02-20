package TestCases;

import PageObjectClasses.addorremoveelement;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC001_addorremoveelement extends BaseTest {

    @Test
    public void addorremoveelement()
    {
        try {


            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            logger.info("Starting Test");
            heroku_homepage hkp= new heroku_homepage(driver);
            logger.info("clicking on add or remove element");
            hkp.clickaddorremoveelement();
            addorremoveelement ade=new addorremoveelement(driver);
            logger.info("clicking on add element");
            Thread.sleep(3000);
            for (int i=0;i<=5;i++)
            {
                ade.clickaddelement();

            }

            for (int j=0;j<=5;j++)
            {
                ade.clickdeleteelement();
                Thread.sleep(2000);
            }

        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
        }
    }
}
