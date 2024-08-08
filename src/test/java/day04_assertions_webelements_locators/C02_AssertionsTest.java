package day04_assertions_webelements_locators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AssertionsTest {

    // Go to Google Website
    //Verify that the page title is "Google"
    // Close the page

    // Go to Google Website
    // Verify that the page url is "https://www.google.com/"
    // Close the page

    // Google Web sitesine gidin.
    // Sayfa başlığının "Google" olduğunu doğrulayın.
    // Sayfayı kapatın.

    // Google Web sitesine gidin.
    // Sayfa url'si "https://www.google.com/" olduğunu doğrulayın.
    // Sayfayı kapatın.

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
    }

    @Test
    void testPageTitle() {
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    void testUrl() {

        Assertions.assertEquals("https://www.google.com/",driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
