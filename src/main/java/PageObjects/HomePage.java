package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {
	WebDriver driver;
	  
	
	
	
	 public HomePage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//*[text()='Pagination Web Table']")
	 private WebElement PaginationTable;
	 @FindBy(xpath="//*[text()='Tabs']")
	 WebElement Tab;
	 @FindBy(xpath="//*[@onclick='toggleButton(this)']")
	 WebElement Dynamicbutton;
	 @FindBy(xpath="//*[text()='Confirmation Alert']")
	 private WebElement ConfirmationAlert;
	 @FindBy(xpath="//*[text()='Prompt Alert']")
	 private WebElement PromtAlert;
	 public void PromptAlert() {
		 PromtAlert.click();
		 Alert prompt=driver.switchTo().alert();
		 prompt.accept();
		 //prompt.sendKeys("yes");
	 }
	 public void ConfirmationAlert() {
		 ConfirmationAlert.click();
		 
		 Alert alert=driver.switchTo().alert();
		 alert.dismiss();
		 }
	 
	 public void Dynamicbutton() {
		 Actions act=new Actions(driver);
		 act.doubleClick(Dynamicbutton).perform();
	 }
	 public boolean Pagination() {
		 PaginationTable.isDisplayed();
		
		 return true;
		 }
	 
	 //Hard Assert and SoftAssert
	 public void Assertions() {
		 String actual=PaginationTable.getText();
		 String expected="Pagination Web Table";
		 try {
		 Assert.assertEquals(actual,expected);
		 System.out.println("Passed");
		 }catch (AssertionError e){
			 System.out.println("Failed");
			 throw e;	
		 }
		 SoftAssert soft=new SoftAssert();
		 try {
		 soft.assertEquals(actual, expected);
		 System.out.println("Passed");}
		 catch (AssertionError f) {
			 System.out.println("Failed");
			 throw f;
		 }
		 
		 
	 }
    public String Tabs() {
     return Tab.getText();
    
		 
}}
