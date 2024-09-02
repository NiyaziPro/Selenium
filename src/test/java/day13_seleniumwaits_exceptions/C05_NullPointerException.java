package day13_seleniumwaits_exceptions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class C05_NullPointerException {
    // Kullanmak istediginiz object'in degeri henuz Null ise,
    // baslatilmadiysa bu hata alinir, ve bu hata Java'dan gelir


        /*
        NullPointerException
        Eger bir object yada variable olusturup bu olusturdugumuz objeye assignment yapmadan kullanmak istersek
        bu hatayi aliriz,
        Cünkü javada degeri null olan bir object ile etkilesim yapilmasina izin vermez
         */
    WebDriver driver;
    Faker faker;
    Actions actions;
    String string;

    @Test
    void test01() {
        // driver = new ChromeDriver();
        driver.get("https://www.google.com");
        // NullPointerException: Cannot invoke "org.openqa.selenium.WebDriver.get(String)" because "this.driver" is null


    }

    @Test
    void test02() {
        // faker = new Faker();
        System.out.println(faker.name().fullName());
        //NullPointerException: Cannot invoke "com.github.javafaker.Faker.name()" because "this.faker" is null
    }

    @Test
    void test03() {
       // actions = new Actions(driver);
        actions.build().perform();
        //NullPointerException: Cannot invoke "org.openqa.selenium.interactions.Actions.build()" because "this.actions" is null
    }

    @Test
    void test04() {
        System.out.println(string.length());
    }
}
