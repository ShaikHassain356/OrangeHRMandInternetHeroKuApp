package TestCases;

import PageObjectClasses.ExitIntent;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC007_ExitIntent extends BaseTest {

    @Test
    public void handlingexitintent()
    {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickexitintent();
            Thread.sleep(3000);

            ExitIntent ei=new ExitIntent(driver);
            ei.pagezoomin();
            Thread.sleep(20000);

            if (ei.adstatus())
            {
                System.out.println("Ad is displayed");
                Thread.sleep(3000);
                ei.clickclose();
            }


        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
