package ElementTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_CssSelector {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void cssSelectorTest() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(By.cssSelector("#email")).sendKeys("johndoeSDA@yahoo.com");
        driver.findElement(By.cssSelector("input[placeholder='password']")).sendKeys("John.123");
        List<WebElement> welcomeMessage = driver.findElements(By.cssSelector(".welcome-message"));
        welcomeMessage.forEach(t -> System.out.println(t.getText()));
//        System.out.println("welcomeMessage = " + welcomeMessage);

    }
        /*
    http://the-internet.herokuapp.com/add_remove_elements/
    Click on the "Add Element" button 100 times.
    Write a function that takes a number, and clicks the "Delete" button.
    Given number of times, and then validates that given number of buttons was deleted.
    1. Method: createButtons(100)
    2. Method: DeleteButtonsAndValidate()
     */


    @Test
    void addelementTest() {
        driver.get(" http://the-internet.herokuapp.com/add_remove_elements/");

        createButtons(30);
        deleteButtonsAndValidate(40);
    }

    void createButtons(int number) {
        for (int i = 0; i < number; i++) {
            driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        }
    }

    void deleteButtonsAndValidate(int number) {
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        for (int i = 0; i < number; i++) {
            if (deleteButtons.size() > 0) {
                deleteButtons.get(0).click();
                deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
            }
        }
        int remainingButtons = deleteButtons.size();
        if (remainingButtons == (100 - number)) {
            System.out.println("Test PASSED: " + number + " buttons deleted successfully.");
        } else {
            System.out.println("Test FAILED: Expected " + (100 - number) + " buttons remaining, but found " + remainingButtons);
        }
    }
}

