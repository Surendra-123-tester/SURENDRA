package HybridFramework;

public class FrameWorkExplanation {
/*Create a Maven Poject : Click on File>New>Select Maven Project>Select Artifact Id(Select..)>Click on Finish- Maven Project should be created successfully
 *        In a Hybrid Framework (Selenium + TestNG + Excel + Keywords)-Maven plays a key role by:
          Managing dependencies like Selenium, TestNG, Apache POI, and ExtentReports
          Running tests through TestNG XML
          Allowing CI/CD pipelines to trigger tests automatically
          Generating reports after execution
With Maven:Just add dependencies in pom.xml.
           Maven automatically downloads them (and sub-dependencies) from Maven Central Repository.
MyHybridFramework/  : Structure
 ├── src/
 │   ├── main/java/       → Application/Framework code
 │   ├── test/java/       → Test classes (TestNG)
 │   ├── test/resources/  → Test data (Excel, config files)
 │   └── main/resources/  → Property files, drivers
 ├── pom.xml              → Maven configuration file(Can add dependencies)
 └── target/              → Compiled output
Pom.xml :- In a Maven project, the pom.xml file is the core configuration file — it stands for Project Object Model.
	     It tells Maven how to build, configure, and manage dependencies for your Java project.
🔹 Purpose of pom.xml :
         It acts as a blueprint for your project.
	     It contains:Project details (name, version, description)
         Dependencies (external libraries)
         Build configurations (plugins, reports)
         Repositories
         Profiles (different environments)*/
	/*Tag        	Description
	<groupId>	    Unique ID of your organization/project (like a package name)
	<artifactId> 	Name of the project (produced artifact name)
	<version>	    Version of the project (e.g., 1.0.0-SNAPSHOT)
	<packaging>	    Type of project output (jar, war, pom)
	<dependencies>	List of external libraries (e.g., Selenium, TestNG, Apache POI and POI ooxml)
	<build>     	Plugins and compiler settings
	<repositories>	External repositories if dependencies aren’t from Maven Central
🔹 Why pom.xml is Important:
        ✅ Automates dependency management (no need to manually add JARs)
	    ✅ Ensures consistent builds across environments
	    ✅ Handles project lifecycle (compile, test, package, install, deploy)
	    ✅ Makes integration with tools (like Jenkins, Eclipse, IntelliJ) easy
Hybrid Framework : Added dependencies : Selenium &TestNg &Apache POI and POI OOXML dependencies from Maven repositry.(Recent dependecies)
Create a Base Class- it handles browser initialization, configuration loading, waits, and cleanup,allowing your test scripts to stay clean, reusable, and consistent. Set up login & logout 
Create a Page Object Model class -A Page Object Class is a Java class that represents one web page.It stores the locators and actions for that page, allowing test scripts to perform actions without touching Selenium code directly.
 With POM →Uses
Locators and actions are centralized in one place — making the framework:
✅ More organized
✅ Easier to maintain
✅ Highly reusable
Add Constructor(Initialize WebElements , Store locators and Add Active methods
Each Page Object Class usually contains three parts:
Structure of Page Object model:
   Part	            Description
1️⃣ WebElements	    Locators for elements on the page (@FindBy annotations)
2️⃣ Constructor	    Initializes elements using PageFactory.initElements()
3️⃣ Action Methods	Define reusable functions (like login(), clickLogout())
Create a Excel Utility class - In Selenium automation frameworks (especially Hybrid or Data-Driven Frameworks), an Excel Utility class is used to read and write test data from Excel files
What is an Excel Utility Class?-An Excel Utility Class is a reusable helper class that contains methods to read, write, or update data from Excel sheets using Apache POI library.
It helps you to:Store test data externally (instead of hardcoding it in scripts)
                Fetch input values like usernames, passwords, URLs, etc.
                Store output data or results after execution
🔹 Why Use Excel in Selenium?
               ✅ Data-driven testing — Run the same test with multiple sets of data.
               ✅ Centralized data management — Easy to modify test inputs without editing code.
               ✅ Separation of test logic and test data — Makes the framework cleaner and more maintainable.
 🔹 Common Tasks Handled by Excel Utility: 
Operation	         Description
read data	         Get value from a specific cell
write data	         Write or update value in a specific cell
get row count	     Get total number of rows in a sheet
get cell count	     Get total number of cells in a rows
    Feature	       Purpose
    Class Name -   ExcelUtility.java
    Library Used - Apache POI
    Purpose	    -  Read/write Excel test data
    Framework Type-	Data-Driven / Hybrid Framework
    Benefit	- Easy maintenance, reusability, and scalability
 Create a Test Class:
 🔹 What is a Test Class? : A Test Class is the file (Java class) that contains actual test cases —
                            A Test Class in a Hybrid Framework acts as the main test driver —it reads data (from Excel), uses methods (from Page Objects), and performs verifications using TestNG.Test Class focuses only on Test Logic.
                            It’s the main driver of your test execution — it connects: The test data (from Excel),
                                                                                     The business logic (from Page Object classes),
                                                                                     And the test flow (via TestNG annotations like @Test).
🔹 Role of a Test Class in a Hybrid Framework
Component	                    Role
Excel Utility	                Reads input data (like username, password, expected result) and This enables data driven testing(same script with multiple set of data)
Page Object Classes         	Contain reusable WebElement locators & methods (actions) and Keeps code reusable,Clean and Maintainable.
Base Class	                    Sets up browser, URL, waits, and teardown(Close Browser).
Test Class	                    Calls methods from Page Classes, uses Excel data, and performs assertions
🔹 Advantages of Test Classes in a Hybrid Framework
            ✅ Reusability — Common code reused via utilities & page objects
            ✅ Maintainability — Easy to update when application changes
            ✅ Scalability — Add new test classes for new modules easily
            ✅ Data-driven — One test script can handle multiple data sets
            ✅ Clean structure — Logic, data, and objects are separated clearly
 Hybrid Framework Structure :
│
├── base/
│   └── BaseClass.java      → Handles browser setup & config loading
│
├── pages/
│   └── LoginPage.java      → WebElements + Actions for Login page
│   └── HomePage.java       → WebElements + Actions for Home page
│
├── utilities/
│   └── ExcelUtility.java   → Handles Excel data
│
├── testcases/
│   └── LoginTest.java      → Test logic using Page Object methods
│
├── testng.xml              → Controls test execution
└── pom.xml                 → Maven dependencies
   
            */
	
}
