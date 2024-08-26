package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

                //On Windows 1, go to https://www.techproeducation.com
            //Verify that the title contains "TechPro Education"
            //Open https://www.youtube.com in Windows 2 (in a new window)
            //In Windows 3 (in a new window), open https://www.linkedin.com
            //Go to the techproeducation page,
            //go to youtube page,
            //Go to LinkedIn page

            //Window 1'de https://www.techproeducation.com adresine gidiniz
            //Başlığın "TechPro Education" icerdigini doğrulayın
            //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
            //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
            //techproeducation sayfasına geçiniz,
            //youtube sayfasına geçiniz,
            //linkedIn sayfasına geçiniz

            /*
        1-driver.switchTo().newWindow(Window.WINDOW) ==> yeni bir pencere acar ve driver ile birlikte buraya gecis yapar
        2-driver.switchTo().newWindow(Window.TAB) ==> yeni bir SEKME acar ve driver ile birlikte buraya gecis yapar
        3-driver.switchTo().window(String handleDegeri) ==> Eger handle degeri ile acik olan bir sayfaya gecis yapmak istersek
        parantez icinde gecis yapmak istedigimiz sayfanin handle değerini belirtiriz
         */


    @Test
    void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        String techproHandleValue = driver.getWindowHandle();

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        String youtubeHandleValue = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        String linkedinandleValue = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz,

        driver.switchTo().window(techproHandleValue);
        waitForSecond(2);

        //youtube sayfasına geçiniz,

        driver.switchTo().window(youtubeHandleValue);

        waitForSecond(2);

        //linkedIn sayfasına geçiniz

        driver.switchTo().window(linkedinandleValue);


    }

    @Test
    void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        String techproHandleValue = driver.getWindowHandle();

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");

        String youtubeHandleValue = driver.getWindowHandle();

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");

        String linkedinandleValue = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz,

        driver.switchTo().window(techproHandleValue);
        waitForSecond(2);

        //youtube sayfasına geçiniz,

        driver.switchTo().window(youtubeHandleValue);

        waitForSecond(2);

        //linkedIn sayfasına geçiniz

        driver.switchTo().window(linkedinandleValue);
    }
}
