# Test Plan

**Author**: Andrew Hu

## 1 Testing Strategy

### 1.1 Overall strategy

Our testing strategy consists of the following activities:

- Unit testing: Testing individual functions and classes in isolation.
- Integration testing: Testing the interaction between different components of the app.
- System testing: Testing the app as a whole.
- Regression testing: Testing to ensure that changes made to the app do not introduce new bugs.

All members of the QA team will be responsible for performing testing activities at each level.

### 1.2 Test Selection

We will use both black-box and white-box testing techniques to select our test cases. Our test cases will be selected based on the following techniques:

**Black-box testing techniques:**
- Equivalence partitioning
- Boundary value analysis
- Use case testing

**White-box testing techniques:**
- Statement coverage: We will ensure that each statement in the code is executed at least once.
- Branch coverage: We will ensure that each decision point in the code is executed at least once.

We will use different techniques at different testing levels.

### 1.3 Adequacy Criterion

We will assess the quality of our test cases by measuring functional and structural coverage. We aim to achieve at least 90% statement and branch coverage for unit testing and 80% coverage for system testing.

### 1.4 Bug Tracking

We will use an issue tracking system, such as JIRA, to track bugs and enhancement requests.

### 1.5 Technology

We will use JUnit for unit testing and Appium for system testing.

## 2 Test Cases

| Test Case ID | Purpose                                                      | Steps                                      | Expected Result                                                          | Actual Result | Pass/Fail | Additional Information |
|--------------|--------------------------------------------------------------|--------------------------------------------|--------------------------------------------------------------------------|---------------|-----------|------------------------|
| TC01 | Successful register to app | 1. Open application. <br> 2. Click register button. <br> 3. Enter email. <br> 4. Enter password. <br> 5. Click register.| User successfully registered. | As expected | Pass | Email used: abc123@gmail.com , Password used:abc123 |
| TC02 | Successful login to app | 1. Open application. <br> 2. Enter email. <br> 3. Enter password. | User is logged in successfully. | As expected | Pass | Used same info as above |
| TC03 | To verify that the user can add a store | 1. Log in to the application. <br> 2. Click on add button in store fragment. <br> 3. Enter store information. | The user should be able to see the store in the store fragment. | As expected | Pass | N/A |
| TC04 | To verify that the user can view each store's offerings | 1. Log in to the application. <br> 2. Select a store from the list. | The user should be able to see all the products offered by the store. | As expected | Pass | N/A |
| TC05 | To verify that users can add new products to the system | 1. Log in to the application. <br> 2. Select a store from the list. <br> 3. Click add button. <br> 4. Enter product information and click save. | The new product should be added to the database and displayed in the store. | As expected | Pass | N/A |
| TC06 | To verify that users can edit existing products in the system | 1. Log in to the application. <br> 2. Select a store from the list. <br> 3. Click edit button on the product you want to edit. <br> 4. Update the product details and press save. | The product details should be updated in the database and displayed in the store. | As expected | Pass | Has to back out of the store until you are in the stores fragment then when you go back into the store, it updates. |
| TC07 | To verify that users can delete existing products from the system | 1. Log in to the application. <br> 2. Select a store from the list. <br> 3. Click delete button on the product you want to delete. | The product should be deleted from the database and removed from the store. | As expected | Pass | N/A |
| TC08 | To verify that users can search for products by typing their name | 1. Log in to the application. <br> 2. Click on search bar in the a selected store. <br> 3. Type the name of the product in the search box. | The product related to the search term should be displayed. | As expected | Pass | N/A |
| TC09 | To verify that users can view the details of a product | 1. Log in to the application. <br> 2. Click on a store. | The details of the selected product should be displayed under each product. | As expected | Pass | N/A |
