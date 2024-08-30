package practices.day03;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P05 extends TestBase {

    //        Go to amazon  https://www.amazon.com/
    //        Find the total number of cookies
    //        Print all the cookies
    //        Get the cookies by their name
    //        Add new cookie
    //        Delete all cookies

    // Amazon'a git https://www.amazon.com/
    // Toplam çerez sayısını bulun
    // Tüm çerezleri yazdır
    // Çerezleri adlarına göre al
    // Yeni çerez ekle
    // Tüm çerezleri sil









    @Test
    void cookiesTest() {

        // Amazon'a git https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        waitForSecond(3);

        // Toplam çerez sayısını bulun
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Total Cookies : " + allCookies.size());

        System.out.println("-----------------------------------------------");
        // Tüm çerezleri yazdır

        for (Cookie w : allCookies){
            System.out.println("Cookie : " + w);
            System.out.println("Cookie  Name : " + w.getName());
            System.out.println("Cookie  Value : " + w.getValue());
        }

        System.out.println("------------------------------------");

        // Çerezleri adlarına göre al

        System.out.println("Cookie Name'ine gore alindi :"+driver.manage().getCookieNamed("csm-hit"));

        System.out.println("----------------------------------------");


        // Yeni çerez ekle
        Cookie myFavoriteCookie = new Cookie("My Cookie","Cikolatali");
        driver.manage().addCookie(myFavoriteCookie);
        waitForSecond(3);

        for (Cookie w : driver.manage().getCookies()){
            System.out.println(w);
        }


        // Tüm çerezleri sil

        driver.manage().deleteAllCookies();

        driver.manage().deleteCookieNamed(myFavoriteCookie.toString());
        waitForSecond(3);

        System.out.println("Cookie size :  " + driver.manage().getCookies().size());

    }
}
