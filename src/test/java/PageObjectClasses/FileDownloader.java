package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class FileDownloader extends BaseClass {
    public FileDownloader(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public void capturingalllinksandclick(String requireddwnld)
    {
        for (WebElement link:links)
        {
            String actualtext= link.getText();
            System.out.println(actualtext);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            if (actualtext.equals(requireddwnld) && link.getAttribute("href").contains(requireddwnld)) {
                link.click();
                return;
            }
            }
        }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File file = new File(downloadPath + File.separator + fileName);
        return file.exists(); //Returns true if the file is found
    }
    }




