package day13_seleniumwaits_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C07_ScreenShot extends TestBase {

    @Test
    void test01() throws IOException {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String filePath = "src/test/java/screenShots"+date +"Photo.png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Files.write(Paths.get(filePath),takesScreenshot.getScreenshotAs(OutputType.BYTES));

    }
}
