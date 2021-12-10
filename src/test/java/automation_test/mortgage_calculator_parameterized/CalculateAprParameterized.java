package automation_test.mortgage_calculator_parameterized;

import comman_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import parameters.DataProviderClass;
import utilities.ReadConfigFiles;

public class CalculateAprParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateAprParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("---------------Test Name: Calculate Real Apr Rate---------------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test(dataProvider = "RealAprRates", dataProviderClass = DataProviderClass.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String expectedAprRate) {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice(homePrice)
                .typeDownPayment(downPayment)
                .selectDownPaymentInDollar()
                .typeIntrestRate(interestRate)
                .clickCalculateButton()
                .validateAprRate(expectedAprRate);
    }

    @AfterMethod
    public void quitBrowser() {
        LOGGER.info("----------End Test Case---------");
        ActOn.browser(driver).closeBrowser();
    }
}
