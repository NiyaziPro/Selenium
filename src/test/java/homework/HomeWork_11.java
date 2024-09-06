package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class HomeWork_11 extends TestBase {

    //  "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin.
    //  Ajax Yükleyici üzerine tıklayın
    //  "Click Me!" butonuna tıklayın
    //  Düğmenin tıklandığını doğrulayın
    //  Her adımdan sonra ekran görüntüsü alın ve rapora ekleyin


    @Test
    void testClickButton() {
        createExtentReport("Test Click Button", "Niyazi");

        //  "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin.
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        extentTest.info("Kullanici http://webdriveruniversity.com/Popup-Alerts/index.html sayfasina gider.");
        addScreenShotToReport();

        //  Ajax Loader üzerine tıklayın
        driver.findElement(By.xpath("//p/a")).click();
        extentTest.info("Kullanici Ajax Loader Click Me butonuna tiklar");
        addScreenShotToReport();

        //  "Click Me!" butonuna tıklayın
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement clickMeButton = driver.findElement(By.id("button1"));
        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton)).click();
        extentTest.info("Kullanici 'Click Me!' butonuna tıklar.");

        addScreenShotToReport();

        //  Düğmenin tıklandığını doğrulayın //

        WebElement alertMsg = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(alertMsg));

        Assertions.assertEquals("Well Done For Waiting....!!!", alertMsg.getText(), "Button'a tiklanamadi!!!");
        extentTest.pass("Düğmeye tıklandı.");


        //  Her adımdan sonra ekran görüntüsü alın ve rapora ekleyin
        addScreenShotToReport();

        extentReports.flush();
    }

}
