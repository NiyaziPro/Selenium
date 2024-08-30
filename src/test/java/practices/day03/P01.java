package practices.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P01 extends TestBase {

    //      When Navigate to https://testpages.herokuapp.com/styled/windows-test.html
    //      When Click on "Alerts In A New Window From JavaScript"
    //      And Switch to new window
    //      And Click on "Show alert box" button
    //      And Accept alert
    //      And Click on "Show confirm box" button
    //      And Cancel alert
    //      Then Assert that alert is cancelled
    //      When Click on "Show prompt box" button
    //      And Send "Hello selenium!" to the alert
    //      Then Assert that "Hello selenium!" is sent

    //     https://testpages.herokuapp.com/styled/windows-test.html adresine git
    //     Alerts In A New Window From JavaScript" üzerine tıkla
    //     Yeni pencereye geç
    //     "Show alert box" düğmesine tıkla
    //      Uyarıyı kabul et
    //     "Show confirm box" düğmesine tıklayın
    //     Uyarıyı iptal et
    //     Ardından uyarının iptal edildiğini doğrulayın
    //     "Show prompt box" düğmesine tıkla
    //     Uyarıya "Hello selenium!" metnini gönderin
    //     "Hello selenium!" metninin gönderildiğini doğrulayın

    @Test
    void test01() {
        //     https://testpages.herokuapp.com/styled/windows-test.html adresine git
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        waitForSecond(3);
        //     Alerts In A New Window From JavaScript" üzerine tıkla
        driver.findElement(By.id("goalerts")).click();

        waitForSecond(2);
        //     Yeni pencereye geç
        switchToWindow(1);

        //     "Show alert box" düğmesine tıkla
        driver.findElement(By.id("alertexamples")).click();

        waitForSecond(2);
        //      Uyarıyı kabul et

        driver.switchTo().alert().accept();

        //     "Show confirm box" düğmesine tıklayın
        driver.findElement(By.id("confirmexample")).click();

        waitForSecond(2);
        //     Uyarıyı iptal et
        driver.switchTo().alert().dismiss();

        //     Ardından uyarının iptal edildiğini doğrulayın
        Assertions.assertEquals("You clicked Cancel, confirm returned false.",driver.findElement(By.id("confirmexplanation")).getText());

        Assertions.assertTrue(driver.findElement(By.id("confirmreturn")).getText().contains("false"));
        waitForSecond(2);
        //     "Show prompt box" düğmesine tıkla
        driver.findElement(By.id("promptexample")).click();

        waitForSecond(2);
        //     Uyarıya "Hello selenium!" metnini gönderin
        driver.switchTo().alert().sendKeys("Hello selenium!");
        driver.switchTo().alert().accept();

        //     "Hello selenium!" metninin gönderildiğini doğrulayın
        Assertions.assertEquals("Hello selenium!",driver.findElement(By.id("promptreturn")).getText());
    }
}
