package tests.regression;

import base.baseTest;
import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;


public class petTests extends baseTest {
    TestData pestData = new TestData();
    String invalidId = pestData.invalidId;
    String nonExistingId = pestData.nonExistingId;

    @Test
    public void deletePetWithInvalidIDShouldReturnStatusCode400() {
        given().
                spec(requestSpec).
                pathParam("petId", invalidId).
                when().
                delete("/pet/{petId}").
                then().
                assertThat().
                statusCode(400).
                body("code", hasToString("400"));
    }

    @Test
    public void requestByTagWithInvalidTagNameShouldReturn400StatusCode() {
        given().
                spec(requestSpec).
                queryParam("tags", invalidId).
                when().
                get("/pet/findByTags").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(400);
    }

    @Test
    public void requestByTagWithNoTagNameShouldReturnAppropriateErrorMessage() {
        String responseString = given().
                spec(requestSpec).
                queryParam("tags", "").
                when().
                get("/pet/findByTags").
                then().
                assertThat().
                statusCode(400).
                extract().
                asString();
        Assert.assertEquals(responseString, "No tags provided. Try again?");
    }

    @Test
    public void requestByNonExistingPetStatusTypeShouldReturnAppropriateErrorMessage() {
        given().
                spec(requestSpec).
                queryParam("status", invalidId).
                when().
                get("pet/findByStatus").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(400).
                body("code", hasToString("400")).
                body("message", containsString("Input error: query parameter `status value `xyz_` is not in the allowable values `[available, pending, sold]"));
    }

    @Test
    public void getPetByNonExistingIdShouldReturn404StatusCodeAppropriateErrorMessage() {
        String responseString = given().
                spec(requestSpec).
                pathParam("petId", nonExistingId).
                when().
                get("/pet/{petId}").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(404).
                extract().
                asString();
        Assert.assertEquals(responseString, "Pet not found");
    }

    @Test
    public void getPetByInvalidIdShouldReturn400StatusCode() {
        given().
                spec(requestSpec).
                pathParam("petId", invalidId).
                when().
                get("/pet/{petId}").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(400).
                body("code", hasToString("400"));
    }
}