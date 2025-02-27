package TestCases;

import PageObjectClasses.InfiniteScroll;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC013_InfiniteScroll extends BaseTest {

    @Test
    public void handlinginfinitescroll()
    {
        try {

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickinfinitescroll();

            Thread.sleep(3000);

            InfiniteScroll is=new InfiniteScroll(driver);
            is.infinitescrolling();

        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
