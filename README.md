# Solution to Software QA Challenge  for N26 by Oluwatomi Familoni

--------------------------------------------------------------------------------------------------------
----------------------------------------------------
## DELIVERABLE 1 - Exploratory Test on Monefy Budget Manager Mobile App

 Please perform the testing session and write in a markdown file:
 Exploratory testing charters to document your testing.
 Findings from your charters. Did everything work as expected? What bugs were discovered?
 Prioritisation of those charters - which area of the app or testing would you explore first and why?
 How much time you have planned for each charter?
 What kind of risks you need to mitigate for this type of application?


## Exploratory Testing Charters:

- Claim My Offer Charter
- Budgeting Dashboard Charter
- Budgeting Balance Breakdown report Charter
- Budget Report Filter
- Add New Expense Charter
- Add new Income Charter
- Settings Charter


#### CLAIM MY OFFER CHARTER
Analyse Budgeting Dashboard and report on areas of potential risk

####Areas

- Android Platform of the Monefy Mobile Application
- `Claim My Offer` Modal

####Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing

####Test Notes:

I focused on the `Claim My Offer` Modal to validate that ;

- User should successfully unlock Pro mode after providing valid Debit/Credit Card details
- User should not be able proceed to unlock Pro mode with an Expired Debit/Credit Card
- User should not be able proceed to unlock Pro mode with an Invalid year - too far into the future
- Users attempting to submit payment card details without no Card Name and or Card Address should not be able to proceed.
  User should only be able to create a new expense for a non-zero amount.

####Data files

- Screenshots, recordings

####Risks

- Incorrectly processing payents from invalid/expired payment cards.
- Hence, losing money to fraud

####Bugs

- BUG 101- Launching the app with no intrenet connection triggers "Error performing request". Claim my Offer button and offer amount details not displayed as the app was unable to fetch the necessary date to display these data. A
- BUG 102- Something went wrong  no internet connection trying to launch the app
- BUG 103 Add Debit/Credit Card page was blank when attempting to access the page with no internet connection
- BUG 104 Attempting to select a country from the dopdownlist caused previously filled data to be cleared causing user to have to repeat filling the form
- BUG 105 Unable to successfully add a debit card . "Your request failed. Use a different payment method or contact us. [OR-CCSEH-21]"

####Issues
- n

----


###BUDGETING/EXPENSE DASHBOARD CHARTER
Analyse Budgeting Dashboard and report on areas of potential risk

####Areas

- Android Platform
- Monefy Expense/income Dashboard

####Task
- Duration - Short (30 minutes)
- Test Breakdown - Bug Logging, Functional Testing

####Test Notes:

I focused on the Expense/income Dashboard to validate that ;

- A pie chart should correctly displaying the income against expenses, distribution of the expenses to the different expense categories as well as the corresponding percentage.
- Percentage allocated to the various expenses category is correctly computed and displayed
- The correct balance after deducting expenses from income should be displayed
- User should be able to navigate to the Budgeting Balance Breakdown report using the Balance button
- Should be able to navigate to the add Expense and add New income pages successfully with the appropriate buttons on the dashboard
- The amounts should be displayed correct to 2 decimal places.
- When Budget mode is activated with a specific budget amount configured, the budget amount should be reflected on the dashboard and should be colour coded blue on the pie chart. The balance amount displayed on the Balance button should always be calculated as Budget + Income  - Expense.
- If Balance is in deficit after taking the budget amount into consideration, Balance button should be red, else Balance button should be green ( ie Balance >= 0)

####Data files

- Screenshots, recordings

####Risks

- Incorrect computation of balance amount
- Incorrect allocation of distribution of amount spent on the various expense categories
- Incorrectly plotted pie-chart  depicting the

####Bugs
- v

####Issues


-------------------------------------

###BUDGETING BALANCE BREAKDOWN REPORT CHARTER
Analyse Budgeting balance breakdown report and highlight areas of potential risk

####Areas

- Android Platform
- Budgeting balance breakdown report view

####Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing

####Test Notes:

I paid attention to the breakdown report to ensure that;

- All expenses are recorded correctly
- User can toggle between Categories and detail view of accounting entries on the report view
- Correct amount, currency is displayed
- Correct color coding is used for different types of accounting entries (green for income, expenses)
- Correct balance is computed and displayed.
- The right date was assigned to each expense recorded



####Data files
- Screenshots, recordings

####Risks

- Incorrect assignment of accounting entry to the category type
- incorrect computation of balance amount
- Incorrect data on the report page

####Bugs
- v

####Issues
- The Kebab menu icon is not very visible

------------------------


####BUDGET REPORT FILTER CHARTER
Analyse Budgeting report filter and report on areas of potential risk

####Areas
- Android Platform
- Budget Report Filter Drawer

####Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing


####Test Notes:

- The Date interval/period for the budgeting report should be displayed
- User should be able to select the reporting period  displayed on the dashboard using the side drawer. The options should include Day/Month/Year.
- The user should also have the option of viewing the budgeting report for a specified period or for a specific date in the past
- The user should be able to view budget report based on the pre-configured/registered payment instruments
- User should not be able to filter using invalid dates or invalid date rages


####Data files

- Screenshots, recordings

####Risks
- Fetching and displaying wrong data 
- Filters nor working correctly

####Bugs
- On the `Choose Date` view, after selecting a specific date on calendar and viewing the report, when user attempts to view the calendar, a wrongly selected date date is highlighted on the calendar.

####Issues


--------------------------------------------------------



###SETTINGS CHARTER
Analyse `Settings` page and report on areas of potential risk

####Areas

- Android Platform
- `Settings` drawer

####Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing

####Test Notes:

- User should be unable to enable Dark Theme if still on Free Version. User should be redirected to the Claim offer modal whenever they attempt to enable Dark Theme mode. This also applies to Synchronization settings and Password Protection Settings
- User should be able to successfully unlock Monefy Pro from the Settings drawer
- User should successfully change currencies from the list of available currencies. There should be a search bar to allow user search through the list of supported currencies using valid currency names or currency codes
- When user attempts searching through the currency list using invalid or unsupported currency code or name, no search result should be returned. In fact, an appropriate error message
- User should be able to successfully export and download budgeting reports to CSV format.
- When exporting a report, user should be provided options for Character set. They should be offered the option to select between Decimal comma of Decimal point


####Data files

- Screenshots, recordings

####Risks

- User is able to access Monefy pro features when they have not activated and are still on the Free mode

####Bugs

- Attempting to change Language only works for date. Newly selected language is not effected for all the forms, descriptions, menu items, modal titles etc. Instead, English Language is still mainitained.

####Issues

----------------------------------------

### EXPENSE CREATION CHARTER
Analyse the `New Expense` form and report on areas of potential risk

####Areas

- Android
- Expense creation form

####Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing


####Test Notes:
I focused on the dashboard to validate that a user ;

- Can specify new expense amount (with decimal or rounded amount) up to 9 digits
- Can change/edit amount being specified for the expense
- Can provide a note or comment about the expense being created. User should be able to create a new income with or without a note.
- User can specify or select the Payment instrument for the new expense being created.
- Can select an expense category from the existing options
- Should be unable to add a new expense category without unlocking Monify Pro mode.
- If user is on free trial, they should be redirected to Claim my order modal when user attemmpts to add an expense Category
- User should only be able to create a new expense for a non-zero amount.

####Data files

- Screenshots, recordings

####Risks
- User is unable to successfully create an expense record

####Bugs
- v

####Issues


------------------


###NEW INCOME RECORD CREATION  CHARTER
Analyse the 'New Income' form and report on areas of potential risk

####Areas

- Android Platform
- Income record creation form/page

####Task

- Duration - Short (30 mins)

- Test Breakdown - Bug Logging, Functional Testing

####Test Notes:

- User can specify or select the Payment instrument for the income
- Can specify income amount (with decimal, integar) up to 9 digits
- Can change/edit amount being specified for the income
- Can provide a note or comment about the income being created. User should be able to create a new income with or without a note
- Can select an income category from the existing options
- Should be unable to add a new income category without unlocking Monify Pro mode.
- If user is on free trial, they should be redirected to Claim my order modal when user attemmpts to add an Income Category
- User should only be able to create a new income for a non-zero amount

####Data files
- Screenshots, recordings

####Risks
- Analyse the 'New Expense' form and report on areas of potential risk

####Bugs
- v

####Issues



###ALL BUGS FOUND DURING THE TEST SESSION

- Launching the app with no intrenet connection triggers "Error performing request". Claim my Offer button and offer amount details not displayed as the app was unable to fetch the necessary date to display these data. A
- Something went wrong  no internet connection trying to launch the app.
- Add Debit/Credit Card page was blank when attempting to access the page with no internet connection.
- Attempting to select a country from the dopdownlist caused previously filled data to be cleared causing user to have to repeat filling the form
- Unable to successfully add a debit card . "Your request failed. Use a different payment method or contact us. [OR-CCSEH-21]"
- Attempting to change Language only works for date. Newly selected language is not effected for all the forms, descriptions, menu items, modal titles etc. Instead, English Language is still mainitained.
- On the Choose Date view, after selecting a specific date on calendar and viewing the report, when user attempts to view the calendar, a wrongly selected date date is highlighted on the calendar.


###Prioritisation of the Charters (0 as the highest priority)

- Priority 0 - Income/Expense Creation + Dashboard
- Priority 1 - Reporting ( Balance breakdown report and filter)
- Priority 1 - Balance Settings - Budget Mode, Carry Over, Future Recurring Invoices
- Priority 1 - Unlock Pro/Claim Offer Page
- Priority 2 - Settings

----------------------------------------------------
----------------------------------------------------
# DELIVERABLE 2: PET STORE API TEST AUTOMATION FRAMEWORK

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

###Dependencies
1. rest-assured 4.3.3
2. testNG 7.3.0
3. json-path 4.3.3
4. json-schema-validator 4.4.3
5. maven-surefire-plugin
6. github.javafaker
   
These dependencies are already setup on the pom.xml file

###Approach to the task and reasons for using this approach

1. `RequestSpecBuilder` and `ResponseSpecBuilder`:  RequestSpecBuilder was used to optimise the code and make it more maintainable as it provides me the ability to reuse request specifications (Base URI and base path).  I created a ResponseSpecification to specify checks that I performed on the responses that are returned from the API calls.  Specifically,the expected status code for each of the API calls and that the expected content type.
2. `JsonSchemaValidator`: allowed me define the expected syntax and structure for a JSON response payload including what fields are required and data types expected. This was used for the comments.
3. `POJO` Serialization/Deserialization helped provide reusable objects for other test classes  
- Kindly note that:
  - `The exercise was implemented using a Mac PC. And so file directories/path are written in macOS format.`

### Scenarios covered in the test automation framework;

####Smoke Tests

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
- Logout User5412 ms

####Regression tests
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