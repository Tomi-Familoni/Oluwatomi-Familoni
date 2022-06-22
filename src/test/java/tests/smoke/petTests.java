package tests.smoke;


import base.baseTest;
import common.MyLogger;
import data.TestData;
import helpers.Pet;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;


public class petTests extends baseTest {
    private Logger log = MyLogger.log;
    TestData pet = new TestData();
    String status = pet.status;
    String tagName = pet.tagName;
    int petId = pet.petId;
    int newPetId = pet.newPetId;
    String petName = pet.petName;

    public Pet newPet(){
        Pet newPet = new Pet();
        newPet.setId(newPetId);
        newPet.setName(petName);
        newPet.setStatus(status);
        return newPet ;
    }

    @Test
    public void createPetSuccessfully() {
        given().
                spec(requestSpec).
                queryParam("name", petName).
                queryParam("status", status).
                when().
                body(newPet()).
                post("/pet").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("name", equalTo(petName)).
                body("status", equalTo(status));
    }

    @Test
    public void getPetByIdSuccessfully() {
        given().
                spec(requestSpec).
                pathParam("petId", newPetId).
                when().
                get("/pet/{petId}").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("id", equalTo(newPetId));
    }

    @Test
    public void requestByStatusSuccessfully() {
        given().
                spec(requestSpec).
                queryParam("status", status).
                when().
                get("pet/findByStatus").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                time(lessThan(1000L)).
                body("status", everyItem(equalTo(status)));
    }

    @Test
    public void requestByTags() {
        given().
                spec(requestSpec).
                queryParam("tags", tagName).
                when().
                get("/pet/findByTags").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body(containsString(tagName));
    }

    @Test
    public void deletePet() {
        String responseString =
                given().
                        spec(requestSpec).
                        pathParam("petId", petId).
                        when().
                        delete("/pet/{petId}").
                        then().
                        spec(responseSpec).
                        extract().
                        asString();
        Assert.assertEquals(responseString, "Pet deleted");
    }

    @Test
    public void createPetResponseBodyMatchesSchema() {
        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body(newPet()).
                post("/pet").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body(matchesJsonSchemaInClasspath("createPetSchema.json"));
    }
}
