# Alx Automation with Framework Selenium/Java

## Description
**AlxAutomation** is an automated testing project using **Selenium**, **Cucumber**, and **ExtentReports** to automate tests on the ALX intranet site. This project includes tests for login, curriculums, planning, profile, projects, and project search functionalities.

## Prerequisites
- **JDK 11 or higher**
- **Maven**
- **ChromeDriver** (adjust the path if necessary)
- **Google Chrome browser**
- **Selenium Webdriver**
  - Major focus (20 hours+ content)
  - Strategy to handle Rich Web UI using Advanced WebDriver
  - Real-time challenges we face in WebDriver and solutions to handle them
  - Live projects on Selenium
- **TestNG**
- **JUnit**
- **Jenkins**
- **Log4j**
- **Test Execution reports**
- **Cucumber**
- **Data-driven framework**
- **Hybrid Framework**
- **Page Object Model Framework**
- **Performance testing with Selenium**
- **Mobile Automation basics only!**
- **Framework Design from scratch** (TestNG, ANT, PageObject, Maven, Jenkins, Excel, Datadriven, Cucumber, log4j, Client html reports)

All the Best! Happy Testing :)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/UploAutomation.git
   cd Alx-FrameworkSeleniumAutomation

## Project Structure
  - src/main/java: Contains the main classes and page objects.
  - src/test/java: Contains the test files and Cucumber step definitions.
  - src/test/resources: Contains configuration files and browser drivers.

## Maven Dependencies
The pom.xml file includes the following dependencies:
  1. Selenium (Java, ChromeDriver, IEDriver, FirefoxDriver)
  2. Cucumber (Java, JUnit, PicoContainer)
  3. ExtentReports
  4. Log4j
  5. SLF4J
  6. TestNG
  7. Spring Context
  8. Oracle JDBC

## Features
1. **Login : Scenario: Successful login**
  - Navigates to the login page.
  - Enters valid credentials.
  - Clicks the sign-in button.
  - Redirects to the dashboard.
  - Takes a screenshot of the dashboard.
    
2. **Curriculums : Scenario: Show Curriculums ALX**
  - Navigates to the login page.
  - Enters valid credentials.
  - Clicks the curriculums icon.
  - Displays the transcript and overview.
  - Takes a screenshot of the overview.
    
3. **Planning : Scenario: Show Planning ALX**
  - Navigates to the login page.
  - Enters valid credentials.
  - Clicks the planning icon.
  - Displays the projects for the day.
  - Takes a screenshot of the planning view.
    
4. **Profile : Scenario: Show and Update Profile ALX**
  - Navigates to the login page.
  - Enters valid credentials.
  - Clicks the profile icon.
  - Changes the profile picture.
  - Saves the information and displays a success message.
  - Takes a screenshot of the updated profile.
   
5. **Projects : Scenario: Show Projects ALX**
  - Navigates to the login page.
  - Enters valid credentials.
  - Clicks the projects icon.
  - Displays the last projects.
  - Takes a screenshot of the projects.
    
6. **Project Search : Scenario: Search Project ALX**
  - Navigates to the login page.
  - Enters valid credentials.
  - Clicks the search icon.
  - Enters the project name "Pitch".
  - Takes a screenshot of the search results.

## Running Tests
To start the project, there are three options:
  1. Use the Maven command to run the Cucumber tests, use the following command:
        **mvn clean test -Dcucumber.options="--tags @run"**
  2. Use the Eclipse editor or the main TestRunner class.
  3. Use continuous integration with **Jenkins**. I have integrated a **job in Jenkins** to automatically execute the code.

## Test Report
The project uses ExtentReports to generate detailed HTML reports. The reports will be generated in the reports directory at the root of the project.

## Configuration
Browser configurations and other settings can be adjusted in the src/test/resources/environment/config.properties file.

## Screenshots
Screenshots of failed tests and specific steps are saved in the src/test/resources/Screenshots directory.

## Logging
The project uses Log4j for logging. Log files are saved in the logs directory.

## Example or Screenshots
Please refer to the following video to see the project in action: 

(https://drive.google.com/file/d/1qbg7oHbBYxgU9PQYpW63H9vLqiqNc3ps/view?usp=sharing)

## Authors
**Zouhair Barta**
