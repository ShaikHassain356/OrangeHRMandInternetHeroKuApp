package TestCases;

import PageObjectClasses.Hovers;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC012_Hovers extends BaseTest {
    @Test
    public void handlinghovers()
    {
        try {

            heroku_homepage hrp=new heroku_homepage(driver);

            hrp.clickhover();

            Thread.sleep(3000);
            Hovers h=new Hovers(driver);

            h.hoveringuser();

            Thread.sleep(3000);
            h.clickprofile();
            Thread.sleep(3000);

        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
