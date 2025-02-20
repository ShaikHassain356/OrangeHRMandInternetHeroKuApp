package TestCases;

import PageObjectClasses.DynamicControls;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC005_DynamicControls extends BaseTest {

    @Test
    public void handlingdynamiccontrols()
    {
        try {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

            logger.info("clicking on dynamic controls");

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickdynamiccontrols();

            DynamicControls dc=new DynamicControls(driver);
            dc.clickcheckbox();

            dc.clickremovecheckbox();
            String textcheckboxremoved= dc.gettextaftercheckboxremoved();
            System.out.println("text after checkbox removed is "+textcheckboxremoved);

            dc.addcheckboxagain();
            String textcheckboxadded= dc.gettextaftercheckboxadded();

            dc.clickingcheckboxafteradded();

            boolean fieldenabled= dc.validatingfieldstatus();
            boolean fieldenabled2= dc.validatingfieldstatus2();

            if (fieldenabled == false)
            {
                System.out.println("field is not enabled, enabling now");
                Thread.sleep(5000);
                dc.clickingonenablebutton();
            }

            String textafterenabled= dc.gettextafterfieldenabled();
            System.out.println("text after field is enabled "+textafterenabled);

            if (textafterenabled.equals("It's enabled!"))
            {
                dc.sendingdatainfield(p.getProperty("Hassain"));
            }

            dc.clickdisablebutton();

            String textfielddisabled= dc.gettextafterdisabled();

            System.out.println("text after field is disabled is "+textfielddisabled);





        }

        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            logger.debug("getting logs");
            Assert.fail();
        }
    }
}
