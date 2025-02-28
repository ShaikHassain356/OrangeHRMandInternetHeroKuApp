package TestCases;

import PageObjectClasses.Alerts;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC015_Alerts extends BaseTest {

    @Test
    public void handlingalerts()
    {

        try {

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickalerts();

            Thread.sleep(2000);
            Alerts alerts=new Alerts(driver);
            String text= alerts.clickjsalert();
            System.out.println("Result after clicking on JS alert is: "+text);
            if (text.equals("You successfully clicked an alert"))
            {
                System.out.println("JS alert clicked successfully");
            }

            else {
                System.out.println("JS alert not clicked successfully");
            }

            String jscancel= alerts.canceljsconfirm();
            System.out.println("Text after canceling the JS alert is: "+jscancel);

            if (jscancel.equals("You clicked: Cancel"))
            {
                System.out.println("JS alert has been cancelled");
            }

            else {
                System.out.println("JS alert has not been cancelled");
            }

            String jsprompt= alerts.textforjsprompt();
            System.out.println("Text after sending data to JS prompt: "+jsprompt);

            if (jsprompt.equals("You entered: Hi Hello Hassain"))
            {
                System.out.println("Test passed");
            }
            else {
                System.out.println("Test failed");
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
