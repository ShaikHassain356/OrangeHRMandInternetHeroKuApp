package TestCases;

import PageObjectClasses.Inputs;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC014_Inputs extends BaseTest {

    @Test
    public void handlinginputs()
    {
        try {

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickinputs();

            Thread.sleep(2000);
            Inputs in=new Inputs(driver);
            String actualtext= in.fetchingtextbox();
            System.out.println("Actual number in the box is "+actualtext);

            if (actualtext.isEmpty())
            {
                for (int i=0;i<10;i++)
                {
                    in.clickingupward();
                    Thread.sleep(1000);
                }
            }
            Thread.sleep(3000);
            String actualtext2= in.fetchingtextbox();
            System.out.println("After the values are passed "+actualtext2);

        } catch (Exception e) {
            System.out.println("Test failed due to error "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
