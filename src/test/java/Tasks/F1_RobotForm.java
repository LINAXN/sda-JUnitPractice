package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class F1_RobotForm extends TestBase {
    @Test
    void robotTest() throws AWTException, InterruptedException {
        /*
 * Open a demo login page (e.g. ).
 * Click into the username field.
 * Type the username using sendKeys.
 * Use the Robot class to:
 * Press Tab → go to password field.
 * Type the password using sendKeys.
 * Press Enter → submit the form.
 * Verify login success or error message.
 *

         */
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        Thread.sleep(3000);

        WebElement password = driver.switchTo().activeElement();
        password.sendKeys("SuperSecretPassword!");

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement messages = driver.findElement(By.id("flash-messages"));
        System.out.println("message: " + messages.getText());






    }
}
