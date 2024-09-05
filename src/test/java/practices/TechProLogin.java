package practices;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TechProLogin {

    @Test
    void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://lms.techproeducation.de/login/index.php");

        Thread.sleep(2000);

        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(2000);

        driver.findElement(By.id("loginbtn")).click();

        Thread.sleep(3000);

        driver.findElement(By.linkText("Kurslarım")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@data-course-id = '10']/a")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='courseindexcollapse2']//a")).click();

        Thread.sleep(2000);

    }


}

