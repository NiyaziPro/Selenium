package day17_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSLocate extends TestBase {


    //document.getElementById('twotabsearchtextbox');

    @Test
    void test01() {

        //amazona gidelim
        driver.get("https://www.amazon.com/");
        waitForSecond(10);

        //jsexecutor ile arama kutusuna selenium yazdiralim

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement searchBox = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox')");

        searchBox.sendKeys("MacBook", Keys.ENTER);
    }

    @Test
    void test02() {
        //techproeducation sayfasina gidelim  https://techproeducation.com
        driver.get("https://techproeducation.com");
        WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));

            //Events yazisini BATCH001 olarak degistirelim

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].textContent='BATCH001'",eventsText);

    }
}
