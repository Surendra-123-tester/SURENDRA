package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
   WebDriver driver;

    // Constructor(Initialize WebElements)
    public PageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='name']")
    private WebElement username;
    @FindBy(xpath="//input[@id='email']")
    private WebElement EnterEmail;
    @FindBy(xpath="//input[@id='phone']")
    private WebElement PhoneNo ;
    @FindBy(xpath="//textarea[@id='textarea']")
    private WebElement Address;
    @FindBy(xpath="//input[@id='male']")
    private WebElement Malecheckbox;
    @FindBy(xpath="//input[@id='female']")
    private WebElement FemaleCheckbox;
    @FindBy(xpath="//*[text()='Labels And Links']")
    private WebElement LabelLinks;
    @FindBy(xpath="//*[text()='Simple Alert']")
    WebElement Alert;
    @FindBy(xpath="//button[@id='confirmBtn']")
    WebElement ConfirmAlert;
    @FindBy(xpath="//*[text()='Prompt Alert']")
    private WebElement PromptAlert;
    @FindBy(xpath="//span[@style='left: 0%;']")
    private WebElement Leftslide;
    @FindBy(xpath="//*[text()='New Tab']")
    private WebElement NewWindow;
    @FindBy(xpath="//*[text()='Pagination Web Table']")
	 private WebElement PaginationTable;
	 public boolean Pagination() {
		 PaginationTable.isDisplayed();
		
		 return true;}

    public void enterUsername(String user) {
        username.sendKeys(user);}
    public void EEmail(String user1) 
    {
    	EnterEmail.sendKeys(user1);
    	}
    public void EnterPhoneNo(String user2) {
    	PhoneNo.sendKeys(user2);
    }
    public void enterAddress(String user3) {
    	Address.sendKeys(user3);
    	//Address.clear();
    }
    public void SelectMale() {
    	Malecheckbox.click();
    	
    }
    public void SelectFemale() {
    	FemaleCheckbox.click();
    }
    public boolean Labelslinkstext() {
    	LabelLinks.isDisplayed();
		return true;
    }
    public void Cleartext() {
    	Address.clear();
    }
    public String Gettext() {
    	return LabelLinks.getText();
    }
    public boolean IsEnabled() {
    	return LabelLinks.isEnabled();
    	
    }
    public void IsSelected() {
    	Malecheckbox.isSelected();
    	
    
    }
    public void Alert() {
    	Alert.click();	
    }
   
    
    public void NewWindow() {
    	NewWindow.click();
    	
    	
    }
    
}


