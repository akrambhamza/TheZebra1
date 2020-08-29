package Reusable_Library_Loggers;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

import static com.relevantcodes.extentreports.LogStatus.INFO;
import static org.openqa.selenium.Keys.ENTER;

public class Reusable_Library_Loggers {
    static int timeout=6;

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver wDriver,ExtentTest logger,String imageName) {
        try {
            String fileName = imageName + ".png";
            String os = System.getProperty("os.name").toLowerCase();
            String directory = null;
            String snPath = null;
            if (os.contains("win")) {
                directory = "src//main//java//HTML_Report//Screenshots//";
                snPath = "Screenshots//";
            } else {
                directory = "var/lib/jenkins/workspace/Screenshots/";
                snPath = "Screenshots/";
            }
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of screenshot method

    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws InterruptedException, IOException {
        WebDriver driver = null;
        //kill all chrome driver instance
        Thread.sleep(1100);
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1000);
        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver85.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //IF YOU WANT TO RUN HEADLESS CHROME
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("start-maximized","incognito");
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }//end of set driver method

    //method to compare expected with actual title
    public static void verifyTitle(WebDriver driver,String expectedTitle,ExtentTest logger) throws IOException {
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Expected title matches with Actual " + expectedTitle);
            logger.log(LogStatus.PASS,"Expected title matches with Actual " + expectedTitle);
        } else {
            System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Expected doesn't match actual title. Actual title is " + actualTitle);
            getScreenShot(driver,logger,"Title Verification");
        }
    }//end of verify title method

    public static void userInputEnter(WebDriver driver, String locator, String userValue, String elementName, ExtentTest logger) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            System.out.println("Entering value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
            element.sendKeys(ENTER);
        }catch (Exception err) {
            System.out.println("Unable to enter value on element " + elementName + " --" + err);
            logger.log(LogStatus.FAIL,"Unable to enter value on element " + elementName + " --" + err);
            getScreenShot(driver,logger,elementName);
        }
    }//end of sendKeys metho

        //method to enter user input on send keys
        public static void userKeys(WebDriver driver,String locator, String userInput, String elementName,ExtentTest logger) throws IOException {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Entering a value on " + elementName);
                logger.log(LogStatus.INFO,"Entering a value " + userInput + " on " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                Thread.sleep(900);
                //using keys.control to delete any auto populated data on a input field
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                element.sendKeys(userInput);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to enter value on " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of sendkeys method

        //method to click on an element
        public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger) throws IOException {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Clicking on " + elementName);
                logger.log(LogStatus.INFO,"Clicking on " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click on " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        public static void clickByJs(WebDriver driver, String locator, String elementName, ExtentTest logger) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            Thread.sleep(1500);
            try{
                System.out.println("Clicking by JSE on  " + elementName);
                logger.log(LogStatus.INFO,"Clicking by JSE on " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                js.executeScript("arguments[0].click();", element);
            } catch (Exception e) {
                System.out.println("Unable to click by JSE on " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to click by JSE on " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click by js method

    //method to return text from an element
    public static String captureText(WebDriver driver,String locator,String elementName,ExtentTest logger) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            System.out.println("Capturing a text from element " + elementName);
            logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My Text result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
        return result;
    }//end of captureText me

    public static void scroll(WebDriver driver,ExtentTest loggers,  int x, int y) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + x + "," + y + ")");
            loggers.log(LogStatus.INFO, "Scrolling");
        }catch (Exception err){
            System.out.println("Unable to Scroll");
            loggers.log(LogStatus.FAIL, "Unable to Scroll");
        }
    }
    public static void scrollToElement(WebDriver driver,String locator, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            js.executeScript("arguments[0].scrollIntoView();", element);
            logger.log(LogStatus.INFO, "Scrolling to " + elementName);
        } catch (Exception err) {
            System.out.println("Unable to Scroll to " + elementName);
            logger.log(LogStatus.FAIL, "Unable to Scroll to " + elementName);
            getScreenShot(driver, logger, elementName);
        }
    }

}//end of class