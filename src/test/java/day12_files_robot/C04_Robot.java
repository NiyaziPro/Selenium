package day12_files_robot;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C04_Robot extends TestBase {

    @Test
    void test01() throws AWTException {

        //driver.get("https://www.ilovepdf.com/compress_pdf");
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.delay(3000);
    }
}
