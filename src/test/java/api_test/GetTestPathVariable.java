package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



public class GetTestPathVariable extends BaseClassAPITest {

    @Test
    public void getSingleUser() {
        LOGGER.info(testCaseName);

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        String id = "7";
        Response response = httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(),200);

        JsonPath jsonPath = response.jsonPath();
        String actualEmail = jsonPath.getString("data.email");

        String expectedEmailId = "michael.lawson@reqres.in";
        Assert.assertEquals(actualEmail, expectedEmailId);

        LOGGER.info(endTestCase);
    }

    @Test
    public void attemptToGetAUserWithInvalidId() {
        LOGGER.info(testCaseName);

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        String id = "23";
        Response response = httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(),404);

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get().toString(), "{}");

        LOGGER.info(endTestCase);
    }
}
