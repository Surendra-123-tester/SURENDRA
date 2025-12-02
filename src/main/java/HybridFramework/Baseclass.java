package HybridFramework;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import utilities.ExtentManager;

public class Baseclass {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private static String reportFilePath;

    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getInstance();
        reportFilePath = ExtentManager.getReportPath();
    }


    @BeforeClass
    public void setup() {
    	//Headless mode automation
    	//ChromeOptions Options=new ChromeOptions();
    	//Options.addArguments("--headless=new");
    	//driver = new ChromeDriver(Options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(122,787));
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        //Navigate to URL
        //driver.navigate().to("https://testautomationpractice.blogspot.com/");
    }

  
    @AfterMethod
    public void getResult(ITestResult result) {
        try {
            String screenshotPath = ScreenshotUtilityClass.captureScreenshot(driver, result.getName());

            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail("❌ Failed at : " + result.getMethod().getMethodName());
                test.fail(result.getThrowable());
                test.addScreenCaptureFromPath(screenshotPath);
            } 
            else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("✔ Step Passed : " + result.getMethod().getMethodName());
                test.addScreenCaptureFromPath(screenshotPath);
            } 
            else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("⚠ Test Skipped");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @AfterSuite
    public void endReport() {
        extent.flush();  // Write everything to the report

        // Automatically open latest Extent Report in browser
        try {
            File latestReport = new File(System.getProperty("user.dir") + "/Reports");
            File[] reports = latestReport.listFiles();
            if (reports != null && reports.length > 0) {
                File lastModified = reports[0];
                for (File f : reports) {
                    if (f.lastModified() > lastModified.lastModified()) {
                        lastModified = f;
                    }
                }
                Desktop.getDesktop().browse(lastModified.toURI());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            //driver.close();
        }
    }
}

