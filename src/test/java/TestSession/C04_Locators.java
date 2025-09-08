package TestSession;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Locators {
    WebDriver driver;
    @BeforeEach
    void setUp() {
      driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    void locatorsTest() {
driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");
WebElement p3 = driver.findElement(By.id("p3"));
        System.out.println(p3.getText());

        List<WebElement> elementCn = driver.findElements(By.className("normal"));
elementCn.forEach(eachElement-> System.out.println(eachElement.getText()));


}


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
