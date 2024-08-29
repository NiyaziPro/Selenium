package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

    // index window handle
    public void switchToWindow(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());

    }

    //File Upload Robot Class
    public void uploadFilePath(String dosyaYolu) {
        try {
            waitForSecond(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);

            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();

            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);

            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);

            // Sonraki işlemler için ek 3 saniye bekler.
        } catch (Exception ignored) {
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }





}}
