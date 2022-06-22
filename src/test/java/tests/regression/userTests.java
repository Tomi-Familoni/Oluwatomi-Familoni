package tests.regression;

import base.baseTest;
import data.TestData;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class userTests extends baseTest {
    TestData userData = new TestData();
    String nonExisting = userData.nonExisting;
    String testUserName = userData.testUserName;

    @Test
    public void fetchNonExistingUserShouldReturn404ErrorMessage() {
        given().
                spec(requestSpec).
                pathParam("username", nonExisting).
                when().
                get("/store/order/{username}").
                then().
                log().ifValidationFails().
                assertThat().
                body("code", hasToString("404")).
                body(containsString("User not found"));
    }

    @Test
    public void deleteNonExistingUser() {

        given().
                spec(requestSpec).
                pathParam("username", nonExisting).
                when().
                delete("/user/{username}").
                then().
                assertThat().
                body("code", hasToString("404")).
                body(containsString("User not found"));
    }

    @Test
    public void updateUserWithoutProvidingNewDetails() {

        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                pathParam("username", testUserName).
                when().
                body("").
                post("/user/{username}").
                then().
                log().ifValidationFails().
                assertThat().
                body("id", Matchers.not(testUserName));

    }

    @Test
    public void createUserWithEmptyDetails() {

        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                post("/user").
                then().
                log().ifValidationFails().
                assertThat().
                body("code", hasToString("400"));
    }

    @Test
    public void creatingEmptyWishlist() {

        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body("[]").
                post("/user/createWishlist").
                then().
                log().ifValidationFails().
                assertThat().
                body("code", equalTo(400));
    }
}
