package Monotering;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C04_SeleinumWait {

@Test
void test01() {
    driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    driver.findElement(By.id("submit")).click();
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    String error = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error")))).getText();
//    String error = driver.findElement(By.id("error")).getText();
    System.out.println(error);
    assertEquals("Please enter at least 3 characters",error);
}

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}

