package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class C04_OldStyle {
//    Launch browser
//    Open https://demoqa.com/select-menu
//    Select Old Style Select Menu using element id
//    Print all dropdown options
//    Select 'Purple' using index
//    Select 'Magenta' using visible text
//    Select an option using value
//    Close browser
    WebDriver  driver;
    @Test
    void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement Oldstyle = driver.findElement(By.id("oldSelectMenu")) ;

        List<WebElement> options = Oldstyle.findElements(By.tagName("option"));
        options.forEach(option -> System.out.println(option.getText()));

        Select select = new Select(Oldstyle);
Thread.sleep(2000);
        select.selectByIndex(4);
        Thread.sleep(2000);
        select.selectByVisibleText("Magenta");
        Thread.sleep(2000);
        select.selectByValue("10");

    }

        @BeforeEach
        void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }
    }

