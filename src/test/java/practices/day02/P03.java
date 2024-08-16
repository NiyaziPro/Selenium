package practices.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03 extends TestBase {

    // belirtilen url e gidin : https://demo.guru99.com/test/radio.html
    // checkbox1 ve checkbox3 seçili değilse seçin
    // checkbox1 ve checkbox3 seçili olduğunu test edin
    // checkbox2 elementinin seçili olmadığını test edin
    @Test
    void test01() {
        // belirtilen url e gidin : https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");

        // checkbox1 ve checkbox3 seçili değilse seçin
        WebElement checkBox1 = driver.findElement(By.cssSelector("#vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("#vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.cssSelector("#vfb-6-2"));


        if (!(checkBox1.isSelected())){
            checkBox1.click();
        }
        if (!(checkBox3.isSelected())){
            checkBox3.click();
        }
        // checkbox1 ve checkbox3 seçili olduğunu test edin

        Assertions.assertTrue(checkBox1.isSelected());
        Assertions.assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin seçili olmadığını test edin

        Assertions.assertFalse(checkBox2.isSelected());
    }
}
