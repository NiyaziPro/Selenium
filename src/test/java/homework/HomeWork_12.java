package homework;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HomeWork_12 extends TestBase {


    //   https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin
    //    Kullanıcı adı, şifre ve textArea yorumunu doldurun:
    //    Bir dosya seçin ve yükleyin
    //    Tüm onay kutularını, ilk radyo öğesini ve ilk açılır menüyü seçin
    //    Submit butonuna tıklayın
    //    Yüklenen dosya adının Form Ayrıntılarında olduğunu doğrulayın.


    @Test
    void testUploadFile() {
        Faker faker = new Faker();
        //   https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        //    Kullanıcı adı, şifre ve textArea yorumunu doldurun:
        WebElement usernameBox = driver.findElement(By.name("username"));
        usernameBox.sendKeys(faker.name().username(),
                Keys.TAB,
                faker.internet().password(),
                Keys.TAB,
                faker.lorem().paragraph());

        //    Bir dosya seçin ve yükleyin
        WebElement chooseFileButton = driver.findElement(By.name("filename"));
        String path = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";
        chooseFileButton.sendKeys(path);


        //    Tüm onay kutularını, ilk radyo öğesini ve ilk açılır menüyü seçin
        WebElement checkBox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("input[value='cb2']"));
        WebElement checkBox3 = driver.findElement(By.cssSelector("input[value='cb3']"));

        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }

        WebElement radioButton1 = driver.findElement(By.cssSelector("input[value='rd1']"));
        radioButton1.click();

        driver.findElement(By.cssSelector("option[value='ms1']")).click();

        WebElement ddm = driver.findElement(By.name("dropdown"));
        selectIndex(ddm,0);


        //    Submit butonuna tıklayın

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //    Yüklenen dosya adının Form Ayrıntılarında olduğunu doğrulayın.

        WebElement fileName = driver.findElement(By.id("_valuefilename"));

        Assertions.assertTrue(fileName.getText().contains("b10 all test cases, code.docx"));

    }
}
