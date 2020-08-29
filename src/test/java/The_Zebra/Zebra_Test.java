package The_Zebra;

import Reusable_Library_Loggers.Reusable_Library_Loggers;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;

import static com.aventstack.extentreports.Status.INFO;

public class Zebra_Test {
    ExtentReports reporter = null;
    ExtentTest logger = null;
    WebDriver driver = null;

    @BeforeSuite
    public void environmentSetUp(){
        reporter = new ExtentReports("src\\main\\java\\HTML_Report\\ZebraAutomationReport.html",true);
        logger = reporter.startTest("The Zebra Test 1");
        logger.log(LogStatus.INFO, "");
    }//end of Before Suite

    @BeforeMethod
    public void BrowserSetUp() throws IOException, InterruptedException {
        driver = Reusable_Library_Loggers.setDriver();
        logger.log(LogStatus.INFO, "Automation Test Scenario has Started for Zebra");
        driver.navigate().to("https://www.thezebra.com/");
    }//end of Before Method

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void Test1() throws IOException, InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //Verifying the Zebra Title
        Reusable_Library_Loggers.verifyTitle(driver,"The Zebra: Instantly Compare Insurance Quotes",logger);
        //verifying the Top Left Zebra Logo
        Reusable_Library_Loggers.captureText(driver, "//*[@class='sr-only']","The Zebra logo",logger);
        boolean theZebraLogo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='sr-only' and contains(text(),'The Zebra')]"))).isDisplayed();
        System.out.println("The Element is displayed " + theZebraLogo);
        logger.log(LogStatus.INFO,"The Element is displayed " + theZebraLogo);
        //enter zipcode
        Reusable_Library_Loggers.userKeys(driver, "//*[@name='zipcode']", "07307", "Zipcode", logger);
        //click on Start
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='zipcode-submit-button']", "Start Button", logger);
        //hard coded waits are also needed for new page to load because explicit wait is fast
        Thread.sleep(3000);

        Reusable_Library_Loggers.verifyTitle(driver, "Compare Car Insurance Rates: Fast, Free, Simple | The Zebra", logger);
        //Clicking on Yes
        Reusable_Library_Loggers.click(driver, "//label[@data-cy='currently_insuredstart-Yes-Radiobutton']", "Yes Button", logger);
        /**
         following elements I used clicking by JavaScriptExecutor command because
         with regular click() I am getting element not interactable exception so using JSE
         helps to prevent that since it's more powerful
         **/
        //Clicking on Rent
        Reusable_Library_Loggers.clickByJs(driver,"//span[text()='I rent']", "Rent Radio Button", logger);
        //clicking on shopping for car radio button
        Reusable_Library_Loggers.clickByJs(driver,"//span[text()='I think I’m paying too much']", "Paying Too Much Radio Button", logger);
        //clicking on 'Save & Continue' button
        Reusable_Library_Loggers.clickByJs(driver,"//*[text()='Save & continue']","Save & Continue Button",logger);
        //hard coded waits are also needed for new page to load because explicit wait is fast
        Thread.sleep(3000);

        //enter street address
        Reusable_Library_Loggers.userKeys(driver,"//*[@id='garaging_addressInput']","400 Avenue J 11210","Street Address",logger);
        //click on suggestion link
        Reusable_Library_Loggers.click(driver,"//*[@data-cy='pac_container']","Drop Down Suggestion for Address",logger);
        //enter first name
        Reusable_Library_Loggers.userKeys(driver,"//*[@data-cy='first_name']","QA Tester","First Name",logger);
        //enter last name
        Reusable_Library_Loggers.userKeys(driver,"//*[@data-cy='last_name']","Last","Last Name",logger);
        //enter dob
        Reusable_Library_Loggers.userKeys(driver,"//*[@data-cy='date_of_birth']","06/05/1984","Date Of Birth",logger);
        //click on save & continue
        Reusable_Library_Loggers.clickByJs(driver,"//*[text()='Save & continue']","Save & Continue Button",logger);

        //enter vehicle year as 2020
        Reusable_Library_Loggers.userKeys(driver,"//input[@id='yearYear-0Input-0']","2020", "Vehicle Year", logger);
        //click on vehicle year drop down value
        Reusable_Library_Loggers.click(driver,"//*[@data-cy='year-0-2020']","Vehicle Year Dropdown Value", logger);
        //enter vehicle make as Acura
        Reusable_Library_Loggers.userKeys(driver,"//input[@id='makeMake-0Input-0']","Acura", "Vehicle Make", logger);
        //click on vehicle make drop down value
        Reusable_Library_Loggers.click(driver,"//*[@data-cy='make-0-Acura']","Vehicle Make Dropdown Value", logger);
        //enter vehicle model
        Reusable_Library_Loggers.userKeys(driver,"//input[@id='modelModel-0Input-0']","MDX", "Vehicle Model", logger);
        //click on vehicle make drop down value
        Reusable_Library_Loggers.click(driver,"//*[@data-cy='model-0-Mdx']","Vehicle Model Dropdown Value", logger);
        //enter vehicle trim
        Reusable_Library_Loggers.userKeys(driver,"//input[@id='submodelSubmodel-0Input-0']","4DR SUV", "Vehicle Sub-Model", logger);
        //click on vehicle trim drop down value
        Reusable_Library_Loggers.click(driver,"//*[@data-cy='submodel-0-4drSuv']","Vehicle Sub-Model Dropdown Value", logger);
        //click on save & continue
        Reusable_Library_Loggers.clickByJs(driver,"//*[text()='Save & continue']","Save & Continue Button",logger);

        //clicking Own - Making Payments
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='ownership-0-Own-MakingPayments-Radiobutton']", "Ownership", logger);
        //clicking on Personal/Commuting
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='primary_use-0-Personal/Commuting-Radiobutton']", "Primary Use", logger);
        //enter miles
        Reusable_Library_Loggers.userKeys(driver, "//*[@id='miles-input-0']", "12000", "Miles", logger);
        //click on save & continue
        Reusable_Library_Loggers.clickByJs(driver,"//*[text()='Save & continue']","Save & Continue Button",logger);

        //click on Gender
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='gender-0-Male-Radiobutton']", "Male Gender", logger);
        //click on Marital Status
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='marital_status-0-Married-Radiobutton']", "Married", logger);
        //click on credit score
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='credit_score-0-Excellent(720+)-Radiobutton']", "720+", logger);
        //click on Education level
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='education-0-HighSchoolDiploma/Ged-Radiobutton']", "High School", logger);
        //click on continuously insured
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='insured_length-0-MoreThan3Years-Radiobutton']", "More than 3 years", logger);
        //click on current insurance company drop down value
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='current_carrier-Geico']", "Geico", logger);
        //click on No
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='violations-0-No-Radiobutton']", "No", logger);
        //enter e-mail
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='email']","johnbrown@gmail.com", "Email", logger);

        //enter spouse first name
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='first_name']", "jennifer", "Spouse First Name", logger);
        //enter spouse last name
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='last_name']", "smith", "Spouse Last Name", logger);
        //enter spouse birthday
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='date_of_birth']", "04011986", "", logger);
        //enter spouse gender
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='gender-1-Female-Radiobutton']", "Spouse Gender", logger);

        //click show my quotes
        Reusable_Library_Loggers.clickByJs(driver, "//*[@data-cy='show_my_quotes']",  "See My Quotes", logger);
        //capture Text "Choose the quote that’s best for you!"
        Reusable_Library_Loggers.captureText(driver, "//*[@class='pb-3']", "Choose the Quote", logger);



    }//end of @Test

    @AfterMethod
    public void endTest(){
        logger.log(LogStatus.INFO, "Automation Test Scenario has Ended");
    }//end of After Method

    @AfterSuite
    public void closeBrowser(){
        reporter.flush();

    }//end of After Suite
}

