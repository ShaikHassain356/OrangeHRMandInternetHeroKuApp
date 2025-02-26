package TestCases;

import PageObjectClasses.HorizontalSlider;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC011_HorizontalSlider extends BaseTest {
    @Test
    public void handlingslider()
    {
        try {

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickhorizontalslider();

            Thread.sleep(3000);
            HorizontalSlider hs=new HorizontalSlider(driver);
            hs.slidingslider();
            Thread.sleep(3000);

            String currentsliderrange= hs.fetchsliderrange();
            System.out.println(currentsliderrange);

        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
