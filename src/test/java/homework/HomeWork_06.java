package homework;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HomeWork_06 extends TestBase {
            /*
        HOMEWORK
        //1. "https://facebook.com" Adresine gidin
        //2. "create new account" butonuna basin
        //3. "firstName" giris kutusuna bir isim yazin
        //4. "surname" giris kutusuna bir soyisim yazin
        //5. "email" giris kutusuna bir email yazin
        //6. "email" onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //13. Sayfayi kapatin
         */

    @Test
    void test01() {

        //1. "https://www.facebook.com" Adresine gidin
        driver.get("https://www.facebook.com");

        waitForSecond(3);
        //2. "create new account" butonuna basin
        driver.findElement(By.partialLinkText("Create new account")).click();

        //3. "firstName" giris kutusuna bir isim yazin
        //4. "surname" giris kutusuna bir soyisim yazin
        //5. "email" giris kutusuna bir email yazin
        //6. "email" onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,
                faker.internet().password(),
                Keys.TAB);

        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin

        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        WebElement year = driver.findElement(By.id("year"));
        selectIndex(month,0);
        selectIndex(day,16);
        selectVisible(year,"1990");


        //11. Cinsiyeti secin

        WebElement maleButton = driver.findElement(By.xpath("//input[@value = 2]"));

        maleButton.click();

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value = 1]"));
        WebElement otherButton = driver.findElement(By.xpath("//input[@value = -1]"));

        Assertions.assertFalse(femaleButton.isSelected());
        Assertions.assertFalse(otherButton.isSelected());

        //13. Sayfayi kapatin
        //driver.close();
    }

    @Test
    void test02() {

        //1. "https://facebook.com" Adresine gidin

        driver.get("https://facebook.com");
        waitForSecond(3);

        //2. "create new account" butonuna basin
        driver.findElement(By.partialLinkText("Create new account")).click();

        //3. "firstName" giris kutusuna bir isim yazin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));

        Faker faker = new Faker();

        firstName.sendKeys(faker.name().firstName());

        //4. "surname" giris kutusuna bir soyisim yazin
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));

        lastName.sendKeys(faker.name().lastName());

        //5. "email" giris kutusuna bir email yazin
        WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));

        email.sendKeys(faker.internet().emailAddress());

        //6. "email" onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin

        WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));

        password.sendKeys(faker.internet().password());

        //8. Tarih icin gun secin
        WebElement day = driver.findElement(By.id("day"));
        selectIndex(day,15);

        //9. Tarih icin ay secin

        WebElement month = driver.findElement(By.id("month"));
        selectIndex(month,10);

        //10. Tarih icin yil secin
        WebElement year = driver.findElement(By.id("year"));
        selectVisible(year,"2002");

        //11. Cinsiyeti secin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value = 1]"));

        femaleButton.click();

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement maleButton = driver.findElement(By.xpath("//input[@value = 2]"));
        WebElement otherButton = driver.findElement(By.xpath("//input[@value = -1]"));

        Assertions.assertFalse(maleButton.isSelected());
        Assertions.assertFalse(otherButton.isSelected());

        //13. Sayfayi kapatin
        //driver.close();
    }
}
