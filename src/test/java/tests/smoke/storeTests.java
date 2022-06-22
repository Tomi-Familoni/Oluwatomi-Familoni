package tests.smoke;

import base.baseTest;
import common.MyLogger;
import data.TestData;
import helpers.Store;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class storeTests extends baseTest {
    private Logger log = MyLogger.log;

    TestData storeData = new TestData();
    String status = storeData.status;
    int orderQty = storeData.orderQty;
    String shipmentTime = storeData.shipmentTime;
    int orderId = storeData.orderId;
    int newOrderId = storeData.newOrderId;
    int orderPetId = storeData.orderPetId;
    int placed = storeData.placed;

    @Test
    public void getStoreInventory() {
        given().
                spec(requestSpec).
                when().
                get("/store/inventory").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("placed", equalTo(placed));
    }

    @Test
    public void getOrderById() {
        given().
                spec(requestSpec).
                pathParam("orderId", newOrderId).
                when().
                get("/store/order/{orderId}").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("id", equalTo(newOrderId)).
                body("complete", equalTo(true));
    }

    @Test
    public void deleteOrder() {
        given().
                spec(requestSpec).
                pathParam("orderId", orderId).
                when().
                when().
                delete("/store/order/{orderId}").
                then().
                assertThat().
                body(containsString(""));
    }

    public Store newOrder() {
        Store storeOrder = new Store();

        storeOrder.setId(newOrderId);
        storeOrder.setPetId(orderPetId);
        storeOrder.setQuantity(orderQty);
        storeOrder.setStatus(status);
        storeOrder.setShipDate(shipmentTime);

        return storeOrder;
    }

    @Test
    public void createOrderSuccessfully() {
        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body(newOrder()).
                post("/store/order").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body("id", equalTo(newOrderId)).
                body("petId", equalTo(orderPetId)).
                body("quantity", equalTo(orderQty)).
                body("status", equalTo(status)).
                body("complete", equalTo(true));
    }


    @Test
    public void createNewOrderResponseBodyMatchesSchema() {
        given().
                contentType(ContentType.JSON).
                spec(requestSpec).
                when().
                body(newOrder()).
                post("/store/order").
                then().
                spec(responseSpec).
                log().ifValidationFails().
                assertThat().
                body(matchesJsonSchemaInClasspath("createOrderSchema.json"));
    }
}
