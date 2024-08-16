package practices.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P05 extends TestBase {

            //Belirtilen url e git  https://techproeducation.com/
            //Ana sayfadaki tüm programların bir listesini alın
            // Listenin 'Fırsatlar' içerdiğini doğrulayın
            // 'Programlar' bağlantısına tıklayın
            // arama kutusuna tıklayın

    @Test
    void test01() {

        //Belirtilen url e git  https://techproeducation.com/
        driver.get("https://techproeducation.com/");

        //Ana sayfadaki back menu tüm programların bir listesini alın
        List<WebElement> homePageLinks = driver.findElements(By.cssSelector("#backmenu"));

        for (WebElement w : homePageLinks){
            System.out.print(w.getText() + " ");
            // Listenin 'Opportunities' içerdiğini doğrulayın
            Assertions.assertTrue(w.getText().contains("Opportunities"));
        }


        // 'Programs' bağlantısına tıklayın
        driver.findElement(By.linkText("Programs")).click();

        // Programlar baglantisina geldigini dogrula
        Assertions.assertTrue(driver.getCurrentUrl().equals("https://www.techproeducation.com/programs"));

        // arama kutusuna tıklayın

        // automation yazisini yazalim
        driver.findElement(By.id("searchHeaderInput")).sendKeys("automation",Keys.ENTER);




    }
}
