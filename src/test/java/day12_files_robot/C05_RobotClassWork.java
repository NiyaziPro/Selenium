package day12_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_RobotClassWork extends TestBase {

    @Test
    void test01() {
        // https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");
        waitForSecond(3);

        WebElement nameBox = driver.findElement(By.name("username"));
        nameBox.sendKeys("Admin");

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        waitForSecond(3);

        // PIM butonuna tikla
        driver.findElement(By.xpath("//span[.='PIM']")).click();

        // Add Butonu
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();


        // Resim ekle butonu
        WebElement addPhoto = driver.findElement(By.cssSelector(".employee-image"));
        addPhoto.click();

        // "C:\Users\TechPro  \Desktop\color-pencils-5699634_1920.jpg"

        String dynamicPath = System.getProperty("user.home") + "\\Desktop\\color-pencils-5699634_1920.jpg";

        uploadFilePath(dynamicPath);

        //Resim Eklendiğini doğrula

        Assertions.assertTrue(addPhoto.getAttribute("src").contains("data:image/"));

        Assertions.assertFalse(addPhoto.getText().contains("default"));





    }
}
