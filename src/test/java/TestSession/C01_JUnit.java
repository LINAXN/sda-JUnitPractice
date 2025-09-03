package TestSession;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_JUnit {
    @Test @DisplayName("Test01")
    public void test01() {
        System.out.println("My First Junit Test");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        String ActualTitle = driver.getTitle();
        System.out.println("Title: "+ ActualTitle);
        Assertions.assertEquals("Amazon.com",ActualTitle);
    }

    @BeforeAll @DisplayName("Rololo")
    public static void setup(){
        System.out.println("Before All method");
//        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
    }
    @AfterAll
    public static void tearDown() {
        System.out.println("After All method");
    }
    @BeforeEach @Disabled

    public void beforeEach() {
        System.out.println("Before Each method");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("After Each method");
    //        driver.quit();
}
}
