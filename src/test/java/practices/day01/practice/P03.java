package practices.day01.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {



//   ChromeDriver kullanarak, facebook sayfasina gidin
//   sayfa basliginin (title) "Facebook"icerdigini dogrulayin,
//   Sayfa URL'inin "facebook"kelimesi icerdigini dogrulayin,
//   https://testcenter.techproeducation.com/ sayfasina gidin.
//   Sayfa basliginin "Automation Engineer"icerdigini dogrulayin.
//   Sayfa URL'inin "techproeducation"kelimesi icerdigini dogrulayin,
//   "Back to TechProEducation.com" butonunun görüntülendigini doğrulayin
//   "Back to TechProEducation.com" butonunun üzerindeki yazinin TechProEducation icerdigini doğrulayin
//   Tekrar "facebook"sayfasina donun
//   Geri döndüğünüzü doğrulayin.
//   Sayfayi kapatin

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void testCom() {

        driver.get("https://facebook.com/");

        Assertions.assertTrue(driver.getTitle().contains("Facebook"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("facebook"));

        driver.get("https://testcenter.techproeducation.com/");

        Assertions.assertTrue(driver.getTitle().contains("Automation Engineer"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("techproeducation"));

        // <a class="btn btn-primary btn-lg" target="_blank" href="index.php?page=techproeducation"
        // type="button">Back to TechProEducation.com</a>

        WebElement backButton = driver.findElement(By.linkText("Back to TechProEducation.com"));

        //driver.findElement(By.partialLinkText("TechProEducation"));

        Assertions.assertTrue(backButton.isDisplayed());

        Assertions.assertTrue(backButton.getText().contains("TechProEducation"));

        driver.navigate().back();

        Assertions.assertEquals("https://www.facebook.com/",driver.getCurrentUrl());

        driver.quit();

        }

}
