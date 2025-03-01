package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginatedWebtable extends BaseClass{
    public PaginatedWebtable(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='productTable']")
    WebElement table;


    public void fetchdatafromtable() throws InterruptedException {
        for (int p=1;p<=4;p++)
        {
            if (p>1)
            {
                WebElement page= driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li["+p+"]"));
                Thread.sleep(3000);
                page.click();
            }
            int rows= driver.findElements(By.xpath("//table[@id=\"productTable\"]//tbody//tr")).size();
            for (int r=1;r<=rows;r++)
            {

                String name= driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[2]")).getText();
                System.out.println("Name of the Product is: "+name+"\n");
            }
        }
    }
}
