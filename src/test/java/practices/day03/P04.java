package practices.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {
    //    Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    //    Click "Choose File" button
    //    Type "My File" into "Notes about the file" input
    //    Select the file to upload
    //    Click on "Press" button
    //    Assert that "Your notes on the file were" equals "My File"
    //    Assert that file Content contains "Hello, I am uploaded file"


    //    "https://cgi-lib.berkeley.edu/ex/fup.html" adresine gidin
    //    "Dosya Seç" düğmesine tıklayın
    //    "Dosya hakkında notlar" girişine 'Dosyam' yazın
    //    "Basın" düğmesine tıklayın
    //    "Dosyam" isminin ekranda görüldüğünü doğrulayın
    //    "Merhaba, dosya yüklüyorum" mesajının görüldüğünü doğrulayın


    @Test
    void fileUploadTest() {

        //    "https://cgi-lib.berkeley.edu/ex/fup.html" adresine gidin
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        waitForSecond(3);

        //    "Dosya Seç" düğmesine tıklayın

        String dynamicPath = System.getProperty("user.home") + "\\Desktop\\Batch001.txt";
        driver.findElement(By.name("upfile")).sendKeys(dynamicPath);

        //    "Dosya hakkında notlar" girişine 'Dosyam' yazın
        driver.findElement(By.name("note")).sendKeys("Dosyam");

        //    "Press" düğmesine tıklayın
        driver.findElement(By.xpath("//input[@value='Press']")).click();
        waitForSecond(4);
        //    "Dosyam" isminin ekranda görüldüğünü doğrulayın
        String actualFileName = driver.findElement(By.tagName("blockquote")).getText();

        Assertions.assertEquals("Dosyam",actualFileName);

        //    "Merhaba, dosya yüklüyorum" mesajının görüldüğünü doğrulayın

        String succesMessage = driver.findElement(By.tagName("pre")).getText();

        Assertions.assertTrue(succesMessage.contains("uploaded file"),"Hata! Mesaj Goruntulenemedi!");

    }
}
