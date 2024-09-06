package practices.day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P02 extends TestBase {

    @Test
    void test01() {

        Faker faker = new Faker();
        // kullanıcı verilen adrese gider https://www.trvlcar.com/
        driver.get("https://www.trvlcar.com/");

        // Adrese gittiğini doğrular
        Assertions.assertEquals("https://www.trvlcar.com/",driver.getCurrentUrl(),"Adrese ulasilamadi");
        Assertions.assertEquals("TrvlCar | Premium Car Rental",driver.getTitle());
        // Register butonuna tıklar
        WebElement registerButton = driver.findElement(By.xpath("//a[@href='/auth']"));
        registerButton.click();

        //Register kısmına geçiş yapar
        driver.findElement(By.xpath("//button[@data-rr-ui-event-key='register']")).click();

        //Tüm alanları doldurur
        WebElement firstName = driver.findElement(By.name("firstName"));
        String password = "Deneme#123";
        //String password1 = faker.internet().password(8,10,true,true,true);
        firstName.sendKeys(faker.name().firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                faker.phoneNumber().phoneNumber(),
                Keys.TAB,
                faker.address().fullAddress(),
                Keys.TAB,
                faker.address().zipCode(),
                Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,
                password,
                Keys.TAB,
                password);

        //Register butonuna tıklar
        WebElement register2 = driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]"));
        jsScrollToWebElement(register2);
        waitForSecond(2);
        register2.click();


        //Başarılı kayıt mesajının göründüğünü doğrular
        //div[contains(text(),'You are registered successfully')]
        WebElement succesMessage = driver.findElement(By.xpath("//div[contains(text(), 'You are registered successfully')]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(ExpectedConditions.visibilityOf(succesMessage));

        Assertions.assertEquals("You are registered successfully",succesMessage.getText());

        Assertions.assertTrue(succesMessage.getText().contains("You are registered successfully"),"Basarisiz Kayit!");


    }
}
