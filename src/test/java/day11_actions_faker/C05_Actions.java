package day11_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {

            //Google anasayfasına gidelim
        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve
        // shift tuşunu serbest bırakarak java  yazdıralım
    @Test
    void test01() {
        //Google anasayfasına gidelim

        driver.get("https://www.google.com");
        waitForSecond(3);

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve
        // shift tuşunu serbest bırakarak java  yazdıralım
        WebElement searchBox = driver.findElement(By.id("APjFqb"));

        Actions actions = new Actions(driver);

        actions.keyDown(searchBox,Keys.SHIFT)
                .sendKeys("selenium")
                .keyUp(Keys.SHIFT)
                .sendKeys("java",Keys.ENTER)
                .perform();


    }

    @Test
    void test02() {
        //Google anasayfasına gidelim

        driver.get("https://www.google.com");
        waitForSecond(3);

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve
        // shift tuşunu serbest bırakarak java  yazdıralım
        WebElement searchBox = driver.findElement(By.id("APjFqb"));

        searchBox.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"java",Keys.ENTER);


    }
}
