package Tasks;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task_04 {

//    Task 4: Multiple Navigation and Verification
//    Setup:
//    Launch Chrome and maximize in @BeforeEach.
//            Test 1:
//    Navigate Google → YouTube → LinkedIn.
//    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
//            Test 2:
//    Navigate back twice and assert the URL of Google.
//    Navigate forward twice and assert URL of LinkedIn.
//            Teardown:
//    Use @AfterAll to quit the browser. (edited)
//

    static WebDriver driver;


    @BeforeEach
    void setup() {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }


    @Test
    void test1() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google'");
        Thread.sleep(2000);
        driver.navigate().to("https://www.youtube.com/");
        Assertions.assertTrue(driver.getTitle().contains("YouTube"), "Title does not contain 'YouTube'");
        Thread.sleep(2000);
        driver.navigate().to("https://www.linkedin.com/");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"), "Title does not contain 'LinkedIn'");
    }


    @Test
    void test2() throws InterruptedException {

        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().to("https://www.linkedin.com/");

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl(), "URL is not Google");

        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        Assertions.assertEquals("https://www.linkedin.com/", driver.getCurrentUrl(), "URL is not LinkedIn");
    }
    @AfterAll
    static void CloseTask04() {
        driver.quit();
    }
}
