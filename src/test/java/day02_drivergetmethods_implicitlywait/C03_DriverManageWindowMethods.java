package day02_drivergetmethods_implicitlywait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageWindowMethods {
    public static void main(String[] args) throws InterruptedException {

        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        //Sayfanin olculerini yazdirin
        //Sayfayi simge durumuna getirin
        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        //Sayfanin olculerini maximize durumunda yazdirin
        //Sayfayi fullscreen yapin
        //Sayfanin olculerini fullscreen durumunda yazdirin
        //Sayfayi kapatin


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com");

        //Sayfanin olculerini yazdirin
        System.out.println("Sayfanin olculeri :" + driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //Sayfanin olculerini maximize durumunda yazdirin
        System.out.println("Sayfanin olculeri maximize durumunda : " + driver.manage().window().getSize());

        //Sayfayi fullscreen yapin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().fullscreen();

        Thread.sleep(3000);
        //Sayfanin olculerini fullscreen durumunda yazdirin
        System.out.println("Sayfanin olculeri fullscreen durumunda : " + driver.manage().window().getSize());

        //Sayfayi kapatin
        driver.close();

    }
}
