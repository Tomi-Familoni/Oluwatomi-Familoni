
# DELIVERABLE 2: PET STORE API TEST AUTOMATION FRAMEWORK 
### by Oluwatomi Familoni

A test automation framework to test the api: https://petstore3.swagger.io/

### Tech stack
1. Java 18
2. Maven
3. TestNG
4. REST-Assured

### Test Implementation
- Tests covered by the test automation framework were grouped into
- Smoke Tests which covered happy paths for the various endpoints for `User`, `Pet` and `Store Order` and;
- Regression tests which covered various negative scenarios for those endpoints.

The smoke tests can be configured to run every code check-in for software engineers while the regression tests can be run less frequently; for example twice a day.
- Smoke tests
-
    - test the availability of the service
    - Functional correctness of the service.

### Dependencies
1. rest-assured 4.3.3
2. testNG 7.3.0
3. json-path 4.3.3
4. json-schema-validator 4.4.3
5. maven-surefire-plugin
6. github.javafaker

These dependencies are already setup on the pom.xml file

### Approach to the task and reasons for using this approach

1. `RequestSpecBuilder` and `ResponseSpecBuilder`:  RequestSpecBuilder was used to optimise the code and make it more maintainable as it provides me the ability to reuse request specifications (Base URI and base path).  I created a ResponseSpecification to specify checks that I performed on the responses that are returned from the API calls.  Specifically,the expected status code for each of the API calls and that the expected content type.
2. `JsonSchemaValidator`: allowed me define the expected syntax and structure for a JSON response payload including what fields are required and data types expected. This was used for the comments.
3. `POJO` Serialization/Deserialization helped provide reusable objects for other test classes
- Kindly note that:
    - `The exercise was implemented using a Mac PC. And so file directories/path are written in macOS format.`

### Scenarios covered in the test automation framework;

#### Smoke Tests

- Create a new Pet Successfully
- Validate that the json response body matches the expected Schema after creating a new Pet
- Delete an Existing Pet
- Fetch a Pet successfully using the Pet ID
- Fetch pet successfully using the status (available, sold or pending)
- Fetch pet successfully using the available tags (tag1, tag2 or tag3)


- Create a new Order Successfully
- Validate that the json response body matches the expected Schema after creating a new Store Order
- Delete Order
- Fetch an Order using Order ID
- Fetch all Store Inventory


- Create new User
- Validate that the json response body matches the expected Schema after creating a new User
- Create a Wishlist for a user
- Delete an existing user
- Fetch a User's record using username
- Login as a User
- Logout User

#### Regression tests
- Delete Pet With Invalid ID should return 400 status code with appropriate error message
- Fetching a Pet with a non exiisting ID should return 404 status code with appropriate error message
- Fetching a Pet with an invalid ID should return 400 status code with appropriate error message
- Request for a Pet using a status type not included in the existing status types should return 404 status code with appropriate error message
- Fetch Pet using an invalid Tag name should return 400 status code with appropriate error message
- Attempting to fetch pets without a Tag name should return 400 status code with appropriate error message
- Fetch a store Order using invalid ID should return 400 Status Code
- Attempting to create an Empty Wishlist should return 400 status code with appropriate error message
- Attempting to delete a NonExisting User should return 404 status code with appropriate error message
- Fetch records for a user not existing in the DB should return 404 status code with appropriate error message
- Update User Without Providing New Details should return 400 status code with appropriate error message
-
### LAUNCHING PROJECT / SETTING UP THE ENVIRONMENT
- Launch IDE(IntelliJ)
- Click File on the menu
- Click Open
- Navigate to folder where project was downloaded (i.e. project directory)
- Select project folder
- Click Open

- Once project has fully opened on IDE, open the pom.xml file, replace source and target versions in the properties tag with the exact Java version you have on your machine.For example;
    - if you have JDK v18
      `<maven.compiler.target>18</maven.compiler.target> `
      `<maven.compiler.source>18</maven.compiler.source>`
    - Ensure all dependencies are downloaded successfully by clicking Maven Tool icon on the top right of the  IDE, click Refresh icon.
    - Note, If there is a pop-up to import dependencies, ensure to click Enable auto-import to automatically download all required dependencies for the project.
- `Kindly note that the tests were implemented with the assumption that the API would be running locally. To run the API locally, kindly follow the instructions laid out here before running tests:` https://github.com/swagger-api/swagger-petstore
### HOW TO RUN TESTS
https://github.com/Tomi-Familoni/pet-store-api-tests
#### Option 1
- Run this command on the IDE terminal ->`mvn clean compile test`.

#### Option 2
- After installing TESTNG on your IDE
- Right-click on the test class and
- Click' Run As' then
- Click 'TESTNG TEST'.

### TEST REPORT:
After executing the tests, you should be able to view test result on
- the terminal where the test was run or on the IDE console.
- surefire-reports which you can access using the following steps:
    - Navigate to project folder, select target folder
    - Select surefire-reports
    - Open emailable-report.html to launch a web view of the test report.

![Alt text](documentation/testresult2.png?raw=true "Optional Title")
-----------
![Alt text](documentation/testresult1.png?raw=true "Optional Title")
