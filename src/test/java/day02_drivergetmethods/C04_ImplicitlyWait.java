package day02_drivergetmethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ImplicitlyWait {
    public static void main(String[] args) {


        //Go to TechProEducation page
        //test that the page title contains "TechPro Education"
        //go to facebook page
        //test that the page url contains "facebook"
        //go back to techpro page
        //Test that you are back
        //close the page

        //techpro sayfasina gidiniz
        //sayfa basliginin "TechPro Education" icerdigini test ediniz
        //facebook sayfasina gidiniz
        //sayfa url'inin "facebook" icerdigini test ediniz
        //techpro sayfasina geri donunuz
        //geri dondugunuzu test ediniz
        //sayfayi kapatiniz


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com");

        //sayfa basliginin "TechPro Education" icerdigini test ediniz
        String expectedData = "TechPro Education";
        String actualData = driver.getTitle();

        if (actualData.contains(expectedData)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        //facebook sayfasina gidiniz
        driver.get("https://www.facebook.com");

        //sayfa url'inin "facebook" icerdigini test ediniz
        String expectedData1 = "facebook";
        String actualData1 = driver.getCurrentUrl();

        if (actualData1.contains(expectedData1)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        //techpro sayfasina geri donunuz
        driver.navigate().back();

        //geri dondugunuzu test ediniz
        //Birinci yol

        if (driver.getTitle().equals("TechPro Education IT Programs")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        // Ikinci yol - url ile https://www.techproeducation.com/

        if (driver.getCurrentUrl().equals("https://www.techproeducation.com/")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        //sayfayi kapatiniz
        driver.close();

    }
}
