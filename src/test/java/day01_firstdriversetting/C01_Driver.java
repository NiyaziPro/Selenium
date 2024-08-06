package day01_firstdriversetting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C01_Driver {
    public static void main(String[] args) {

        /*
                ChromeDriver, Seleniumdan gelen komutlari alir ve bunlari Chrome'un anlayabileceği sekilde cevirir.
                Bunun icin java dan  System.setProperty() methodu ile Selenium'a ChromeDriver'in konumunu bildirerek
                ChromeBrowserin doğru bir sekilde baslatilmasini saglar.
         */

        System.setProperty("web.chrome.driver","drivers/chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options =new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.amazon.de");
        driver.quit();
    }
}
