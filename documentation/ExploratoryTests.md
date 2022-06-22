## DELIVERABLE 1 - Exploratory Test on Monefy Budget Manager Mobile App
### by Oluwatomi Familoni

- Please perform the testing session and write in a markdown file:
- Exploratory testing charters to document your testing.
- Findings from your charters. Did everything work as expected? What bugs were discovered?
- Prioritisation of those charters - which area of the app or testing would you explore first and why?
- How much time you have planned for each charter?
- What kind of risks you need to mitigate for this type of application?


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

#### Areas

- Android Platform of the Monefy Mobile Application
- `Claim My Offer` Modal

#### Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing

#### Test Notes:

I focused on the `Claim My Offer` Modal to validate that ;

- User should successfully unlock Pro mode after providing valid Debit/Credit Card details
- User should not be able proceed to unlock Pro mode with an Expired Debit/Credit Card
- User should not be able proceed to unlock Pro mode with an Invalid year - too far into the future
- Users attempting to submit payment card details without no Card Name and or Card Address should not be able to proceed.
  User should only be able to create a new expense for a non-zero amount.

#### Data files

- Screenshots, recordings

#### Risks

- Incorrectly processing payents from invalid/expired payment cards.
- Hence, losing money to fraud

#### Bugs

- BUG 101- Launching the app with no internet connection triggers "Error performing request". `Claim my Offer` button and offer amount details not displayed as the app was unable to fetch the necessary date to display these data. A
- BUG 102- Something went wrong  no internet connection trying to launch the app
- BUG 103 Add Debit/Credit Card page was blank when attempting to access the page with no internet connection
- BUG 104 Attempting to select a country from the dopdownlist caused previously filled data to be cleared causing user to have to repeat filling the form
- BUG 105 Unable to successfully add a debit card . "Your request failed. Use a different payment method or contact us. [OR-CCSEH-21]"

#### Issues
- 'Claim Offer' button covers reviews data. At first glance, user is not aware that the page can be scrolled to view `reviews` , `private policy` and `Restore` button

----


### BUDGETING/EXPENSE DASHBOARD CHARTER
Analyse Budgeting Dashboard and report on areas of potential risk

#### Areas

- Android Platform
- Monefy Expense/income Dashboard

#### Task
- Duration - Short (30 minutes)
- Test Breakdown - Bug Logging, Functional Testing

#### Test Notes:

I focused on the Expense/income Dashboard to validate that ;

- A pie chart should correctly displaying the income against expenses, distribution of the expenses to the different expense categories as well as the corresponding percentage.
- Percentage allocated to the various expenses category is correctly computed and displayed
- The correct balance after deducting expenses from income should be displayed
- User should be able to navigate to the Budgeting Balance Breakdown report using the Balance button
- Should be able to navigate to the add Expense and add New income pages successfully with the appropriate buttons on the dashboard
- The amounts should be displayed correct to 2 decimal places.
- When Budget mode is activated with a specific budget amount configured, the budget amount should be reflected on the dashboard and should be colour coded blue on the pie chart. The balance amount displayed on the Balance button should always be calculated as Budget + Income  - Expense.
- If Balance is in deficit after taking the budget amount into consideration, Balance button should be red, else Balance button should be green ( ie Balance >= 0)

#### Data files

- Screenshots, recordings

#### Risks

- Incorrect computation of balance amount
- Incorrect allocation of distribution of amount spent on the various expense categories
- Incorrectly plotted pie-chart  depicting the

#### Bugs
- 

#### Issues


-------------------------------------

### BUDGETING BALANCE BREAKDOWN REPORT CHARTER
Analyse Budgeting balance breakdown report and highlight areas of potential risk

#### Areas

- Android Platform
- Budgeting balance breakdown report view

#### Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing

#### Test Notes:

I paid attention to the breakdown report to ensure that;

- All expenses are recorded correctly
- User can toggle between Categories and detail view of accounting entries on the report view
- Correct amount, currency is displayed
- Correct color coding is used for different types of accounting entries (green for income, expenses)
- Correct balance is computed and displayed.
- The right date was assigned to each expense recorded



#### Data files
- Screenshots, recordings

#### Risks

- Incorrect assignment of accounting entry to the category type
- incorrect computation of balance amount
- Incorrect data on the report page

#### Bugs
- 

#### Issues
- The Kebab menu icon is not very visible

------------------------


#### BUDGET REPORT FILTER CHARTER
Analyse Budgeting report filter and report on areas of potential risk

#### Areas
- Android Platform
- Budget Report Filter Drawer

#### Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing


#### Test Notes:

- The Date interval/period for the budgeting report should be displayed
- User should be able to select the reporting period  displayed on the dashboard using the side drawer. The options should include Day/Month/Year.
- The user should also have the option of viewing the budgeting report for a specified period or for a specific date in the past
- The user should be able to view budget report based on the pre-configured/registered payment instruments
- User should not be able to filter using invalid dates or invalid date rages


#### Data files

- Screenshots, recordings

### Risks
- Fetching and displaying wrong data
- Filters nor working correctly

#### Bugs
- On the `Choose Date` view, after selecting a specific date on calendar and viewing the report, when user attempts to view the calendar, a wrongly selected date date is highlighted on the calendar.

#### Issues


### SETTINGS CHARTER
Analyse `Settings` page and report on areas of potential risk

#### Areas

- Android Platform
- `Settings` drawer

#### Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing

#### Test Notes:

- User should be unable to enable Dark Theme if still on Free Version. User should be redirected to the Claim offer modal whenever they attempt to enable Dark Theme mode. This also applies to Synchronization settings and Password Protection Settings
- User should be able to successfully unlock Monefy Pro from the Settings drawer
- User should successfully change currencies from the list of available currencies. There should be a search bar to allow user search through the list of supported currencies using valid currency names or currency codes
- When user attempts searching through the currency list using invalid or unsupported currency code or name, no search result should be returned. In fact, an appropriate error message
- User should be able to successfully export and download budgeting reports to CSV format.
- When exporting a report, user should be provided options for Character set. They should be offered the option to select between Decimal comma of Decimal point


#### Data files

- Screenshots, recordings

#### Risks

- User is able to access Monefy pro features when they have not activated and are still on the Free mode

#### Bugs

- Attempting to change Language only works for date. Newly selected language is not effected for all the forms, descriptions, menu items, modal titles etc. Instead, English Language is still mainitained.

#### Issues

----------------------------------------

### EXPENSE CREATION CHARTER
Analyse the `New Expense` form and report on areas of potential risk

#### Areas

- Android
- Expense creation form

#### Task

- Duration - Short (30 mins)
- Test Breakdown - Bug Logging, Functional Testing


#### Test Notes:
I focused on the dashboard to validate that a user ;

- Can specify new expense amount (with decimal or rounded amount) up to 9 digits
- Can change/edit amount being specified for the expense
- Can provide a note or comment about the expense being created. User should be able to create a new income with or without a note.
- User can specify or select the Payment instrument for the new expense being created.
- Can select an expense category from the existing options
- Should be unable to add a new expense category without unlocking Monify Pro mode.
- If user is on free trial, they should be redirected to Claim my order modal when user attemmpts to add an expense Category
- User should only be able to create a new expense for a non-zero amount.

#### Data files

- Screenshots, recordings

#### Risks
- User is unable to successfully create an expense record

#### Bugs
- 

#### Issues


------------------


### NEW INCOME RECORD CREATION  CHARTER
Analyse the 'New Income' form and report on areas of potential risk

#### Areas

- Android Platform
- Income record creation form/page

#### Task

- Duration - Short (30 mins)

- Test Breakdown - Bug Logging, Functional Testing

#### Test Notes:

- User can specify or select the Payment instrument for the income
- Can specify income amount (with decimal, integar) up to 9 digits
- Can change/edit amount being specified for the income
- Can provide a note or comment about the income being created. User should be able to create a new income with or without a note
- Can select an income category from the existing options
- Should be unable to add a new income category without unlocking Monify Pro mode.
- If user is on free trial, they should be redirected to Claim my order modal when user attemmpts to add an Income Category
- User should only be able to create a new income for a non-zero amount

#### Data files
- Screenshots, recordings

#### Risks
- Analyse the 'New Expense' form and report on areas of potential risk

#### Bugs
- 

#### Issues



### ALL BUGS FOUND DURING THE TEST SESSION

- Launching the app with no intrenet connection triggers "Error performing request". Claim my Offer button and offer amount details not displayed as the app was unable to fetch the necessary date to display these data. A
- Something went wrong  no internet connection trying to launch the app.
- Add Debit/Credit Card page was blank when attempting to access the page with no internet connection.
- Attempting to select a country from the dopdownlist caused previously filled data to be cleared causing user to have to repeat filling the form
- Unable to successfully add a debit card . "Your request failed. Use a different payment method or contact us. [OR-CCSEH-21]"
- Attempting to change Language only works for date. Newly selected language is not effected for all the forms, descriptions, menu items, modal titles etc. Instead, English Language is still mainitained.
- On the Choose Date view, after selecting a specific date on calendar and viewing the report, when user attempts to view the calendar, a wrongly selected date date is highlighted on the calendar.


### Prioritisation of the Charters (0 as the highest priority)

- Priority 0 - Income/Expense Creation + Dashboard
- Priority 1 - Reporting ( Balance breakdown report and filter)
- Priority 1 - Balance Settings - Budget Mode, Carry Over, Future Recurring Invoices
- Priority 1 - Unlock Pro/Claim Offer Page
- Priority 2 - Settings
