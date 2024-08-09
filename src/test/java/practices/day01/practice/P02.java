package practices.day01.practice;

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

public class P02 {

    //https://stackoverflow.com/ sitesine gidin
    //Sitenin sayfa başlığını ve url'ini yazdırın
    //Title ve url'inin "Stack" kelimesini içerip içermediğini kontrol edin
    //https://www.amazon.com/ sitesine gidin
    //Sitenin sayfa başlığını alın ve "Amazon" kelimesini içerip içermediğini test edin
    //Bir önceki web sayfasına geri dönün
    //Sayfayı yenileyin
    //Bir sonraki sayfaya tekrar gidin
    //Sayfayı kapatın

    //Go to https://stackoverflow.com/
    //Print the page title and url of the site
    //Check if the title and url contain the word "Stack"
    //Go to https://www.amazon.com/
    //Take the page title of the site and test if it contains the word "Amazon"
    //Go back to the previous web page
    //Refresh the page
    //Go to the next page again
    //Close the page

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void testCom() throws InterruptedException {

        driver.get("https://stackoverflow.com/");


        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println("Sayfa başlığı : " +  title);
        System.out.println(" Sayfa  url'si :  " + url);

        Assertions.assertTrue(title.contains("Stack"));
        Assertions.assertTrue(url.contains("stack"));

        driver.get("https://amazon.com/");


        String titleAmazon = driver.getTitle();
        Assertions.assertTrue(titleAmazon.contains("Amazon"));
        Assertions.assertFalse(titleAmazon.contains("Stack")); // negatif senaryo

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        driver.quit();

    }
}
