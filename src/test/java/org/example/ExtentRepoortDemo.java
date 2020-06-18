package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentRepoortDemo {
    ExtentReports extent;
    @BeforeTest
    public void config(){
        //ExtentReport, ExtentSparkReporter
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("WebAutomation Result");
        reporter.config().setDocumentTitle("Test Results");

         extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Orhan");
    }
    @Test
    public void intial() {
        extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        extent.flush();
    }
}