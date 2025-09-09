package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class S02_Clickable {
//    Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
////    Click "click me" button
////    Verify "Event Triggered" appears
    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    void clickableTest() {
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        wait.until(ExpectedConditions.attributeContains(By.id("growbutton"), "class", "grown"));

        WebElement clickMeButton = driver.findElement(By.id("growbutton"));
        clickMeButton.click();


        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("growbuttonstatus")));
        String statusText = result.getText();
        System.out.println("Status: " + statusText);

        Assertions.assertEquals("Event Triggered", statusText);
    }

}
