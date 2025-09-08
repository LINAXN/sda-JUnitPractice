package ElementTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C04_RelativeLocator {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
@Test
    void relativeLocatorTest() {
        driver.get("https://clarusway.com/");
    WebElement cyberSecurity = driver.findElement(By.xpath("//a/span/span[.='Cybersecurity']"));
    driver.findElement(RelativeLocator.with(By.tagName("span")).toLeftOf(cyberSecurity));
    System.out.println("driver.getTitle() = " + driver.getTitle());

    }
}
