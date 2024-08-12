package day05_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_GetTagNameGetAttributeName {


    //go to techproeducation page https://techproeducation.com
    //Test that the tag name of the search box is input
    //Test that the value of the search box's class attribute is form-input
    //close the page

    //techpro sayfasina gidelim.
    //arama kutusunun tag name'inin input oldugunu test edelim.
    //arama kutusunun class attribute degerinin form-input oldugunu test edin.
    //sayfayi kapatin


    @Test
    void test01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://techproeducation.com");

        WebElement searchBox =driver.findElement(By.id("searchHeaderInput"));

        String expectedTagName = "input";
        String actualTagName = searchBox.getTagName();

        Assertions.assertEquals(expectedTagName,actualTagName);

        String actualAttributeValue = searchBox.getAttribute("class");
        String expectedAttributeValue = "form-input";

        Assertions.assertEquals(expectedAttributeValue,actualAttributeValue);

        driver.quit();
    }
}
