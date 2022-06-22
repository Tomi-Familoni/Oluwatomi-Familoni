package data;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.util.Random;

public class TestData {
    Faker faker = new Faker();
    public String username = faker.name().username();
    public String firstname = faker.name().firstName();
    public String lastname = faker.name().lastName();
    public String phoneNumber = faker.phoneNumber().cellPhone();
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password();
    public int userId = faker.number().numberBetween(1, 500);

    public String testUserName = "user1";
    Random r = new Random();
    public String[] statusList = {"available", "pending", "sold"};
    public String status = statusList[r.nextInt(statusList.length)];

    public String[] tagList = {"tag1", "tag2", "tag3"};
    public String tagName = tagList[r.nextInt(tagList.length)];


    public int petId = faker.number().numberBetween(1, 4);
    public int newPetId = faker.number().numberBetween(5, 10);
    public String petName = faker.name().firstName();

    public int approvedDelivered = 50;
    public int placed = 100;
    public int orderQty = faker.number().numberBetween(50, 100);
    public String shipmentTime = Instant.now().toString();

    public int orderId = faker.number().numberBetween(1, 5);
    public int newOrderId = faker.number().numberBetween(6, 10);
    public int orderPetId = faker.number().numberBetween(1, 5000);

    public String invalidId = "xyz_";
    public String nonExistingId = "18765876578";
    public String nonExisting = "ndhdhhdhdhdh";
}
