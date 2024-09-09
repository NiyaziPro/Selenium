package day17_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutorSetAttribute extends TestBase {


    @Test
    void test01() {

        //<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        // placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        // aria-label="Search Amazon" spellcheck="false">


        //Attribute Value Set etme

        //amazona gidelim
        driver.get("https://www.amazon.com/");
        waitForSecond(4);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='selenium'",searchBox);



    }

    @Test
    void test02() {

        //amazona gidelim
        driver.get("https://www.amazon.com/");
        waitForSecond(4);

        //jsexecutor ile arama kutusuna selenium yazdiralim

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        jsSendKeys(searchBox,"laptop");

    }

    //Attribute Value Set etme

    @Test
    void test03() {

        //amazona gidelim
        driver.get("https://www.amazon.com/");
        waitForSecond(10);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('id','amazonid')",searchBox);

        //degistirilmis id Attribute name ile webElementi locate etmek :

        driver.findElement(By.id("niyazi")).sendKeys("laptop", Keys.ENTER);
    }
}
