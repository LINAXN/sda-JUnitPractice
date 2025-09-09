package Monotering;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C06_AjaxLoader {
    @Test
    void ajaxLoaderTest() {
//        Given: Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
 driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
//        When: Click on Ajax Loader
 driver.findElement(By.xpath("//a[@href='../Ajax-Loader/index.html']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clicableButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("btn1"))));


//        And: Click "Click Me!" button
WebElement   btn1=       driver.findElement(By.xpath("//p[.='CLICK ME!']"));
btn1.click();
//        Then: Assert button is clicked
//assertTrue("Click Me!".contains("Click Me!"));

    }


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);

    }}
