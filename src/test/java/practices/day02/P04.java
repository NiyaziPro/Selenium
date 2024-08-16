package practices.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {
            // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
            // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
            // 3) Sayfaya giriş yapıldığını doğrula
            // 4) Admin butonunun görüdüğünü doğrula
            // 5) Sayfadan çıkıç yap
            // 6) Sayfadan Çıkış Yapıldığını Doğrula


    @Test
    void test01() {
        // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");
        waitForSecond(3);

        // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        // 3) Sayfaya giriş yapıldığını doğrula

        WebElement dashboard = driver.findElement(By.xpath("//h6[1]"));
        Assertions.assertTrue(dashboard.isDisplayed());
        Assertions.assertNotEquals("https://opensource-demo.orangehrmlive.com/",driver.getCurrentUrl());

        // 4) Admin butonunun görüdüğünü doğrula
        WebElement adminButton = driver.findElement(By.xpath("(//*[@class='oxd-main-menu-item']/span)[1]"));

        Assertions.assertTrue(adminButton.isDisplayed());

        waitForSecond(3);
        // 5) Sayfadan çıkıç yap
        WebElement ddm = driver.findElement(By.className("oxd-userdropdown-menu"));
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));

        ddm.click();
        logout.click();


        // 6) Sayfadan Çıkış Yapıldığını Doğrula

        Assertions.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());




    }
}
