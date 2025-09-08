package TestSession;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_LinkedInTest {

    @Test
void linkedInTest() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.name("session_password"));
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));

        System.out.println(username.isDisplayed() ? "Username field is displayed: PASSED" : "Username field is displayed: FAILED");
        System.out.println(password.isDisplayed() ? "Password field is displayed: PASSED" : "Password field is displayed: FAILED");
        System.out.println(signInButton.isDisplayed() ? "Sign In button is displayed: PASSED" : "Sign In button is displayed: FAILED");
        username.sendKeys("LINA");
        password.sendKeys("123456");
        signInButton.click();
        String mass = driver.findElement(By.id("error-for-username")).getText();
        Assertions.assertEquals("Please enter an email address or phone number", mass);
        System.out.println(mass);
    }


    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        // TODO: Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // TODO: Navigate to LinkedIn
        driver.get("https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2Flearning%2Fsearch%3Fkeywords%3D%26trk%3Dguest_homepage-basic_guest_nav_menu_learning&fromSignIn=true&trk=subs_learn_start");
    }
    @AfterAll
    static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}

