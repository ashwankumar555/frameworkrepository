package akhiraacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

    ExtentReports extent;

    // This method sets up the report and returns the configured ExtentReports object
    public ExtentReports config() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Akhira");

        return extent;
    }

    @Test
    public void initialDemo() {
        // Call the config method to initialize and set up ExtentReports properly
        extent = config();

        // Now create the test
        ExtentTest test = extent.createTest("Initial Demo");

        // Your test logic
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        System.out.println(driver.getTitle());

        // Log into the report
        test.pass("Navigated to saucedemo.com");

        // Always flush at the end
        extent.flush();

        // Close the browser
        driver.quit();
    }
}
