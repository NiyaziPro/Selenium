package day11_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {

            //Go to https://jqueryui.com/droppable/
        //Drag me to my target webelement onto the Drop here webelement

        //https://jqueryui.com/droppable/ adresine gidelim
        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım


    @Test
    void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable,droppable).perform();
    }

    @Test
    void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable)
                .moveToElement(droppable)
                .release()
                .perform();
    }

    @Test
    void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable).moveByOffset(140,50).release().perform();



    }
}
