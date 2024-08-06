package day02_drivergetmethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        // Go to techproeducation homepage https://www.techproeducation.com/
        // Go to Amazon page. https://www.amazon.com/
        // Go back to techproeducation page
        // Go to Amazon page again
        // Refresh the page
        // Close all pages

        // Techproeducation ana sayfasina gidelim. https://www.techproeducation.com/
        // Amazon sayfasina gidelim. https://www.amazon.com/
        // Tekrar techproeducation sayfasina donelim.
        // Yeniden Amazon sayfasina gidelim.
        // Sayfayi yenileyelim.
        // Tum sayfalari kapatalim.

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // Techproeducation ana sayfasina gidelim. https://www.techproeducation.com/
        driver.navigate().to("https://www.techproeducation.com");
        Thread.sleep(2000);

        // Amazon sayfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

        Thread.sleep(2000);

        // Tekrar techproeducation sayfasina donelim.
        driver.navigate().back(); // bi onceki web sayfasina donme islemi yapar

        Thread.sleep(2000);

        // Yeniden Amazon sayfasina gidelim.
        driver.navigate().forward();

        Thread.sleep(2000);

        // Sayfayi yenileyelim.
        driver.navigate().refresh();

        Thread.sleep(2000);

        // Tum sayfalari kapatalim.
        driver.quit();

        /*
            Javada Thread sleep() kodu, mevcut ıs parcacıgını belırtılen sure kadar duraklatır. Bu KOD HARD WAİT olarak adlandırılır.
            yani kaç milisaniye verirseniz o kadar beklemek zorunda. test uzmanları olarak bizler bu waiti kullanmaktan kacınmalıyız.
            cunku gereksız beklemelere sebep olur. gelecek derslerımızde daha dynmaıc waıtlerı ogrencegız.
        */

    }
}
