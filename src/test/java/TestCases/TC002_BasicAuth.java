package TestCases;

import PageObjectClasses.BasicAuth;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_BasicAuth extends BaseTest {

    @Test
    public void checkingbasicauth() throws InterruptedException {
        try {


            heroku_homepage hrh = new heroku_homepage(driver);
            hrh.clickbasicauth();
            Thread.sleep(3000);

            BasicAuth ba = new BasicAuth(driver);
            Thread.sleep(5000);
            ba.sendingcreds(p.getProperty("un"), p.getProperty("pw"));
            Thread.sleep(5000);


            String actualtext = ba.fetchtext();
            System.out.println(actualtext);
            if (actualtext.equals("Congratulations! You must have the proper credentials.")) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }
        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            Assert.fail();
        }

    }
}
