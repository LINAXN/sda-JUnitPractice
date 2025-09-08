package Tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Task01_Options {


    @Test
    void chromeOptionsTest() {
driver.get("https://www.example.com");
        Assertions.assertTrue(driver.getTitle().contains("Example"));


    }


    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("disable-extensions");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
