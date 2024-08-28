package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FakerTest extends TestBase {

            //Go to https://www.globalsqa.com/samplepagetest/
        //Fill textboxes with fake data

        //https://www.globalsqa.com/samplepagetest/ sitesine gidin
        //Textbox lari fake datalar ile doldurun

    @Test
    void test01() {

        //https://www.globalsqa.com/samplepagetest/ sitesine gidin
        driver.get("https://www.globalsqa.com/samplepagetest/");

        waitForSecond(5);

        //Textbox lari fake datalar ile doldurun

        Faker faker = new Faker();

        WebElement nameTextBox = driver.findElement(By.id("g2599-name"));

        nameTextBox.sendKeys(faker.name().firstName(), Keys.TAB,faker.internet().emailAddress(),Keys.TAB,faker.internet().domainName());



    }

    @Test
    void test02() {

        //https://www.globalsqa.com/samplepagetest/ sitesine gidin
        driver.get("https://www.globalsqa.com/samplepagetest/");

        waitForSecond(5);

        //Textbox lari fake datalar ile doldurun

        Faker faker = new Faker();

        WebElement commentBox = driver.findElement(By.id("contact-form-comment-g2599-comment"));

        commentBox.sendKeys(faker.lorem().paragraph());
    }
}
