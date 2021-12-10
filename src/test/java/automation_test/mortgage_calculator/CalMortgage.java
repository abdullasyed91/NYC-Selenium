package automation_test.mortgage_calculator;

import org.testng.annotations.Test;
import page_objects.NavigationBar;


public class CalMortgage extends BaseClassUITest {

    @Test
    public void calculateMonthlyPayment() {
        new NavigationBar(driver)
                .navigateToHome()
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickDownPaymentInDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTerm("30")
                .selectMonth("Dec")
                .typeYear("2021")
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHomeOwnerInsurance("1000")
                .typeMonthlyHoa("100")
                .selectLoanType("FHA")
                .selectBuyOrRefi("Buy")
                .clickCalculateButton()
                .validateMonthlyPayment("$1,611.85");
    }
}
