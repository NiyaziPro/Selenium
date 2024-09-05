package day16_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSScroll extends TestBase {

    @Test
    void test01() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");


        //Challenges a kadar scroll yapiniz

        WebElement challengesElement = driver.findElement(By.xpath("//h2[3]"));

        JavascriptExecutor jse  = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",challengesElement);
    }

    @Test
    void test02() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");


        //Challenges a kadar scroll yapiniz

        WebElement challengesElement = driver.findElement(By.xpath("//h2[3]"));

        jsScrollToWebElement(challengesElement);
    }

    @Test
    void test03() {
        //https://www.techproeducation.com/ adresine gidiniz
        driver.get("https://www.techproeducation.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        waitForSecond(2);
        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    void test04() {

        //https://www.techproeducation.com/ adresine gidiniz
        driver.get("https://www.techproeducation.com/");
        jsScrollToEnd();
        waitForSecond(2);
        jsScrollToHome();
    }
}
