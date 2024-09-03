package day14_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C06_ExtentReportTest extends TestBase {

    ExtentReports extentReports; // raporlamayi baslatir
    ExtentHtmlReporter extentHtmlReporter; // raporlamayi html formatinda olusturur
    ExtentTest extentTest; // test adimlarina bilgi ekler

    @Test
    void test01() {

        extentReports = new ExtentReports();
        String date = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm.ss").format(LocalDateTime.now());
        String path = "target\\extentReport\\htmlReport_" + date + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(path);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setDocumentTitle("Test Report");
        extentHtmlReporter.config().setReportName("My Extent Report");

        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Nikko");

        extentTest = extentReports.createTest("TechPro Test", "Test Steps");


        //TechproEducation sayfasina gidelim https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");
        extentTest.info("Kullanici TechPro sayfasina gider.");

        //TechproEducation ana sayfada oldugunuzu dogrulayin
        Assertions.assertEquals("https://www.techproeducation.com/", driver.getCurrentUrl());

        extentTest.info("Kullanici ana sayfada oldugunu dorular.");
        extentTest.pass("Ana Sayfa URL testi basarili.");


        //Ana Sayfada sosyal medya iconlarinin goruntulendigini dogrulayin

        WebElement icons = driver.findElement(By.className("toolbar-sl-share"));

        Assertions.assertTrue(icons.isDisplayed());

        extentTest.info("Kullanici Ana Sayfada sosyal medya iconlarinin goruntulendigini dogrular.");
        extentTest.pass("Iconlar goruntulendi");

        extentReports.flush();



    }
}
