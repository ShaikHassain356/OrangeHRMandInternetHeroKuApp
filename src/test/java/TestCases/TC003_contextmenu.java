package TestCases;

import PageObjectClasses.contextmenu;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_contextmenu extends BaseTest {

    @Test
    public void contextmenuclicking()
    {
        try {

            heroku_homepage hmp = new heroku_homepage(driver);
            hmp.clickcontextmenu();
            Thread.sleep(4000);

            contextmenu cmu=new contextmenu(driver);
            cmu.rightclickcontextmenu();
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            Assert.fail();
        }
    }
}
