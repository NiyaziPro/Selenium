package day16_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_JSExecutorClick extends TestBase {


    @Test
    void test01() {

        //amazon sayfasina gidelim https://amazon.com
        driver.get("https://amazon.com");
        waitForSecond(4);

        //sell webelementine tiklayalim
        WebElement sellElement = driver.findElement(By.xpath("//a[.='Sell']"));
        sellElement.click(); // ElementClickInterceptedException




    }

    @Test
    void test02() {
        //amazon sayfasina gidelim https://amazon.com
        driver.get("https://amazon.com");
        waitForSecond(4);
        //sell webelementine tiklayalim
        WebElement sellElement = driver.findElement(By.xpath("//a[.='Sell']"));

         JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",sellElement);

    }

    @Test
    void test03() {
        //amazon sayfasina gidelim https://amazon.com
        driver.get("https://amazon.com");
        waitForSecond(4);
        //sell webelementine tiklayalim
        WebElement sellElement = driver.findElement(By.xpath("//a[.='Sell']"));

        jsClick(sellElement);
    }
}
