package day17_jsexecutor_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Log4J extends TestBase {




    @Test
    void test01() {
        Logger logger = LogManager.getLogger(C03_Log4J.class);


        driver.get("https://www.amazon.com");
        logger.info("Amazon web sayfasina gidildi");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("Arama kutusu locate edildi");

        searchBox.sendKeys("Laptop", Keys.ENTER);
        logger.info("Arama kutusunda 'Laptop' aratildi");


        logger.info("sayfa kapatilir");
        driver.quit();

    }
}
