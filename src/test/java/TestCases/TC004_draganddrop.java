package TestCases;

import PageObjectClasses.draganddrop;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_draganddrop extends BaseTest {

    @Test
    public void draganddropaction()
    {

        try {

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickdraganddrop();
            Thread.sleep(3000);

            draganddrop drp=new draganddrop(driver);
            drp.actiondraganddrop();
            Thread.sleep(4000);

            String actualtext= drp.fetchfirstboxattribute();
            System.out.println(actualtext);

            if (actualtext.equals("B"))
            {
                System.out.println("drag and drop is successful");
            }

            else {
                System.out.println("drag and drop failed");
            }

        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error " +e.getMessage());
            Assert.fail();
        }
    }
}
