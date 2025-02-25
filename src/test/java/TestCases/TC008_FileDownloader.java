package TestCases;

import PageObjectClasses.FileDownloader;
import PageObjectClasses.heroku_homepage;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC008_FileDownloader extends BaseTest {
    @Test
    public void handlingfiledownloader()
    {
        try {

            heroku_homepage hrp=new heroku_homepage(driver);
            hrp.clickfiledownload();

            Thread.sleep(3000);

            FileDownloader fd=new FileDownloader(driver);
            fd.capturingalllinksandclick("sample3.txt");

            String downloadpath="C:\\Users\\Hassain\\Downloads";
            String filename="sample3.txt";

            Thread.sleep(10000);

            boolean downloadtstaus= fd.isFileDownloaded(downloadpath,filename);
            if (downloadtstaus==true)
            {
                System.out.println("file downloaded successfully");
            }
            else {
                System.out.println("file not downloaded");
            }

            Thread.sleep(5000);



        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
