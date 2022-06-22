package tests.regression;

import base.baseTest;
import data.TestData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class storeTests extends baseTest {
    TestData storeData = new TestData();
    String invalidId = storeData.invalidId;
    String nonExistingId = storeData.nonExistingId;

    @Test
    public void createOrderWithoutOrderDetailsShouldReturnError() {

        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body("{}").
                post("/store/order").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                statusCode(400).
                body("code", hasToString("400"));
    }

    @Test
    public void getOrderUsingInvalidIDShouldReturn400StatusCode() {
        given().
                spec(requestSpec).
                pathParam("orderId", invalidId).
                when().
                get("/store/order/{orderId}").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(400).
                body("code", hasToString("400"));
    }

    @Test
    public void deleteOrderWithInvalidOrderIDShouldReturn400() {

        given().
                spec(requestSpec).
                pathParam("orderId", nonExistingId).
                when().
                when().
                delete("/store/order/{orderId}").
                then().
                assertThat().
                statusCode(400).
                body("code", hasToString("400"));
    }
}
