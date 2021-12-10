package parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue() {
        return new Object[][] {
                {"Rifat"},
                {"Muhammed"},
                {"Ashraf"},
        };
    }

    @DataProvider(name = "MultipleValues")
    public Object[][] storeMultipleValues() {
        return new Object[][] {
                {"Rifat", "Florida", 33018},
                {"Farid", "New York", 11433},
                {"Ashraf", "Texas", 12345}
        };
    }

    @DataProvider(name = "RealAprRates")
    public Object[][] storeRealAprRatesData() {
        return new Object[][] {
                {"200000", "15000", "3", "3.130%"}
        };
    }

    //@Test(dataProvider = "SingleValue")
    public void readSingleValue(String name) {
        System.out.println("[Single Column Value] Name is: " + name);
    }

    @Test(dataProvider = "MultipleValues")
    public void readMultipleValues(String name, String state, int zipCode) {
        System.out.println("[Multiple column value] Name is: " + name);
        System.out.println("[Multiple column value] State is: " + state);
        System.out.println("[Multiple column value] Zip code is: " + zipCode);
    }
}
