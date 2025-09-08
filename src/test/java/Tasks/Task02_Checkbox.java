package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task02_Checkbox {
//    Question: Go to "
//    https://the-internet.herokuapp.com/checkboxes". Write a method that:
//  Checks the current state of both checkboxes
//    Ensures both checkboxes are selected (click only if not already selected)
//  Verify both checkboxes are checked after the operations
//    Print the status of each checkbox to console
@Test
   void checkBoxTest1(){
    WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
    WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

    if (!checkBox1.isSelected()) {
        checkBox1.click();
    }

    if (!checkBox2.isSelected()) {
        checkBox2.click();
    }

    assert checkBox1.isSelected();
    assert checkBox2.isSelected();

    System.out.println("Checkbox 1 is selected: " + checkBox1.isSelected());
    System.out.println("Checkbox 2 is selected: " + checkBox2.isSelected());

}

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();


    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }

}