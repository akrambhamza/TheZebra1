package The_Zebra;

import Reusable_Library_Loggers.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import java.io.IOException;


public class theZebraHome extends Reusable_Library_Loggers {
    ExtentReports reporter = null;
    ExtentTest logger = null;
    WebDriver driver = null;

    @BeforeSuite
    public void environmentSetUp() {
        reporter = new com.relevantcodes.extentreports.ExtentReports("src\\main\\java\\HTML_Report\\ZebraAutomationReport.html",true);
        logger = reporter.startTest("The Zebra Test 1");
        logger.log(LogStatus.INFO, "Starting Test 1");

    }//end of Before Suite

    @BeforeMethod
    public void BrowserSetUp() throws IOException, InterruptedException {
        driver = Reusable_Library_Loggers.setDriver();
        logger.log(LogStatus.INFO, "Automation Test Scenario has Started for Zebra");
        driver.navigate().to("https://www.thezebra.com/");
    }//end of Before Method

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void test1() throws IOException, InterruptedException {
        //Verifying the Title
        Reusable_Library_Loggers.verifyTitle(driver, "The Zebra: Instantly Compare Insurance Quotes", logger);
        //verifying the Top Left Zebra Logo
        Reusable_Library_Loggers.captureText(driver, "//*[@class='sr-only']", "The Zebra logo", logger);
        boolean theZebraLogo = driver.findElement(By.xpath("//*[@class='sr-only']")).isDisplayed();
        System.out.println("The Element is displayed " + theZebraLogo);
        //Clicking on Home Insurance
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='homeowners-funnel-selection']",  "Home Insurance", logger );
        //Entering ZipCode
        Reusable_Library_Loggers.userKeys(driver, "//*[@class='form-control with-icon zipcode-text-input']", "78745", "Inputting Information on Zipcode", logger);
        //Clicking Start
        Reusable_Library_Loggers.click(driver, "//*[@class='btn btn-square btn-icon-right btn-arrow form-inline-submit-button']", "Clicking on Start Button", logger);
        Thread.sleep(2000);
        //Verifying the Title For Home Insurance
        Reusable_Library_Loggers.verifyTitle(driver,  "Compare Home Insurance Rates: Fast, Free, Simple | The Zebra", logger);
        //Verifying Text1
        Reusable_Library_Loggers.captureText(driver, "//*[@class='section-page-header section-page-appear-done section-page-enter-done']", "Fast and Simple", logger);
        //Verifying Text2
        Reusable_Library_Loggers.captureText(driver, "//*[@class='question-text']", "What Type of Residence", logger);
        //Verifying Text 3
        Reusable_Library_Loggers.captureText(driver, "//*[@class='question-byline']", "Choose the type of home you live in", logger);
        //Clicking Single family home
        Reusable_Library_Loggers.click(driver, "//*[@class='custom-control-description' and text()='Single family home']", "Single family home", logger);
        //Entering Address
        Reusable_Library_Loggers.userInputEnter(driver, "//*[@id='address1Input']", "2201 Amur Drive Austin TX USA", "House Address", logger);
        //Entering Unit Number
        Thread.sleep(500);
        Reusable_Library_Loggers.userInputEnter(driver, "//*[@id='address2-input']", "1", "Unit Number", logger);
        Thread.sleep(500);
        //Entering Zipcode
        Reusable_Library_Loggers.userInputEnter(driver, "//*[@id='zipcode-input']", "78745" ,"Zipcode", logger);
        //Clicking Yes, i Own it
        Reusable_Library_Loggers.click(driver, "//*[@class='custom-control-description' and text()='Yes, I already own it.']", "Single family home", logger);
        Thread.sleep(500);
        //Entering the Year house was Purchased
        Reusable_Library_Loggers.userKeys(driver, "//*[@id='purchase_date-input'][@class='form-control']", "102019",  "House Purchase Date", logger);
        Thread.sleep(5000);
        //Clicking on Save and Continue
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='btn_SaveAndContinue']", "Save and Continue", logger);
        //Entering What Year the House was Built
        Reusable_Library_Loggers.userKeys(driver, "//*[@id='year_built-input']", "1994", "House Built Year", logger);
        Thread.sleep(500);
        //Clicking Foundation Dropdown
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-foundation_type']", "Clicking Foundation Dropdown", logger);
        //Entering Foundation Type
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-foundation_type-BASEMENT']", "Clicking Foundation Type Basement", logger);
        Thread.sleep(500);
        // Clicking What Frame is your house made out of Dropdown
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-construction_type']", "Frame Type Dropdown", logger);
        //Entering Frame Type
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-construction_type-CONCRETE']", "Clicking Frame Type Concrete", logger);
        Thread.sleep(500);
        // Clicking How Many Stories Dropdown
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-number_of_stories']", "Clicking How Many Stories Dropdown", logger);
        //Entering How many Stories
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-number_of_stories-TWO']", "Clicking How many Stories 2", logger);
        Thread.sleep(500);
        //Clicking Heating System Dropdown
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-heat_type']", "Clicking Heating System Dropdown", logger);
        //Entering Heating System
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-heat_type-FORCED_AIR_CENTRAL']", "Clicking Heating System Forced Air Central", logger);
        Thread.sleep(500);
        //Clicking Roof Type Dropdown
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-roof_material']", "Clicking Roof Type Dropdown", logger);
        //Entering Roof Type
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='dropdown-roof_material-ASPHALT_COMPOSITION']", "Clicking Roof Type Asphalt Composition", logger);
        //Entering Last Time Roof was installed or Replaced
        Reusable_Library_Loggers.userInputEnter(driver, "//*[@data-cy='text-roof_improvement_year']", "2009", "Entering 2009 for Replace", logger);
        //Enter House Square Footage
        Reusable_Library_Loggers.userInputEnter(driver, "//*[@data-cy='text-square_footage']", "1250", "Entering House Square Footage", logger);
        //Entering Rebuild Cost
        Reusable_Library_Loggers.userInputEnter(driver, "//*[@data-cy='text-replacement_amount']", "75000", "Rebuild Cost", logger);
        Thread.sleep(500);
        //Clicking No for Flood Zone
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='radio-is_in_flood_zone-false']", "Flood Zone No ", logger);
        Thread.sleep(500);
        //Clicking Yes for House Near Fire Hydrant
        Reusable_Library_Loggers.click(driver, "//label[@data-cy='radio-is_fire_hydrant_available-YES']", "House Near Fire Hydrant Yes", logger);
        //Clicking 0-5 for House Near Fire House
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='radio-fire_station_proximity-ONE_TO_FIVE']", "House near Fire House 0-5", logger);
        //Clicking Save and Continue
        Reusable_Library_Loggers.click(driver, "//*[@data-cy='btn_SaveAndContinue']", "Save and Continue", logger);
        //Entering First Name
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='text-first_name']", "John", "First Name", logger);
        //Entering Last Name
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='text-last_name']", "Brown", "Last Name", logger);
        //Entering Date of Birth
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='text-date_of_birth']", "02081985", "Date of Birth", logger);
        //Entering Email
        Reusable_Library_Loggers.userKeys(driver, "//*[@data-cy='text-email']", "Johnbrown@gmail.com", "Email", logger);
        Thread.sleep(500);
        //Clicking See my Quotes
        Reusable_Library_Loggers.click(driver, "//*[@class='btn-rounded btn-continue btn btn-primary']", "See my Quotes", logger);
    }


    @AfterMethod
    public void endTest(){
        logger.log(LogStatus.INFO, "Automation Test Scenario has Ended");
    }//end of After Method

    @AfterSuite
    public void closeBrowser(){
        reporter.flush();
        driver.quit();
    }//end of After Suite
}
