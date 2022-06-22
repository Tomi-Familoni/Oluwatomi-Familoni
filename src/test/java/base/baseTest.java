package base;

import common.MyLogger;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class baseTest {
    private Logger log = MyLogger.log;
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost:8080/api/v3").
                setContentType(ContentType.fromContentType("application/json; charset=utf-8")).
                build();
    }

    @BeforeClass
    public static void createResponseSpecification() {
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }
}
