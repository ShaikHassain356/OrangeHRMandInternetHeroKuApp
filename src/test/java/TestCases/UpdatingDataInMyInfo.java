package TestCases;

import PageObjectClasses.HomePage;
import PageObjectClasses.LoginPage;
import PageObjectClasses.MyInfoPage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatingDataInMyInfo extends BaseTest {

    @Test
    public void updatinginfo() throws InterruptedException {
        try {
            LoginPage lp = new LoginPage(driver);

            lp.passingusername(p.getProperty("email"));
            Thread.sleep(3000);
            lp.passingpassword(p.getProperty("password"));
            Thread.sleep(3000);
            lp.clicklogin();
            Thread.sleep(3000);

            HomePage hp = new HomePage(driver);
            hp.searchmyinfo();
            hp.clickmyinfo();

            MyInfoPage mip = new MyInfoPage(driver);
            mip.passingFN(p.getProperty("FName"));
            Thread.sleep(3000);
            mip.passingMN(p.getProperty("MName"));
            Thread.sleep(3000);
            mip.passingLN(p.getProperty("LName"));
            Thread.sleep(3000);
            mip.passingDMPid(p.getProperty("EMPID"));
            Thread.sleep(3000);
            mip.passinglicenseexpiry(p.getProperty("Lexpiry"));
            Thread.sleep(3000);
            mip.selectingnationality();
            Thread.sleep(3000);
            mip.selectingmaritalstatus();
            Thread.sleep(3000);
            mip.selectingDOB("DateOfBirth");
            Thread.sleep(3000);
            mip.selectinggender();
            Thread.sleep(3000);
            mip.clickingonsave();


        } catch (Exception e) {
            System.out.println("Test got failed"+e.getMessage());
            Assert.fail();
        }
    }

}
