package day15_extentreport_webtables_excel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReportTest extends TestBase {

    //Go to Amazon page
    //Search selenium in the search box
    //Verify that the page title contains selenium

        //Amazon sayfasına gidelim
    //Arama kutusunda laptop aratalim
    //Sayfa basliginin selenium icerdigini doğrulayalim
    @Test
    void test01() {

        createExtentReport("Amazon Title Test","Nikko");

        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        extentTest.info("Kullanici amazon.com sayfasina gider.");
        waitForSecond(4);

        addScreenShotToReport();

        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();
        extentTest.info("Arama kutusuna selenium yazip aratildi");

        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        addScreenShotOfWebElementToReport(searchBox);

        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assertions.assertTrue(driver.getTitle().contains("laptop"));
        extentTest.pass("Sayfa basliginin selenium icerdigini doğrulandi");

        extentReports.flush();

    }
}
