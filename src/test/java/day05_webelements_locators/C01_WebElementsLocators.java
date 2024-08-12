package day05_webelements_locators;

import begin.Begin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_WebElementsLocators {


    // Go to Google page
    // Find the search box according to the "name" attribute and type "selenium"
    // Make the call
    // Test that the header contains selenium
    // Print how many links are on the page to the console
    // If the links on the page have text, print them to the console
    // close the page

    // Google sayfasına git
    // "name" özelliğine göre arama kutusunu bulun ve "selenium" yazın
    // Aramayı yap
    // Başlığın selenium içerdiğini test edin
    // Sayfada kaç bağlantı olduğunu konsola yazdır
    // Sayfadaki bağlantılarda metin varsa, bunları konsola yazdır
    // sayfayı kapat



    @Test
    void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver(Begin.beginChrome());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");

        // "name" özelliğine göre arama kutusunu bulun ve "selenium" yazın
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");

        // Aramayı yap
        searchBox.submit();

        // Başlığın selenium içerdiğini test edin
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getTitle().contains("selenium"));

        // Sayfada kaç bağlantı olduğunu konsola yazdır
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi : " + links.size());

        // Sayfadaki bağlantılarda metin varsa, bunları konsola yazdır
        for (WebElement w : links) {
            if (!w.getText().isEmpty())
                System.out.println(w.getText());
        }


        // sayfayı kapat

        driver.quit();

    }
}
