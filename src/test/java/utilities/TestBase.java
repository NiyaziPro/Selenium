package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver;

        /*
        abstract'ı neden ekledik? çünkü bu clasttan obje oluşturulmasını istemiyorum.
        abstract classlarda constructor vardır ama bu şekliyle obje oluşturmaz.

        neden public yerine protected yaptık? başka packagelardan * childlardan ulaşılabilmesi için
        publicte güvenlik açığı sorunu oluşabiliyor.
        */

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }

    // Hard Wait

    public void waitForSecond(int second){

        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // DropDown Menu
        //selectVisibleText
    public void selectVisible(WebElement ddm, String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);

    }
        //selectByIndex
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);

    }







}
