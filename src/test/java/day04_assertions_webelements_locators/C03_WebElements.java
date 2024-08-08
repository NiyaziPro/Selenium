package day04_assertions_webelements_locators;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElements {


        //Go to Amazon page
        //Locate the search box and print and search for "iPhone"
        //close the page

        //Amazon sayfasına gidiniz
        //Arama kutusunu locate ediniz ve "iphone" yazdırıp aratınız
        //Sayfayı kapatınız


    @Test
    void test01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.de");

        /*
            <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
            autocomplete="off" placeholder="Search Amazon" class="nav-input nav-progressive-attribute"
            dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">

         */


        //Arama kutusunu locate ediniz ve "iphone" yazdırıp aratınız

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // "iphone" yazdırıp aratınız

        searchBox.sendKeys("iphone");

        /*
            Bir arama kutusuna locate edip text gönderirsek iki şekilde ENTER TUSUNA BASIP ARATABİLİRİZ, gönderebiliriz.
            1) submit() methodu
            2) Keys.ENTER

            Eger almis oldugumuz locate i sadece BIR kere kullanacaksak; sepete koymadan da yapabiliriz

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
        */


        // 1.yontem : iPhone yazisini arattik
        searchBox.submit();

        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();

        // 2.yontem : iPhone yazisini arattik

        searchBox.sendKeys("Macbook Pro M3",Keys.ENTER);

        // Search By.name

        driver.findElement(By.name("field-keywords")).sendKeys("air pods max",Keys.ENTER);


        driver.close();



    }






}
