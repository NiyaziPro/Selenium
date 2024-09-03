package day14_screenshot_extentreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebElement_ScreenShot extends TestBase {


            //go to the Amazon page
            //search for laptop in the search box
            //take the screenshot
            //get the image of the result text webelement

            //Amazon sayfasına gidelim
            //Arama kutusunda laptop aratalim
            //ekran resmini alalım
            //sonuc yazısı webelementinin resmini alalım
    @Test
    void test01() {

        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        waitForSecond(4);

        //Arama kutusunda laptop aratalim

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop", Keys.ENTER);

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım

        WebElement resultText = driver.findElement(By.xpath("//*[contains(text(),'results for')]"));



    }
}
