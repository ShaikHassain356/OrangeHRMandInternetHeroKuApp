package TestCases;

import PageObjectClasses.EntryAdd;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class TC006_EntryAdd extends BaseTest {

    @Test
    public void entryaddhandling()
    {
        logger.info("Test started");
        try {
            logger.info("clicking on entry add");
            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickentryadd();

            logger.info("clicking on close button");
            EntryAdd ed=new EntryAdd(driver);
            Thread.sleep(5000);
            ed.clickclose();
            Thread.sleep(5000);

            for (int i=0;i<=10;i++)
            {
                ed.clickrestartad();
                Thread.sleep(3000);
                if (ed.adddisplayed())
                {
                    break;
                }
            }
            Thread.sleep(5000);
            ed.clickclose();
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
