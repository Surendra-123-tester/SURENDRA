package PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v138.page.model.Screenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import HybridFramework.Baseclass;
import HybridFramework.Baseclass;
import utilities.ExcelUtility;

public class Tests extends Baseclass {
  
    ExcelUtility eu = new ExcelUtility();
    PageObjects po;
    HomePage home;
    @Test
    public void testUsername() throws InterruptedException, EncryptedDocumentException, IOException {
        // Start logging in report
        test = extent.createTest("testUsername", "V0erify user interactions on automation practice site");

        try {
        	//Implicitly Wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            po = new PageObjects(driver);
            home=new HomePage(driver);
            // Excel data
            String username = eu.getdatafromexcel("Sheet1", 8, 7);
            String Email = eu.getdatafromexcel("Sheet1", 1, 1);
            String PhoneNo = eu.getdatafromexcel("Sheet1", 1, 2);
            String Address = eu.getdatafromexcel("Sheet1", 1, 3);

            test.log(Status.INFO, "Data fetched from Excel successfully");
             System.out.println("TestingDone");
            // Actions
            po.EEmail(Email);
            po.enterUsername(username);
            po.EnterPhoneNo(PhoneNo);
            po.enterAddress(Address);
            po.SelectMale();
            po.SelectFemale();
            //Actions Class
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Actions action=new Actions(driver);
            //Find Element & Actions Class
            WebElement Pagination=driver.findElement(By.xpath("//*[text()='Pagination Web Table']"));
            //Point Point= Pagination.getLocation();
          Dimension Point= Pagination.getSize();
          System.out.println(Point);
                         int Height=Point.getHeight();
           
            System.out.println(Height);
            
    		
            action.moveToElement(Pagination).perform();
            Boolean Yes=home.Pagination();
            System.out.println(Yes);
             String yes=home.Tabs();
             System.out.println(yes);
             action.contextClick(Pagination).build().perform();
             //JavaScriptExecutor
             JavascriptExecutor js=(JavascriptExecutor)driver;
             js.executeScript("arguments[0].scrollIntoView(true)", Pagination);
             //Dynamic button handling
             home.Dynamicbutton();
           
            // Window handling example
            String ParentWin = driver.getWindowHandle();
            System.out.println(ParentWin);
            po.NewWindow();
            //Handling multiple windows and switching between child and Parent windows
            Set<String> allWindows = driver.getWindowHandles();
            System.out.println(allWindows);           
            for (String handle : allWindows) {
                if (!handle.equals(ParentWin)) {
                    driver.switchTo().window(handle);
                    test.log(Status.INFO, "Switched to new window: " + driver.getTitle());
                    driver.close();
                }
            }
            driver.switchTo().window(ParentWin);
           
            // Dropdown handling using Select class
            //Fluent wait
            Wait<WebDriver>fluent=new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
            WebElement countryDrop=fluent.until(driver->driver.findElement(By.id("country")));
            Select select = new Select(countryDrop);
            select.selectByVisibleText("United Kingdom");
            test.log(Status.PASS, "Dropdown handled successfully");
            //Asssertions
            home.Assertions();
            test.log(Status.PASS, "Assertions handled successfully");
            // Simple Alert handling
            po.Alert();
            driver.switchTo().alert().accept();
            //Confirmation alerts handling
            home.ConfirmationAlert();
            //Prompt alert handling
            home.PromptAlert();
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("C:\\Users\\MY PC\\Desktop\\Automations_Screenshot.png") );
            test.log(Status.PASS, "Alert handled successfully");
            //ClassName locator 
            
            WebElement FireFox=driver.findElement(By.className("firefox-memory"));
            //ExplcitWait
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(FireFox)).click();
            wait.until(ExpectedConditions.visibilityOf(FireFox));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='firefox-memory']")));
            String Frefo=FireFox.getText();
        	System.out.println("Frefo"+Frefo);
            //Find Elements and Tagname locator
        	//Thread sleep-Static wait- provided by Java
        	Thread.sleep(10);
            List<WebElement>Links=driver.findElements(By.tagName("a"));
            System.out.println(Links.size());
            for(WebElement Link:Links) {
            	System.out.println(Link.getText());
            
            }
            
            

            test.log(Status.PASS, "Test completed without errors");
        
        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed due to exception: " + e.getMessage());
            throw e;
            
        }
    }
	private void withTimeOut(Duration ofSeconds) {
		// TODO Auto-generated method stub
		
	}
	private Function Expectedcondtions() {
		// TODO Auto-generated method stub
		return null;
	}
}
