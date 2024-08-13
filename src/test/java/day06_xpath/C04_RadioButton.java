package day06_xpath;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RadioButton {
    // Go to https://www.facebook.com
    //Click the “Create an Account” button
    //locate “radio buttons” elements
    // If it is not selected, choose the one that suits you from the gender button.
    //  https://www.facebook.com adresine gidin
    //  “Create an Account” button’una basin
    //  “radio buttons” elementlerini locate edin
    //   Secili degilse cinsiyet butonundan size uygun olani secin


    @Test
    void name() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        Thread.sleep(3000);


        //  “Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role = 'button'])[2]")).click();
        //  “radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value = 1]"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value = 2]"));
        WebElement otherButton = driver.findElement(By.xpath("//input[@value = -1]"));

        //   Secili degilse cinsiyet butonundan size uygun olani secin

        if (!maleButton.isSelected()){
            maleButton.click();
        }

        Thread.sleep(3000);

        driver.quit();

    }
}
