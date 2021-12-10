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
import utilities.ReadConfigFiles;
import utilities.SQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalMortgageParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalMortgageParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("---------------Test Name: Calculate Monthly Payment---------------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test
    public void calculateMonthlyPayment() {
        try {
            ResultSet rs = SQLConnector.readData("SELECT * FROM monthly_payment");
            while(rs.next()) {
                new NavigationBar(driver)
                        .navigateToHome()
                        .typeHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickDownPaymentInDollar()
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTerm(rs.getString("loanterm"))
                        .selectMonth("Dec")
                        .typeYear("2021")
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePmi(rs.getString("pmi"))
                        .typeHomeOwnerInsurance(rs.getString("homeownerinsurance"))
                        .typeMonthlyHoa(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefi(rs.getString("buyorrefi"))
                        .clickCalculateButton()
                        .validateMonthlyPayment(rs.getString("totalmonthlypayment"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @AfterMethod
    public void quitBrowser() {
        LOGGER.info("----------End Test Case---------");
        ActOn.browser(driver).closeBrowser();
    }
}
