package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class HomeWork_09 extends TestBase {

    //BBC News ana sayfasına gidin.
    //Bir haber başlığına tıklayın.
    //Yeni sayfanın tamamen yüklendiğinden ve belirli bir başlık içeren bir makale başlığının göründüğünden emin olun.
    //Makale içeriğinde belirli bir anahtar kelimeyi kontrol edin.


    @Test
    void testUploadNewWindowAndTitle() {
        //BBC News ana sayfasına gidin.
        driver.get("https://www.bbc.com/");
        String currentTitle = driver.getCurrentUrl();
        skipCookies();

        //Bir haber başlığına tıklayın.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = driver.findElement(By.xpath("(//div[@data-testid='edinburgh-article'])[3]"));

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();

        skipCookies();

        //Yeni sayfanın tamamen yüklendiğinden ve belirli bir başlık içeren bir makale başlığının göründüğünden emin olun.

        WebElement newPageFullyLoaded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

        Assertions.assertTrue(newPageFullyLoaded.isDisplayed());


        //Makale içeriğinde belirli bir anahtar kelimeyi kontrol edin.

        Assertions.assertTrue(driver.findElement(By.xpath("(//div/p)[4]")).getText().contains("kaleidoscopic foliage"));


    }

    public void skipCookies() {
        WebElement frameLocator = driver.findElement(By.id("sp_message_iframe_1091681"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

        driver.findElement(By.xpath("//button[@title='I do not agree']")).click();
        driver.switchTo().defaultContent();

    }
}
