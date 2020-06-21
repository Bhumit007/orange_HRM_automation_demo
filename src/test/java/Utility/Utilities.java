package Utility;

import OrangeHRMTest.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities extends BaseTest {

    private static final int explicitWaitDefault = 180;
    private static Utilities instance = null;
    Faker faker=new Faker();
    public static synchronized Utilities getUtilities() {
        if (instance == null) {
            instance = new Utilities();
        }
        return instance;
    }

    public String getDateTime() {

        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        // get current date time with Date()
        Date date = new Date();

        // Now format the date
        String currentDate = dateFormat.format(date);

        String newCurrentDate = currentDate.replace('/', '-');
        return newCurrentDate;

    }

    /**
     * Send key
     * @param element
     * @param value
     */
    public void sendKey(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    /**
     * Wait for element visible
     * @param webElement
     * @param driver
     * @return
     */
    public boolean waitForVisibilityOfElement(WebElement webElement, WebDriver driver) {
        long timeOutSecond = 60;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutSecond);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait for element click
     * @param element
     * @param driver
     */
    public void waitForElementTobeClickable(final WebElement element, WebDriver driver) {
        try {
            new WebDriverWait(driver, explicitWaitDefault)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Can not wait till element click");
        }
    }

    /**
     * File Upload (enter element and file path)
     * @param element
     * @param file_upload
     */
    public void uploadFile(WebElement element,String file_upload){
        element.sendKeys(System.getProperty("user.dir")+file_upload);
    }

    /**
     * get Fake Name
     */
    public String getFakeName(){
       return faker.name().firstName();
    }

    /**
     * get Fake number
     * @param element
     */
    public void  getFakeNum(WebElement element){
        int licenceNum=faker.number().numberBetween(111111111,999999999);
        String licenceNumber=Integer.toString(licenceNum);
        element.sendKeys(licenceNumber);
    }
    /**
     * click on button
     */
    public void clickOnElement(WebElement element,WebDriver driver) {
        waitForVisibilityOfElement(element,driver);
        waitForElementTobeClickable(element,driver);
        element.click();
    }

    /**
     * JavaScript Element Click
     * @param element
     */
    public void JSClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Click using action button.
     * @param element
     */
    public void ActionClassClick(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    /**
     * Select from DropDown
     * @param element
     * @param value
     */
    public void selectFromDropDown(WebElement element, String value){
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(value);
    }

}
