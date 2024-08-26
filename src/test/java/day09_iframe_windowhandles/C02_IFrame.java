package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_IFrame extends TestBase {

    //Go to https://the-internet.herokuapp.com/iframe
    //Verify that the bold text contains the word "Editor"
    //Test that the text inside the textbox is 'Your content goes here.'
    //Verify that the text on the page is "Elemental Selenium".

    //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
    //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
    //Textboxun icindeki metnin 'Your content goes here.' Oldugunu test edin
    //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.


    @Test
    void test01() {


        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız

        String actualText = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertTrue(actualText.contains("Editor"));

        //Textboxun icindeki metnin 'Your content goes here.' Oldugunu test edin
        driver.switchTo().frame("mce_0_ifr");

        String textbox = driver.findElement(By.xpath("//p[.='Your content goes here.']")).getText();

        Assertions.assertEquals("Your content goes here.",textbox);

        driver.switchTo().defaultContent();

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.

        String actualResult = driver.findElement(By.partialLinkText("Elemental Selenium")).getText();

        Assertions.assertEquals("Elemental Selenium",actualResult);
    }
}
