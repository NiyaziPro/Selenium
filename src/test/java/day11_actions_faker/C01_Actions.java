package day11_actions_faker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;



public class C01_Actions extends TestBase {

            //Go to https://the-internet.herokuapp.com/context_menu
        //Right click on the box
        //Test that the text appearing in Alert is "You selected a context menu"
        //Close the alert by clicking OK

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        // Kutuya sag tıklayın
        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        //Tamam diyerek alert'i kapatın



    @Test
    void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Kutuya sag tıklayın

        WebElement box = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(box).perform();


        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin

        Assertions.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert'i kapatın

        driver.switchTo().alert().accept();






    }
}
