package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropdownMenu {

                /*DROPDOWN

            Dropdown u automate etmek icin;
            1- Dropdown menuyu ilk olarak locate ederiz.
            2- Select objecti olusturulur
            3- Select objecti uzerinden cesitli methodlar sayesinde dropdown seceneklerine erisim saglariz
                SYNTAX
                Select options = new Select(Webelement dropdown);
                a- selectByVisibleText() -> dropdown menudeki gorunur Text ile ulasmak icin kullanilir
                b- selectByIndex() -> Index ile ulasmak icin kullanilir. (index 0 dan baslar)
                c- selectByValue() -> value attribute deegeri ile ulasmak icin kullanilir

            4- getOptions() -> Locate ettigimiz dropdown menudeki tum secenekleri bize verir
            5- getFirstSelectedOption() -> Dropdown menudeki secili olan secenegi bize verir
             */


    // kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    // 3 farklı test methodu oluşturalım
    //     1.Method:
    //         a. Yil,ay,gün dropdown menu'leri locate ediniz
    //         b. Select objesi olustur
    //         c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    //     2.Method:
    //         a. Tüm eyalet isimlerini yazdıralım
    //     3.Method:
    //         a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() throws InterruptedException {

        // a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year  = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        Thread.sleep(3000);
        //b. Select objesi olustur
        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);
        Thread.sleep(3000);

       //  c. Select object i kullaarak 3 farkli sekilde secim yapiniz
       selectYear.selectByValue("1990");
       selectMonth.selectByIndex(0); //index 0'DAN BAŞLAR. 0 yazdığımızda bize 1.seçeneği verir.
       selectDay.selectByVisibleText("25"); //ekranda görülen text'e göre seçilir
        Thread.sleep(3000);
    }

    @Test
    void test01a() throws InterruptedException {
        // a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year  = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        Thread.sleep(3000);
        year.sendKeys("1990");
        month.sendKeys("October");
        day.sendKeys("26");
        Thread.sleep(3000);


    }

    @Test
    void test02() {
        WebElement state  = driver.findElement(By.cssSelector("#state"));//web elementte bulunan id att. ü unique değere sahip olduğu için
                                                //CSS SELECTOR'ün kısayolu ile (#) alabildik.
        Select options = new Select(state);

        // 1. yol

        List<WebElement> statesList = options.getOptions();

        for (WebElement w : statesList){
            System.out.print(w.getText()+ " ");
        }
        System.out.println("-----------------------------------------------------------------------------------");
        // 2.yol

        statesList.forEach(t-> System.out.print(t.getText()+ " "));


        System.out.println("-----------------------------------------------------------------------------------");
        List<WebElement> xpathStates = driver.findElements(By.xpath("//select[@id='state']/option"));

        xpathStates.forEach(t-> System.out.print(t.getText()+" "));

    }

    @Test
    void test03() {
        //State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement statesDdm = driver.findElement(By.xpath("//select[@id='state']"));
        Select options = new Select(statesDdm);

        Assertions.assertEquals("Select a State",options.getFirstSelectedOption().getText());

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
