package day14_screenshot_extentreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_Screenshot extends TestBase {

    @Test
    void test01() throws IOException {
        driver.get("https://www.facebook.com/");

        String date = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm.ss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\photo_" + date + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(path), ts.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    void test02() {
        driver.get("https://www.instagram.com");
        screenShot();
    }
}
