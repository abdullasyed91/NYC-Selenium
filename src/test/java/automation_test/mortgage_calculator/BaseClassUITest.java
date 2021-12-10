package automation_test.mortgage_calculator;

import comman_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;


public class BaseClassUITest {
    public WebDriver driver;
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    String testCaseName = String.format("-----------Test: %s-------------", this.getClass().getName());
    String endTestCase = String.format("-----------Test End: %s------------", this.getClass().getName());

    @BeforeClass
    public void addThread() {
        ThreadContext.put("threadName", this.getClass().getName());
        driver = DriverFactory.getInstance().getDriver();
    }

    @BeforeMethod
    public void openBrowser() {
        LOGGER.info(testCaseName);
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @AfterMethod
    public void quitBrowser() {
        LOGGER.info(endTestCase);
        ActOn.browser(driver).closeBrowser();
    }
}


//    @BeforeMethod
//    public void browserInitialization() {
//        LOGGER.info(testCaseName);
//        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");

//    @AfterMethod
//    public void quitBrowser() {
//        DriverFactory.getInstance().removerDrive();
//        LOGGER.info(endTestCase);
//

//