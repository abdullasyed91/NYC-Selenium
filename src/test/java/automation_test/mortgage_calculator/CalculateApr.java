package automation_test.mortgage_calculator;

import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalculateApr extends BaseClassUITest {

    @Test
    public void calculateRealApr() {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice("200000")
                .typeDownPayment("15000")
                .selectDownPaymentInDollar()
                .typeIntrestRate("3")
                .clickCalculateButton()
                .validateAprRate("3.130%");
    }
}
