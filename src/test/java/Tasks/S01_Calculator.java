package Tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class S01_Calculator {

    WebDriver driver;
    WebDriverWait wait;
    @Test
    void calculatorTest() {
        driver.get("https://testpages.eviltester.com/styled/calculator");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // إدخال الأرقام مرة واحدة
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");

        // تنفيذ جميع العمليات
        performOperation("plus", "15", wait);
        performOperation("minus", "5", wait);
        performOperation("times", "50", wait);
        performOperation("divide", "2", wait);
    }

    void performOperation(String operation, String expected, WebDriverWait wait) {
        // إعادة التقاط العناصر بعد كل عملية
        Select select = new Select(driver.findElement(By.id("function")));
        WebElement calculateButton = driver.findElement(By.id("calculate"));

        // اختيار العملية والضغط
        select.selectByValue(operation);
        calculateButton.click();

        // انتظار النت
    }
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
//
//    @Test
//    void calculatorTest() throws InterruptedException {
//        driver.get("https://testpages.eviltester.com/styled/calculator");
//
//        WebElement num1 = driver.findElement(By.id("number1"));
//        WebElement num2 = driver.findElement(By.id("number2"));
//        WebElement funcDropdown = driver.findElement(By.id("function"));
//        WebElement calculateButton = driver.findElement(By.id("calculate"));
//
//
//        num1.sendKeys("10");
//        num2.sendKeys("5");
//        Select select = new Select(funcDropdown);
//
//
//        select.selectByValue("plus");
//        calculateButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='answer']"), "15"));
//        String result= driver.findElement(By.xpath("//*[@id='answer']")).getText();
//        System.out.println("Addition result: " + result);
//        Assertions.assertEquals("15", result);
//
//        select = new Select(driver.findElement(By.id("function")));
//        select.selectByValue("minus");
//        calculateButton.click();
//        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='answer']"), "5"));
//        String result1= driver.findElement(By.xpath("//*[@id='answer']")).getText();
//        System.out.println("Addition result: " + result1);
//        Assertions.assertEquals("5", result1);
//
//        select = new Select(driver.findElement(By.id("function")));
//        select.selectByValue("times");
//        calculateButton.click();
//        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='answer']"), "50"));
//        String result2= driver.findElement(By.xpath("//*[@id='answer']")).getText();
//        System.out.println("Multiplication result: " + result2);
//        Assertions.assertEquals("50", result2);
//
//
//        select = new Select(driver.findElement(By.id("function")));
//        select.selectByValue("divide");
//        calculateButton.click();
//        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='answer']"), "2"));
//        String result3= driver.findElement(By.xpath("//*[@id='answer']")).getText();
//        System.out.println("Division result: " + result3);
//        Assertions.assertEquals("2", result3);


//            driver.get("https://testpages.eviltester.com/styled/calculator");
//
//            WebElement num1 = driver.findElement(By.id("number1"));
//            WebElement num2 = driver.findElement(By.id("number2"));
//            WebElement calculateButton = driver.findElement(By.id("calculate"));
//
//            num1.sendKeys("10");
//            num2.sendKeys("5");
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//            // Addition
//            Select select = new Select(driver.findElement(By.id("function")));
//            select.selectByValue("plus");
//            calculateButton.click();
//            wait.until(ExpectedConditions.textToBe(By.id("answer"), "15"));
//            String result = driver.findElement(By.id("answer")).getText();
//            System.out.println("Addition result: " + result);
//            Assertions.assertEquals("15", result);
//        Thread.sleep(1000);
//            // Subtraction
//            select = new Select(driver.findElement(By.id("function")));
//        Thread.sleep(1000);
//
//        select.selectByValue("minus");
//            calculateButton.click();
//            wait.until(ExpectedConditions.textToBe(By.id("answer"), "5"));
//            String result1 = driver.findElement(By.id("answer")).getText();
//            System.out.println("Subtraction result: " + result1);
//            Assertions.assertEquals("5", result1);
//        Thread.sleep(1000);
//
//            // Multiplication
//            select = new Select(driver.findElement(By.id("function")));
//            select.selectByValue("times");
//            calculateButton.click();
//            wait.until(ExpectedConditions.textToBe(By.id("answer"), "50"));
//            String result2 = driver.findElement(By.id("answer")).getText();
//            System.out.println("Multiplication result: " + result2);
//            Assertions.assertEquals("50", result2);
//        Thread.sleep(1000);
//
//            // Division
//            select = new Select(driver.findElement(By.id("function")));
//            select.selectByValue("divide");
//            calculateButton.click();
//            wait.until(ExpectedConditions.textToBe(By.id("answer"), "2"));
//            String result3 = driver.findElement(By.id("answer")).getText();
//            System.out.println("Division result: " + result3);
//            Assertions.assertEquals("2", result3);
//        }


    }

