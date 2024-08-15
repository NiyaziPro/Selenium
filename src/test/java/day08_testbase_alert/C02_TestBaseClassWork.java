package day08_testbase_alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TestBaseClassWork extends TestBase {
            /*
         https://testcenter.techproeducation.com/index.php?page=dropdown sayfasina gidelim
         Year, month, day dropdown menulerden reusable method kullanarak secim yapalim
         */

    @Test
    void reusubleMethodUsage() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        waitForSecond(2);
        //         a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        // reusable method kullanarak secim yapalim
        waitForSecond(2);
        selectIndex(year,1);
        waitForSecond(2);
        selectIndex(month,0);
        waitForSecond(2);
        selectIndex(day,2);
        waitForSecond(2);


        selectVisible(year,"1990");
        waitForSecond(2);
        selectVisible(month,"May");
        waitForSecond(2);
        selectVisible(day,"30");
    }
}
