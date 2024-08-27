package day10_basicauthentication_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {

            //Authenticate using the following information:
            // Url: https://the-internet.herokuapp.com/basic_auth
            // Username: admin
            //Password: admin
            // Congratulations! You must have the proper credentials. verify that the post has appeared
            //Click on the Elemental Selenium link
            //Let's test that the header contains Elemental Selenium

            //Aşağıdaki bilgileri kullanarak authentication yapınız:
            //    Url: https://the-internet.herokuapp.com/basic_auth
            //    Username: admin
            //    Password: admin
            //   "Congratulations! You must have the proper credentials." yazısinın çıktığını doğrulayın
            // "Elemental Selenium" linkine tıklayınız
            // Başlığın "Elemental Selenium" içerdiğini test edelim

    @Test
    void test01() {

        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //   "Congratulations! You must have the proper credentials." yazısinın çıktığını doğrulayın
        Assertions.assertEquals("Congratulations! You must have the proper credentials.",driver.findElement(By.tagName("p")).getText());

        // "Elemental Selenium" linkine tıklayınız

        driver.findElement(By.partialLinkText("Elemental Selenium")).click();

        // Başlığın "Elemental Selenium" içerdiğini test edelim

        switchToWindow(1);

        Assertions.assertTrue(driver.getTitle().contains("Elemental Selenium"));

    }
}
