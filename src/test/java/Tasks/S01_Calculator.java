package Tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class S01_Calculator {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void calculatorTest() {

        driver.get("https://testpages.eviltester.com/styled/calculator");


        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");

        //--------------------------------------------------

        WebElement funcDropdown = driver.findElement(By.id("function"));
        WebElement calculateButton = driver.findElement(By.id("calculate"));
        Select select = new Select(funcDropdown);

        select.selectByValue("plus");
        calculateButton.click();
        wait.until(ExpectedConditions.textToBe(By.id("answer"), "15"));
        String result = driver.findElement(By.id("answer")).getText();
        System.out.println("Addition result: " + result);
        Assertions.assertEquals("15", result);

        //--------------------------------------------------
        WebElement funcDropdown1 = driver.findElement(By.id("function"));
        WebElement calculateButton1 = driver.findElement(By.id("calculate"));
        Select select1 = new Select(funcDropdown1);

        select1.selectByValue("minus");
        calculateButton1.click();
        wait.until(ExpectedConditions.textToBe(By.id("answer"), "5"));
        String result1 = driver.findElement(By.id("answer")).getText();
        System.out.println("Subtraction result: " + result1);
        Assertions.assertEquals("5", result1);

        //--------------------------------------------------

        WebElement funcDropdown2 = driver.findElement(By.id("function"));
        WebElement calculateButton2 = driver.findElement(By.id("calculate"));
        Select select2 = new Select(funcDropdown2);

        select2.selectByValue("times");
        calculateButton2.click();
        wait.until(ExpectedConditions.textToBe(By.id("answer"), "50"));
        String result2 = driver.findElement(By.id("answer")).getText();
        System.out.println("Multiplication result: " + result2);
        Assertions.assertEquals("50", result2);

        //--------------------------------------------------

        WebElement funcDropdown3 = driver.findElement(By.id("function"));
        WebElement calculateButton3 = driver.findElement(By.id("calculate"));
        Select select3 = new Select(funcDropdown3);

        select3.selectByValue("divide");
        calculateButton3.click();
        wait.until(ExpectedConditions.textToBe(By.id("answer"), "2"));
        String result3 = driver.findElement(By.id("answer")).getText();
        System.out.println("Division result: " + result3);
        Assertions.assertEquals("2", result3);
    }
}
