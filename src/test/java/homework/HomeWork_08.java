package homework;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HomeWork_08 extends TestBase {


    @Test
    void test01() {

        // 1) 'https://automationexercise.com' adresine gidin
        driver.get("https://automationexercise.com");

        waitForSecond(5);
        // 2) Sayfaya girildigini dogrulayin

        Assertions.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());

        // 3) "Signup / Login" butonuna TIKLAYIN
        driver.findElement(By.xpath("(//li/a/i)[4]")).click();

        // 4) "Signup / Login" sayfasina girildigini dogrulayin
        Assertions.assertTrue(driver.getTitle().contains("Signup"));

        waitForSecond(2);
        // 5) "New User Signup!" Name ve Email Address gir
        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());

        waitForSecond(1);

        // 6) "Signup" buttonuna TIKLA
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        waitForSecond(3);
        // 7) "ENTER ACCOUNT INFORMATION" bilgilerini gir
        driver.findElement(By.id("id_gender1")).click();

        driver.findElement(By.id("password")).sendKeys(faker.internet().password(), Keys.TAB);
        WebElement years = driver.findElement(By.id("years"));
        WebElement months = driver.findElement(By.id("months"));
        WebElement days = driver.findElement(By.id("days"));

        selectIndex(days, 25);
        selectIndex(months, 0);
        selectVisible(years, "1990");

        waitForSecond(2);

        // 8) "Sign up for our newsletter!" onay kutusunu seçin.
        driver.findElement(By.id("newsletter")).click();

        // 9) "Receive special offers from our partners!" onay kutusunu seçin.
        driver.findElement(By.id("optin")).click();

        waitForSecond(2);
        // 10) "ADDRESS INFORMATION" bilgilerini gir
        WebElement firstNameBox = driver.findElement(By.id("first_name"));
        firstNameBox.sendKeys(faker.name().firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                faker.company().name(),
                Keys.TAB,
                faker.address().streetAddress(),
                Keys.TAB,
                faker.address().streetAddress());

        waitForSecond(2);

        selectIndex(driver.findElement(By.id("country")), 3);

        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys(faker.address().state(),
                Keys.TAB,
                faker.address().city(),
                Keys.TAB,
                faker.address().zipCode(),
                Keys.TAB,
                faker.phoneNumber().phoneNumber(),
                Keys.TAB,
                Keys.ENTER);
        waitForSecond(3);

        // 11) Hesap olusturuldugunu dogrula

        Assertions.assertEquals("ACCOUNT CREATED!", driver.findElement(By.xpath("//h2/b")).getText());


    }
}
