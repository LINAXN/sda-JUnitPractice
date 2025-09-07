package ElementTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_LoginTest {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testLogin() {
        driver.get("https://www.saucedemo.com/v1");
        // Add login test steps and assertions here
        WebElement username = driver.findElement(org.openqa.selenium.By.id("user-name"));
        System.out.println(username.isDisplayed() ? "Username field is displayed: PASSED" : "Username field is displayed: FAILED");
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce", Keys.ENTER);
//        driver.findElement(By.id("login-button")).click();
    }
//    @AfterAll
//    static void tearDown() {
//        driver.quit();  }
}
