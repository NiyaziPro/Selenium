package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomeWork_04 extends TestBase {

    //Ödev 3: C05 calssındaki senaryoyu, bir önceki classta öğrendiğimiz metotlar ile tekrar yapınız

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
        List<String> windowsList = new ArrayList<>(windows);

        driver.switchTo().window(windowsList.get(1));

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
