package practices.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P01 extends TestBase {


    @Test
    void test01() {

        // kullanıcı https://www.amazon.com/ adresine gider
        driver.get("https://www.amazon.com/");
        waitForSecond(4);

        //Account linkine tıklayın
        Actions actions = new Actions(driver);
        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountElement).perform();
        waitForSecond(2);

        driver.findElement(By.linkText("Account")).click();

        //Ardından sayfa başlığının "Account" içerdiğini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("Account"));

        //Ardından sayfanın altındaki Amazon Music öğesine ilerleyin

        WebElement amazonMusicLink = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        jsScrollToWebElement(amazonMusicLink);
         waitForSecond(2);
        //Elemente tıklayın
        jsClick(amazonMusicLink);

        //alternatif : actions.moveToElement(amazonMusicLink).perform(); >> bu method ogeyi sayfanin neresinde olursa olsun bular.

        //Ardından Amazon Music sayfasının görüntülendiğini doğrulayın

        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));

        // Sayfayı yukarı ve aşağı kaydırın

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,250)");
        waitForSecond(1);
        jse.executeScript("window.scrollTo(0,-250)");
        waitForSecond(1);
        jsScrollToEnd();
        waitForSecond(2);
        jsScrollToEnd();

        //müzik sayfasındaki arama girişini bulun ve 'POP' aratın

        WebElement searchBox = driver.findElement(By.id("navbarSearchInput"));
        searchBox.sendKeys("POP", Keys.ENTER);

        //arama kutusunun id degerini, kendi ismimiz ile degistirecegiz

        //<input id="navbarSearchInput" class="HnY_v1NvZaJZknyxFDBP" placeholder="Search" type="search" role="searchbox" value="POP">

        jse.executeScript("arguments[0].setAttribute('id','alican')",searchBox);

        WebElement searchBoxNewLocate = driver.findElement(By.id("alican"));


        searchBoxNewLocate.sendKeys("Dance",Keys.ENTER);


    }
}
