package day14_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C05_ExtentReport {

    /*
    ExtentReport kullanabilmek icin 3 class a ihtiyac vardir.
    1) ExtentReports classindan raporlamayi baslatmak icin bir object olusturmamiz gerekir
    2) ExtentHtmlReporter classindan raporlari html formatinda olusturmasi icin object olusturmamiz gerekir
    3) ExtentTest classindan test adimlarina bilgi ekleyebilmek icin bir object olusturmamiz gerekir
     */

    ExtentReports extentReports; // raporlamayi baslatir
    ExtentHtmlReporter extentHtmlReporter; // raporlamayi html formatinda olusturur
    ExtentTest extentTest; // test adimlarina bilgi ekler

    @Test
    void extentReportTemplate() {
        extentReports=new ExtentReports();
        /*
        Oncelikle olusturmak istedigimz html reportu project imizde nerede saklamak istiyorsak bir dosya yolu
        olusturmaliyiz, cunku bu path i kullanarak bir tane html report olusturacağız
        bunun icin ExtentHtmlReporter classindan object olusturmaliyiz
         */

        String date = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm.ss").format(LocalDateTime.now());

        String path = "target\\extentReport\\htmlReport_" + date + ".html";

    }
}
