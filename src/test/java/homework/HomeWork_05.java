package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HomeWork_05 extends TestBase {


        /* ÖDEV!!
        Drag web elementinin drop web elementinin üzerine bırakıldığını test ediniz
         */

    @Test
    void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));

        System.out.println("droppable.getText() = " + droppable.getText());
        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable).moveByOffset(140,50).release().perform();
        System.out.println("droppable.getText()2 = " + droppable.getText());

        String expectedText = "Dropped!";
        String actualText = droppable.getText();
        Assertions.assertEquals(actualText, expectedText, "Element dogru sekilde birakilmadi.");




    }
}
