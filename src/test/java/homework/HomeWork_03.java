package homework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HomeWork_03 extends TestBase {
    /*
    ========================Homework 3=============================
                - http://szimek.github.io/signature_pad/ sayfasına gidiniz
                - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
                - Çizimden sonra clear butonuna basınız
                - Sayfayi kapatiniz
     */


    @Test
    void test01() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        WebElement canvasElement = driver.findElement(By.tagName("canvas"));

        // - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        Actions builder = new Actions(driver);
        builder.clickAndHold(canvasElement)
                .moveByOffset(50, 50)
                .moveByOffset(-100, 0)
                .moveByOffset(50, -50)
                .moveByOffset(0,-100)
                .release()
                .perform();

        waitForSecond(3);

        // - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[contains(text(), 'Clear')]")).click();

        waitForSecond(2);
        // - Sayfayi kapatiniz
        // TestBase Class'i otomatik sayfayi kapatiyor :)

        driver.close();
    }
}
