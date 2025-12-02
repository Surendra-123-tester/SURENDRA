package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    private static ExtentReports extent;
    private static String reportPath;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Create timestamp-based report name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + timeStamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("Hybrid Framework Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project Name", "Hybrid Selenium Framework");
            extent.setSystemInfo("Tester", "Surendra Kandula");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Execution Time", timeStamp);
        }
        return extent;
    }

    // ✅ Add this method so TestRunner can access the file path
    public static String getReportPath() {
        return reportPath;
    }
}

