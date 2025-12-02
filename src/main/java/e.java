import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class e {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://letcode.in/alert#google_vignette");
	driver.manage().window().maximize();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//button[text()='Confirm Alert']")).click();
	Thread.sleep(4000);
	Alert alt=driver.switchTo().alert();
	alt.accept();
	driver.quit();
}
}