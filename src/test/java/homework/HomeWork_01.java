package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class HomeWork_01 extends TestBase {

    /*
            ========================Homework 1==============================================
         -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        -Çıkan alert'te iptal butonuna basınız
        -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        -Çıkan mesajı konsola yazdırınız
        -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
     */

    @Test
    void test01() {

        //http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        waitForSecond(3);

        //Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

        waitForSecond(3);

        //Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println("Alert : " + driver.switchTo().alert().getText());
        waitForSecond(3);
        driver.switchTo().alert().accept();

        waitForSecond(3);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.cssSelector("button[onclick='confirmbox()']")).click();

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        waitForSecond(3);
        
        // -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();

        // -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Niyazi");
        waitForSecond(3);
        driver.switchTo().alert().accept();

        // -Çıkan mesajı konsola yazdırınız
        String actualResult = driver.findElement(By.id("demo1")).getText();
        System.out.println("Çıkan mesaj : " + actualResult);

        // -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız

        Assertions.assertEquals("Hello Niyazi How are you today",actualResult);
    }
}
