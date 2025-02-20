package PageObjectClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage extends BaseClass {
    public MyInfoPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middlename;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastname;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement empid;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
    WebElement licenseexpiry;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
    WebElement nationality;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
    WebElement maritalstatus;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/i[1]")
    WebElement DOB;

    @FindBy(xpath = "//label[normalize-space()='Female']")
    WebElement gender;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
    WebElement save;

    public void passingFN(String FN) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(firstname));

        // Ensure the field is editable
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('readonly')", field);
        js.executeScript("arguments[0].removeAttribute('disabled')", field);

        // **Step 1: Clear the field using JavaScript**
        js.executeScript("arguments[0].value = '';", field);


        // **Step 3: Verify if the field is actually empty**
        String fieldValue = field.getAttribute("value");
        System.out.println("Value after clear: '" + fieldValue + "'"); // Should print empty

        // **Step 4: If still not empty, use clear() method**
        if (!fieldValue.isEmpty()) {
            field.clear();
        }

        // **Step 5: Enter new text**
        field.sendKeys(FN);
    }






    public void passingMN(String MN)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(middlename));
        middlename.clear();
        middlename.sendKeys(MN);
    }

    public void passingLN(String LN)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastname));
        lastname.clear();
        lastname.sendKeys(LN);
    }

    public void passingDMPid(String EMPid)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(empid));
        element.clear();
        element.sendKeys(EMPid);
    }

    public void passinglicenseexpiry(String license)
    {
        licenseexpiry.clear();
        licenseexpiry.sendKeys(license);
    }

    public void selectingnationality()
    {
        Select nationalitydropdown=new Select(nationality);
        nationalitydropdown.selectByContainsVisibleText("American");
    }

    public void selectingmaritalstatus()
    {
        Select maritalstate=new Select(maritalstatus);
        maritalstate.selectByContainsVisibleText("Single");
    }

    public void selectingDOB(String DOB2)
    {
        DOB.clear();
        DOB.sendKeys(DOB2);
    }

    public void selectinggender()
    {
        gender.click();
    }

    public void clickingonsave()
    {
        save.click();
    }
}
