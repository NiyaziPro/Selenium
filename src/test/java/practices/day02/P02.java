package practices.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class P02 extends TestBase {

            // https://testpages.herokuapp.com/styled/calculator
            // ilk kutucuga 30 gir
            // ikinci kutucuga 15 gir
            // calculate'e tıkla
            // sonucu yazdır
            // sayfayı kapat

    @Test
    void plusTest() {

        driver.get("https://testpages.herokuapp.com/styled/calculator");
        // ilk kutucuga 30 gir
        driver.findElement(By.id("number1")).sendKeys("30");
        // ikinci kutucuga 15 gir
        driver.findElement(By.id("number2")).sendKeys("15");
        // calculate'e tıkla
        driver.findElement(By.id("calculate")).click();
        // sonucu yazdır
        System.out.println("Answer :  " + driver.findElement(By.id("answer")).getText());
        // sayfayı kapat
        // Testbase otomatik kapatiyor :)

        Assertions.assertTrue(driver.findElement(By.id("answer")).getText().equals("45"));



    }

    @Test
    void minusTest() {

        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 80 gir
        driver.findElement(By.id("number1")).sendKeys("80");

        // ikinci kutucuga 20 gir
        driver.findElement(By.id("number2")).sendKeys("20");

        selectIndex(driver.findElement(By.id("function")),2 );

        // calculate'e tıkla
        driver.findElement(By.id("calculate")).click();

        // sonucu yazdır
        System.out.println("Answer :  " + driver.findElement(By.id("answer")).getText());

    }
}
