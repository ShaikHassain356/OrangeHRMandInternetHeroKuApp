package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploader extends BaseClass{

    public FileUploader(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement choosefile;

    @FindBy(xpath = "(//input[@id='file-submit'])[1]")
    WebElement upload;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    WebElement afterfileupload;

    @FindBy(xpath = "(//div[@id='drag-drop-upload'])[1]")
    WebElement uploadbox;

    public void choosingfile(String location)
    {
        choosefile.sendKeys(location);
    }

    public void clickingupload()
    {
        upload.click();
    }

    public String fetchingafterupload()
    {
        String text= afterfileupload.getText();
        return text;
    }

    public void draganddropusingrobot(String filepath) throws AWTException {
        StringSelection selection=new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
        Robot robot=new Robot();
        robot.delay(10000);

        Actions actions = new Actions(driver);
        actions.clickAndHold(uploadbox).pause(1000).release().build().perform();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
