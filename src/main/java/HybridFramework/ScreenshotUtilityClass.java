package HybridFramework;
    import java.io.File;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import org.openqa.selenium.*;
	import org.apache.commons.io.FileUtils;

	
	public class ScreenshotUtilityClass {
	    public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String path = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + timestamp + ".png";

	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File dest = new File(path);
	            FileUtils.copyFile(src, dest);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return path;
	    }
	}


