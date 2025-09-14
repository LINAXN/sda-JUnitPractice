package TestSession;

import org.junit.jupiter.api.Test;
import utillties.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C32_RobotClass01 extends TestBase {
    @Test
    public void robotClassKeyboardTest1() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // This pause is given so that we can click on the script. Robot will write "sout" on the screen
        Thread.sleep(5000);

        robot.keyPress(KeyEvent.VK_S); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_S);

        robot.keyPress(KeyEvent.VK_O); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_U); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_U);

        robot.keyPress(KeyEvent.VK_T); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_T);

        robot.keyPress(KeyEvent.VK_ENTER); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Select All
        robot.keyPress(KeyEvent.VK_META); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_META);
        robot.delay(2000);

        // Copy the selected text
        robot.keyPress(KeyEvent.VK_META); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_META);
        robot.delay(2000);

        // Delete
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.delay(2000);

        // Paste the copied text
        robot.keyPress(KeyEvent.VK_META); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

    }

    @Test
    public void robotClassKeyboardTest2(){

    }
}
