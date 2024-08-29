package day12_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C04_Robot extends TestBase {

    @Test
    void test01() throws AWTException {

        //driver.get("https://www.ilovepdf.com/compress_pdf");
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.delay(3000);

    }
            /*
        File Upload yaparken sendKeys() methodunun islemedigi istisnai durumlarda Testbase classda
        olusturdugumuz uploadFilePath(String dosyaYolu) methodu ile dosya yi yukleyebiliriz
        uploadFilePath(String dosyaYolu) methodu windows kullanicilari icindir
        Bu methodu kullanirken manual olarak mouse ve klavye yi kullanmamaliyiz
          */

    @Test
    void robotTest() {
        //Go to "https://www.ilovepdf.com/compress_pdf"
        // upload the file
        //test if the file has been uploaded successfully

        //"https://www.ilovepdf.com/compress_pdf" sitesine gidin
        driver.get("https://www.ilovepdf.com/compress_pdf");

        //  dosyayi yukleyin
        driver.findElement(By.id("pickfiles")).click();
        waitForSecond(3);

        //"C:\Users\TechPro           \Desktop\Batch 001.pdf"

        String dynamicPath = System.getProperty("user.home") + "\\Desktop\\Batch 001.pdf";

        uploadFilePath(dynamicPath);

        //   dosyanin basariyla yuklendigini test edin

        WebElement uploadFileTest = driver.findElement(By.xpath("//span[.='Batch 001.pdf']"));

        Assertions.assertTrue(uploadFileTest.isDisplayed());



    }
}
