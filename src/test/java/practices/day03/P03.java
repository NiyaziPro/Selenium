package practices.day03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03 extends TestBase {
    //    Go to https://form.jotform.com/73302671092956
    //    Click on start
    //    Enter firstname and lastname
    //    Click on next
    //    Enter email
    //    Click on next
    //    Enter message
    //    Click on next
    //    Handle captcha
    //    Click on submit
    //    Assert that submission is received

    //  Verilen adrese gidin https://form.jotform.com/73302671092956
    //  Start butonuna tıklayın
    //  İsim ve soyisim girin
    //  Next butonuna tıklayın
    //  Email adresi girin
    //  Next butonuna tıklayın
    //  Mesaj girin "Hello World! We are learning Selenium"
    //  Next butonuna tıklayın
    //  Captcha handle edin
    //  Gönder butonuna tıklayın
    //  Gönderimin alındığını onaylayın


    @Test
    void test01() {
        //  Verilen adrese gidin https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");
        waitForSecond(3);

        //  Start butonuna tıklayın
        driver.findElement(By.id("jfCard-welcome-start")).click();

        //  İsim ve soyisim girin
        Faker faker = new Faker();
        driver.findElement(By.id("first_1")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last_1")).sendKeys(faker.name().lastName());

        waitForSecond(2);

        //  Next butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-testid='nextButton_0']")).click();

        //  Email adresi girin
        driver.findElement(By.id("input_2")).sendKeys(faker.instance().internet().emailAddress());
        waitForSecond(2);

        //  Next butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-testid='nextButton_1']")).click();

        waitForSecond(2);
        //  Mesaj girin "Hello World! We are learning Selenium"
        driver.findElement(By.id("input_3")).sendKeys("Hello World! We are learning Selenium");

        waitForSecond(2);
        //  Next butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-testid='nextButton_2']")).click();



        waitForSecond(3);
        //  Captcha handle edin
        driver.switchTo().frame(0);


        int number = Integer.parseInt(driver.findElement(By.id("number")).getText());
        int number2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
        String function = driver.findElement(By.id("function")).getText();

        int result;
        if (function.equals("+")) {
            result = number + number2;
        } else if (function.equals("-")) {
            result = number - number2;
        } else if (function.equals("x")) {
            result = number * number2;
        }else {
            result = number / number2;
        }
        System.out.println("result = " + result);

        driver.findElement(By.xpath("//input[@name='equal']")).sendKeys(result+"");

        waitForSecond(3);
        driver.switchTo().defaultContent();

        //  Gönder butonuna tıklayın

        driver.findElement(By.xpath("(//button[@data-testid='submitButton'])[4]")).click();

        //  Gönderimin alındığını onaylayın

        String succesMessage = driver.findElement(By.tagName("h1")).getText();
        waitForSecond(1);
        Assertions.assertTrue(succesMessage.contains("Thank You!"));
    }
}
