package practices.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class P01 extends TestBase {


        //Ebay web sayfasina git "https://www.ebay.com"
        //Sayfanın Title testini yap, title ekrana yazdır
        //Sayfa Title ının "Electronics, Cars, Fashion, Collectibles & More | eBay" olduğunu doğrula
        //Sayfanın URL testini yap. url ekrana yazdır
        //Sayfa Url ini doğrula.
        //Sayfanın kaynak kodlarını ekrana yazdır



    @Test
    void test01() {


        //Ebay web sayfasina git "https://www.ebay.com"
        driver.get("https://www.ebay.com");
        waitForSecond(3);

        //Sayfanın Title testini yap, title ekrana yazdır
        String title = driver.getTitle();
        System.out.println("Title : " + title );

        //Sayfa Title ının "Electronics, Cars, Fashion, Collectibles & More | eBay" olduğunu doğrula

        Assertions.assertEquals("Electronics, Cars, Fashion, Collectibles & More | eBay",title);

        //Sayfanın URL testini yap. url ekrana yazdır
        String url = driver.getCurrentUrl();

        //Sayfa Url ini doğrula.
        Assertions.assertEquals("https://www.ebay.com/",url);

        Assertions.assertTrue(url.contains("ebay.com"));

        //Sayfanın kaynak kodlarını ekrana yazdır

        System.out.println("Page source : " + driver.getPageSource());


    }
}
