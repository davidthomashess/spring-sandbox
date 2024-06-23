# Spring Boot Sandbox - Company Employee

## About the Project

A learning effort to teach myself how to build a Spring Boot API from an Entity Relationship Diagram.

## Getting Started

Select the "<> Code" button and select the "Codespaces" tab.

Click the button "Create codespace on [branch name]".

Choose "Open Workspace" in the bottom right pop-up.

Run:

```bash
mvn clean spring-boot:run
```

If mvn is not installed, run:

```bash
./mvnw clean spring-boot:run
```

Click "Open in browser" in the bottom right pop-up to get the URL for you running application from the address bar.

## H2 Console

From the address bar for your running application append the following to the URL:

```
/h2/
```

Copy the value of the spring.datasource.url variable in your application.properties. Located in:

```
./src/main/resources/application.properties
```

Paste the spring.datasource.url value in your JDBC URL field and click the "Connect" button.

Try to run the following SQL query to see if you can get a list of sample employees from the EMPLOYEE table in the database:

```sql
SELECT * FROM EMPLOYEE;
```

The PROJECT table should also be prepopulated with sample data

## API Documentation

I've provided a list of all the following endpoints for the respective entities:

- Assignment
  - GET all: "/assignment/all"
  - GET one: "/assignment/employee/{employeeId}/project/{projectId}"
  - POST record: "/assignment/employee/{employeeId}/project/{projectId}"
  - DELETE record: "/assignment/employee/{employeeId}/project/{projectId}"
- Employee
  - GET all: "/employee/all"
  - GET one: "/employee/{id}"
  - POST record: "/employee"
    - Example body:
      ```json
      {
        "first-name": "John",
        "last-name": "Doe",
        "address": "123 Fake St.",
        "city": "Fake City",
        "state": "Navada",
        "email": "jdoe@example.com"
      }
      ```
  - PUT first name: "/employee/{id}/first-name"
    - Example body:
      ```json
      {
        "first-name": "Foo"
      }
      ```
  - PUT last name: "/employee/{id}/last-name"
    - Example body:
      ```json
      {
        "last-name": "Bar"
      }
      ```
  - PUT address: "/employee/{id}/address"
    - Example body:
      ```json
      {
        "address": "321 Unknown St."
      }
      ```
  - PUT city: "/employee/{id}/city"
    - Example body:
      ```json
      {
        "city": "Nothing City"
      }
      ```
  - PUT state: "/employee/{id}/state"
    - Example body:
      ```json
      {
        "state": "Ohio"
      }
      ```
  - PUT email: "/employee/{id}/email"
    - Example body:
      ```json
      {
        "email": "jdoe@example.com"
      }
      ```
  - DELETE record: "/employee/{id}"
- Hourly Employee
  - GET all: "/hourly-employee/all"
  - GET one: "/hourly-employee/{id}"
  - POST record: "/hourly-employee/{id}"
    - Example body:
      ```json
      {
        "hourly-rate": "23.45",
        "full-time": true
      }
      ```
  - PUT hourly rate: "/hourly-employee/{id}/hourly-rate"
    - Example body:
      ```json
      {
        "hourly-rate": "32.20"
      }
      ```
  - PUT full time: "/hourly-employee/{id}/full-time"
    - Example body:
      ```json
      {
        "full-time": false
      }
      ```
  - DELETE record: "/hourly-employee/{id}"
- Phone Number
  - GET all: "/phone-number/all"
  - GET numbers by employee: "/phone-number/employee/{employeeId}"
  - GET one: "/phone-number/{phoneId}"
  - POST record: "/phone-number/{employeeId}"
    - Example body:
      ```json
      {
        "phone": "(###) ###-####",
        "type": "mobile",
        "phone-primary": true
      }
      ```
      - Restrictions
        - Phone type accepted values:
          - "mobile"
          - "home"
          - "work"
  - PUT phone number: "/phone-number/{phoneId}/phone"
    - Example body:
      ```json
      {
        "phone": "(###) ###-####"
      }
      ```
  - PUT phone type: "/phone-number/{phoneId}/type"
    - Example body:
      ```json
      {
        "type": "work"
      }
      ```
  - PUT phone primary: "/phone-number/{phoneId}/phone-primary"
    - Example body:
      ```json
      {
        "phone-primary": false
      }
      ```
  - DELETE phone number: "/phone-number/{phoneId}"
- Project
  - GET all: "/project/all"
  - GET one: "/project/{id}"
  - POST record: "/project"
    - Example body:
      ```json
      {
        "name": "Chess App",
        "start-date": "2024-04-23",
        "end-date": "2025-01-12"
      }
      ```
  - PUT name: "/project/{id}/name"
    - Example body:
      ```json
      {
        "name": "Checkers App"
      }
      ```
  - PUT start date: "/project/{id}/start-date"
    - Example body:
      ```json
      {
        "start-date": "2024-05-09"
      }
      ```
  - PUT end date: "/project/{id}/end-date"
    - Example body:
      ```json
      {
        "end-date": "2025-02-17"
      }
      ```
- Salary Employee
  - GET all: "/salary-employee/all"
  - GET one: "/salary-employee/{id}"
  - POST record: "/salary-employee/{id}"
    - Example body:
      ```json
      {
        "salary-rate": "76040.05",
        "full-time": true
      }
      ```
  - PUT salary rate: "/salary-employee/{id}/salary-rate"
    - Example body:
      ```json
      {
        "hourly-rate": "88423.32"
      }
      ```
  - PUT full time: "/salary-employee/{id}/full-time"
    - Example body:
      ```json
      {
        "full-time": true
      }
      ```
  - DELETE record: "/salary-employee/{id}"

## Entity Relationship Diagram

<img src="https://onedrive.live.com/embed?resid=A4F7DF07E85B8310%21336847&authkey=%21AJeU3npT2IiW1mQ&width=716&height=747"
    alt="Markdown Monster icon"
    style="float: left; margin-right: 10px;" />

## What I learned

Entity classes are where you setup the tables for a database. This includes all the relationships and cardinality of those relationships. Annotations are used to name the fields, setup the relationships and add cardinality, as well as to set primary and foreign keys.

I then added the repositories and services to provide the functionality necessary to handle requests. I built the endpoint functions in my service implementations and made sure to include field validation and exception handling. The service functions are able to handle request bodys and are loaded with the neccessary parameters. I then used controllers to call on the functions in my service implementations to handle the request URLs and request bodies and then respond with the appropriate response entities.

The application is prepopulated with some example records for the employee and project entities respectfully. This can allow for immediate experimentation of inserting records, updating values, viewing records, or deleting them. Such functionality can be tested with Postman or Cypress.
