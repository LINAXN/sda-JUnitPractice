package Tasks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_03 {
//    Task 3: Browser Size and Position
//    Setup:
//    Open Chrome in @BeforeEach.
//            Test 1:
//    Navigate to https://www.bbc.com/.
//    Set browser size to 800x600 and assert the window size.
//            Test 2:
//    Move the window to position (100, 100) and assert its position.
//    Teardown:
//    Close the browser.
    static WebDriver driver;
    @BeforeEach
    void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    void test1() {
        driver.get("https://www.bbc.com/");
//        int hight = driver.manage().window().getSize().getHeight();
//        int width = driver.manage().window().getSize().getWidth();
        driver.manage().window().setSize(new Dimension(800,600));
        Dimension windowSize = driver.manage().window().getSize();
        Assertions.assertEquals(800, windowSize.getWidth(), "Width is not 800");
        Assertions.assertEquals(600, windowSize.getHeight(), "Height is not 600");
    }

    @Test
    void test2() {
        driver.manage().window().setPosition(new Point(100,100));
        Point windowPosition = driver.manage().window().getPosition();
        Assertions.assertEquals(100, windowPosition.getX(), "X position is not 100");
        Assertions.assertEquals(100, windowPosition.getY(), "Y position is not 100");
    }

    @AfterAll
    static void CloseTask03() {
        driver.quit();
    }

}
