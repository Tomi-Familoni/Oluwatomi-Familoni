package tests.smoke;

import base.baseTest;
import data.TestData;
import helpers.User;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class userTests extends baseTest {
    TestData user = new TestData();
    String testUserName = user.testUserName;
    public String username = user.username;
    public String firstname = user.firstname;
    public String lastname = user.lastname;
    public String phoneNumber = user.phoneNumber;
    public String email = user.email;
    public String password = user.password;
    public int userId = user.userId;
    @Test
    public void loginUser() {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        given().log().all().
                spec(requestSpec).
                when().
                body(newUser).
                get("/user/login").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body(containsString("Logged in user session"));
    }

    @Test
    public void logoutUser() {
        given().
                spec(requestSpec).
                when().
                get("/user/logout").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body(containsString("User logged out"));
    }

    @Test
    public void getUserByUsername() {
        given().
                spec(requestSpec).
                pathParam("testUserName", testUserName).
                when().
                get("/user/{testUserName}").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("username", equalTo(testUserName));
    }

    @Test
    public void deleteUser() {

        given().
                spec(requestSpec).
                pathParam("username", username).
                when().
                when().
                delete("/user/{username}").
                then().
                assertThat().
                body(containsString(""));
    }

    @Test
    public void updateUser() {
        User existingUser = new User();

        existingUser.setUsername(username);
        existingUser.setFirstName(firstname);
        existingUser.setLastName(lastname);
        existingUser.setEmail(email);
        existingUser.setPassword(password);
        existingUser.setPhone(phoneNumber);

        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                pathParam("username", testUserName).
                when().
                body(existingUser).
                put("/user/{username}").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("id", Matchers.not(testUserName)).
                body("username", equalTo(username));
    }

    public User newUser(){
        User newUser = new User();
        newUser.setId(userId);
        newUser.setUsername(username);
        newUser.setFirstName(firstname);
        newUser.setLastName(lastname);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhone(phoneNumber);
        return newUser;
    }

    @Test
    public void createUser() {
        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body(newUser()).
                post("/user").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("id", equalTo(userId)).
                body("username", equalTo(username)).
                body("firstName", equalTo(firstname)).
                body("lastName", equalTo(lastname)).
                body("email", equalTo(email)).
                body("phone", equalTo(phoneNumber)).
                body("password", equalTo(password));
    }

    @Test
    public void createWishlist() {
        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body( newUser()).
                post("/user/createWishlist").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("id", equalTo(userId)).
                body("username", equalTo(username)).
                body("firstName", equalTo(firstname)).
                body("lastName", equalTo(lastname)).
                body("email", equalTo(email)).
                body("phone", equalTo(phoneNumber)).
                body("password", equalTo(password));
    }

    @Test
    public void createNewUserResponseBodyMatchesSchema() {
        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body(newUser()).
                post("/user").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body(matchesJsonSchemaInClasspath("createUserSchema.json"));
    }
}