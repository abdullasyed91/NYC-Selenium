package comman_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ElementAssertion {
    WebDriver driver;
    private By locator;

    public ElementAssertion(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public ElementAssertion elementIsDisplayed() {
        boolean displayed = driver.findElement(locator).isDisplayed();
        Assert.assertTrue(displayed, "The expected element does not exist");
        return this;
    }
}
