package PageObjectClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScroll extends BaseClass{
    public InfiniteScroll(WebDriver driver)
    {
        super(driver);
    }

    public void infinitescrolling() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;

        int maxscrolls=10;
        int scrollamount=500;
        int count=0;

        while (count<maxscrolls)
        {
            js.executeScript("window.scrollBy(0, arguments[0])",scrollamount);
            Thread.sleep(2000);
            count++;
        }
    }
}
