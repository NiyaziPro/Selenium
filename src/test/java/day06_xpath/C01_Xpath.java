package day06_xpath;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {

    /*
            / -->  Bir alt child'ı seçer
            // --> Sayfadaki herhangi bir web elementi seçer
            @ -->  Bir web elementin attribute 'ünü seçmek için kullanılır.
            [] --> Index veya koşul için kullanılır.
            * --> All, fark etmeksizin seç demektir.


            SYNTAX:

           //tagName[ @ attributeName = 'attributeValue ' ]

          //* [@ * = 'attributeValue'] >>> anlamı şu: tag name fark etmeksizin,
                                                      attribute name fark etmeksizin,
                                                      attributeValue'su ... olan sayfdaki tüm elementleri ver.

         (//tagName [@attributeName = 'attributeValue']) [index]



         */



    @Test
    void test01() throws InterruptedException {
        //go to the web page. https://www.amazon.com/
        //Search “city bike” in the search box (locate the search box with xpath)
        //Print the number of relevant results displayed on Amazon
        //Just print the result number
        //Then click on the text of the first result that appears.
        //close the page

        //web sayfasına gidin. https://www.amazon.com/
        //Arama kutusunda “city bike” aratin (arama kutusunu xpath ile locate edin)
        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        //Sadece sonuc sayısını yazdırınız (1-16 of 843 results for "city bike")
        //Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
        //sayfayi kapatınız


        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        Thread.sleep(5000);

        //Arama kutusunda “city bike” aratin (arama kutusunu xpath ile locate edin)
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));

        searchBox.sendKeys("city bike", Keys.ENTER);

        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        System.out.println("Result Text : " + resultText.getText());


        System.out.println("Number of results : " + resultText.getText().split(" ")[2]);

        driver.findElement(By.xpath("(//h2)[2]/a")).click();

        driver.quit();


    }
}
