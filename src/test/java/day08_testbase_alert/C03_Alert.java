package day08_testbase_alert;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alert extends TestBase {

      /*
        Eger bir sayfadaki bir button a tikladiktan sonra bir uyari penceresi cikiyorsa ve bu cikan pencereye inspect yaparak
        locate alamiyorsak, bu bir JS Alert tur.
        JS Alert'u handle edebilmek icin driver'imizi o pencereye gecis yaptirmamiz gerekecek.
        Bunun icin driver object'imiz üzerinden switchTo() methoduyla alert() e gecis yapacağız.
         */

    //   https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    //   Bir metod olusturun: acceptAlert
    //      birinci butona tıklayın,
    //      uyarıdaki OK butonuna tıklayın
    //      result mesajının  “You successfully clicked an alert” oldugunu test edin.

    //Bir metod olusturun: dismissAlert
    //       ikinci butona tıklayın,
    //       uyarıdaki Cancel butonuna tıklayın
    //       result mesajının “successfuly” icermedigini test edin.

    //Bir metod olusturun: sendKeysAlert
    //       ucuncu butona tıklayın,
    //       uyarıdaki  metin kutusuna isminizi yazin,
    //       OK butonuna tıklayın
    //       result mesajında isminizin görüntülendiğini doğrulayın.


    @Test
    void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //birinci butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        //uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();

        // result mesajının  “You successfully clicked an alert” OLDUGUNU test edin.

        String actualResultText = driver.findElement(By.id("result")).getText();
        String expectedResultText = "You successfully clicked an alert";

        Assertions.assertEquals(expectedResultText, actualResultText);

    }

    @Test
    void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //       ikinci butona tıklayın,
        //       uyarıdaki Cancel butonuna tıklayın
        //       result mesajının “successfuly” icermedigini test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //       ikinci butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        //       uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();

        //       result mesajının “successfuly” icermedigini test edin.

        String actualResultText = driver.findElement(By.id("result")).getText();
        String unexpectedResultText = "successfuly";

        Assertions.assertFalse(actualResultText.contains(unexpectedResultText));

    }

    @Test
    void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //       ucuncu butona tıklayın,
        //       uyarıdaki  metin kutusuna isminizi yazin,
        //       OK butonuna tıklayın
        //       result mesajında isminizin görüntülendiğini doğrulayın.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //       ucuncu butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        //       uyarıdaki  metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Niyazi");
        driver.switchTo().alert().accept();

        //       result mesajında isminizin görüntülendiğini doğrulayın.

        String actualResultText = driver.findElement(By.cssSelector("#result")).getText();

        Assertions.assertTrue(actualResultText.contains("Niyazi"));



    }

}
