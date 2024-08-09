package practices.day01.practice;

import begin.Begin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    // https://www.trendyol.com/ sitesine gidin
    // WebElement olarak arama kutusunu bulun ve "kolye" yazdırıp, aratın.
    // Sayfa başlığını ve url'ini yazdırın
    // Title ve url'inin "kolye" kelimesini içerip içermediğini kontrol edin
    // Ana sayfaya geri dönün
    // Sayfayı yenileyin
    // Tarayıcıyı kapatın


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver(Begin.beginChrome());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void testcomTrendyol() throws InterruptedException {

        driver.get("https://www.trendyol.com/");
        Thread.sleep(5000);

        WebElement searchBox = driver.findElement(By.className("search-bar"));
        searchBox.sendKeys("kolye", Keys.ENTER);

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        System.out.println("Sayfa başlığı : " +  title);
        System.out.println(" Sayfa  url'si :  " + url);

        Assertions.assertTrue(title.contains("kolye"));
        Assertions.assertTrue(url.toLowerCase().contains("kolye"));


        driver.navigate().back();

        driver.navigate().refresh();


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
