package TestSession;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_XPath {
    static WebDriver driver;
    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void xpathTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton= driver.findElement(By.xpath("//button[.=' Login ']"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
}