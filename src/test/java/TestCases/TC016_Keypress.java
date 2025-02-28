package TestCases;

import PageObjectClasses.Keypress;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC016_Keypress extends BaseTest {

    @Test
    public void keypresshandling()
    {
        try {

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickkeypress();

            Thread.sleep(3000);
            Keypress kp=new Keypress(driver);
            String text= kp.keypressactions(p.getProperty("key"));

            System.out.println("After passing the key it pressed: "+text);
            if (text.equals("You entered: UP"))
            {
                System.out.println("Test passed");
            }
            else {
                System.out.println("Test failed");
            }
            Thread.sleep(3000);


        } catch (Exception e) {
            System.out.println("Test failed due to error: "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
