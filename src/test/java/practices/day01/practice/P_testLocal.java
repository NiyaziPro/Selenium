package practices.day01.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P_testLocal {



    @Test
    void name() {
        // Temel URL
        String baseUrl = "https://www.trendyol.com";

        // Dil parametresi eklenmiş URL
        String languageParam = "?language=tr"; // Bu parametre sitenin dil ayarına göre değişebilir
        String fullUrl = baseUrl + languageParam;
        // WebDriver ile siteyi açma
        WebDriver driver = new ChromeDriver();
        driver.get(fullUrl); // URL parametresi ile siteyi aç

        // Örnek: Sayfanın title'ını kontrol etme
        String expectedTitle = "kolye";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));

// Test işlemleri bittiğinde tarayıcıyı kapat
        driver.quit();

    }


}
