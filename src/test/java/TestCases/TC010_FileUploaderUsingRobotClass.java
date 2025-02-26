package TestCases;

import PageObjectClasses.FileUploader;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC010_FileUploaderUsingRobotClass extends BaseTest {

    @Test
    public void handlingfileuploaderusingrobotclass()
    {
        try {
            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickfileupload();

            FileUploader fu=new FileUploader(driver);
            fu.draganddropusingrobot("C:\\Users\\Hassain\\Downloads\\sample3.txt");
            Thread.sleep(10000);

            fu.clickingupload();


            String actualtext= fu.fetchingafterupload();
            System.out.println(actualtext);
            if (actualtext.equals("sample3.txt"))
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
