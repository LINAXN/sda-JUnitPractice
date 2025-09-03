package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_01 {
//    Task 1: Browser History Exploration
//    Setup:
//    Use @BeforeEach to launch Chrome and maximize.
//    Test 1:
//    Navigate to https://www.wikipedia.org/.
//    Navigate to https://www.google.com/.
//    Navigate back and forward multiple times, asserting the correct title at each step.
//    Test 2:
//    Use driver.navigate().refresh() on Google and assert the title still contains "Google".
//    Teardown:
//    Use @AfterEach to close the browser.

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    void test1() throws InterruptedException {
        driver.navigate().to("https://www.wikipedia.org/");
        driver.navigate().to("https://www.google.com/");

        Thread.sleep(2000);
        driver.navigate().back();
        Assertions.assertEquals("Wikipedia", driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().forward();
        Assertions.assertEquals("Google", driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();
        Assertions.assertEquals("Wikipedia", driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().forward();
        Assertions.assertEquals("Google", driver.getTitle());
    }


    @Test
    void test2() throws InterruptedException {

        driver.navigate().to("https://www.google.com/");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Assertions.assertTrue(driver.getTitle().contains("Google"));

    }


    @AfterEach
    void CloseTask01() {
        driver.quit();
    }
}
