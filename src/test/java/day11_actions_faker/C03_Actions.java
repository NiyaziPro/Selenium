package day11_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {

            //Techproeducation sayfasına gidelim
            //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
            //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım

            /**
        Sayfadaki bir webelementi locate ettigmiz halde NoSuchElement EXCEPTION aliyorsak

        1) Wait / Syncronization problemi olabilir ==> ImplicitlyWait süresini artirabiliriz.
        2) Locate kontrol edilmelidir
        3) Webelmenet iframe icinde olup olmadigina bakariz
        4) Driver webelementi göremiyor olabilir, dolayisiyla actions class ile scroll yapip webelementin görünür
        olmasini saglariz
         */

    @Test
    void test01() {

        //Techproeducation sayfasına gidelim https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Klavyedeki PAGE DOWN ve PAGE UP tuslari
        waitForSecond(3);

        // trick

        for (int i = 0; i < 3; i++) { // bu sekilde asagiya
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitForSecond(2);

        }

        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP).perform();

        for (int i = 0; i < 3; i++) { // bu sekilde asagiya
            actions.sendKeys(Keys.PAGE_UP).perform();
            waitForSecond(2);

        }


    }

    @Test
    void test02() {

        //Techproeducation sayfasına gidelim https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");
        waitForSecond(2);

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);

        // Sayfanin  en asagisina scroll yapalim
        actions.sendKeys(Keys.END).perform();
        waitForSecond(2);

        // Sayfanin  en yukarisina scroll yapalim
        actions.sendKeys(Keys.HOME).perform();



    }

    @Test
    void test03() {


        //Techproeducation sayfasına gidelim https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");
        waitForSecond(2);

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);

        WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));

        actions.scrollToElement(eventsText).perform();
    }
}
