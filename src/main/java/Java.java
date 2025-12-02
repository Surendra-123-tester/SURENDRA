import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Java{
 WebDriver driver;
 public Java(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 @FindBy(xpath="//*[text()='Pagination Web Table']")
 private WebElement PaginationTable;
 public boolean Pagination() {
	 PaginationTable.isDisplayed();
	 return true;
 }
}
