package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C05_WindowHandle extends TestBase {

            // Go to https://the-internet.herokuapp.com/windows.
        //get the Handle value of the first page and print it
        //test that the text on the first page is "Opening a new window".
        //test that the first page Title is "The Internet".
        // Click the "Click Here" button.
        //test that the second page Title is "New Window".
        // go back to the first page and test that the Title is "The Internet".
        // go to the second page again.
        // go back to the first page.

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        //  ilk sayfasının Handle degerini alın yazdırın
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        //  "Click Here" butonuna tıklayın.
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        //  ikinci sayfaya tekrar geçin.
        //  ilk sayfaya tekrar dönün.









    @Test
    void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String firstWindow = driver.getWindowHandle();
        System.out.println("Handle 1 : " + firstWindow);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.

        Assertions.assertEquals("Opening a new window",driver.findElement(By.tagName("h3")).getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.

        Assertions.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Here")).click();


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.

        Set<String> windows = driver.getWindowHandles();

        for (String w : windows){
            if (!w.equals(driver.getTitle())){
                driver.switchTo().window(w);
            }
        }

        waitForSecond(2);

        Assertions.assertEquals("New Window", driver.getTitle());

        String secondWindow = driver.getWindowHandle();

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
       driver.switchTo().window(firstWindow);
        waitForSecond(2);
        Assertions.assertEquals("The Internet",driver.getTitle());

        //  ikinci sayfaya tekrar geçin.

        driver.switchTo().window(secondWindow);
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(firstWindow);
        waitForSecond(2);


    }
}
