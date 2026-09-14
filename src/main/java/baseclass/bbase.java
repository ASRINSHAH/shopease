package baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class bbase {
	public static WebDriver driver;
	public String url="https://ethicfin.cloud/testermachineround/index.php/login";
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	@BeforeTest
	
	
    public void setUp() {

        // Extent Report
        reporter = new ExtentSparkReporter("./Report/facebook.html");

        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Test");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Hostname", "localhost");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Tester Name", "Asrin shah MB");
        extent.setSystemInfo("Browser Name", "Chrome");

        // Browser setup
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(40));

        driver.get(url);
    }

    @AfterMethod
    public void browserClose(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL,
                    "Test case failed: " + result.getName());

            test.log(Status.FAIL,
                    "Reason: " + result.getThrowable());

            String screenshotPath =
                    screenshotmethod(driver, result.getName());

            test.addScreenCaptureFromPath(screenshotPath);
        }

        else if (result.getStatus() == ITestResult.SKIP) {

            test.log(Status.SKIP,
                    "Test case skipped: " + result.getName());
        }

        else if (result.getStatus() == ITestResult.SUCCESS) {

            test.log(Status.PASS,
                    "Test case passed: " + result.getName());
        }
    }

    public static String screenshotmethod(
            WebDriver driver,
            String screenshotname) throws IOException {

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String destination =
                "./Report/Screenshot/" + screenshotname + ".png";

        File dest = new File(destination);

        // Create folder if it doesn't exist
        dest.getParentFile().mkdirs();

        FileHandler.copy(src,dest);

        return dest.getAbsolutePath();
    }

    @AfterTest
    public void teardown() {

        extent.flush();

        if (driver != null) {
           
        }
    }

	}

