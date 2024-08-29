package day12_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

            //Go to https://testcenter.techproeducation.com/index.php?page=file-download
        //download b10 all test cases file
        //Test whether the file has been downloaded successfully

            //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        //b10 all test cases dosyasını indirelim
        //Dosyanın başarıyla indirilip indirilmediğini test edelim
    @Test
    void fileDownloadTest() {


        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases, code.docx")).click();
        waitForSecond(3);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //"C:\Users\TechPro\Downloads\b10 all test cases, code.docx"

        String dynamicPath = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));

    }

    @Test
    void fileDownloadTestDynamicWay() {

        String dynamicPath = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";

        //  Bu method eger belirtilen yolda dosya varsa siler, eger dosya yoksa yada silinemezse exception firlatir

        try {
            Files.delete(Paths.get(dynamicPath)); // her testimizin basinda dosya varmi diye manual olarak kontrol etmemiz yerine, gidip o dosyayi kontrol edecek
        } catch (IOException e) {
            System.err.println("Dosya silinemedi !!!");
        }

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases, code.docx")).click();
        waitForSecond(3);

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));

    }
}
