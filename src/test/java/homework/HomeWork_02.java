package homework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HomeWork_02 extends TestBase {

            //homework
        //https://html.com/tags/iframe   sayfasina gidiniz
        // sayfada bulunan youtube videosunu baslatiniz


    @Test
    void test01() {
        //https://html.com/tags/iframe   sayfasina gidiniz

        driver.get("https://html.com/tags/iframe");

        // sayfada bulunan youtube videosunu baslatiniz
        WebElement frameLocation = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(frameLocation);
        waitForSecond(2);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();

    }
}
