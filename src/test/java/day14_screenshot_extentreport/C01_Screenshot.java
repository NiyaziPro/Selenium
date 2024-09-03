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

public class C01_Screenshot extends TestBase {

    /*
        Bir sayfanin ekran görüntüsünü almak istersek;
        1) ekran gorunutusunu kaydetmek istedigimiz dosya yolunu belirleriz
        2) TakeScreenShot tipinde bir object declare edip driveri bu objectye assign edeceğiz
            ==> TakeScreenShot ts = driver;
        3) Files classinda write() methodunu kullanarak icine parametre olarak aldigimiz ekran goruntusunu
        nereye kaydedeceğimizi beliritir, getScreenShotAs() methodu ile almis oldugumuz ekran görüntüsün bu
        path e kaydederiz
         */

    @Test
    void test01() throws IOException {

        //TechproEducation sayfasina gidelim https://techproeducation.com
        driver.get("https://techproeducation.com");

        //Ekran görüntüsünü alalim

        String date = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm.ss").format(LocalDateTime.now());
        String filePath = "src\\test\\java\\screenshots\\"+ date +"_techpro.png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver; //burada type casting yapıldı. yani driverın tipini değiştirdik, dönüştürdük (fotoğraf çekebilmesi için :) )

        Files.write(Paths.get(filePath),takesScreenshot.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    void takeSS() throws IOException {
        driver.get("https://www.google.com");

        //Ekran görüntüsünü alalim

        String date = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm").format(LocalDateTime.now());
        String filePath = "src\\test\\java\\screenshots\\"+ date +"_google.jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        Files.write(Paths.get(filePath),takesScreenshot.getScreenshotAs(OutputType.BYTES));
    }
}
