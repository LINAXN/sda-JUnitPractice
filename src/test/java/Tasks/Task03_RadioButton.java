package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task03_RadioButton {
    //        Question: Navigate to "
//        https://demoqa.com/radio-button". Create a test that:
//        Attempts to select each radio button (Yes, Impressive, No)
//        Prints whether each option is enabled/disabled

//        For enabled options, select them and verify selection
//    @Test
//    void radioButtonTest1() throws InterruptedException {
////        //input[@id='yesRadio']
//        WebElement radioButtonYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
//        WebElement radioButtonImpressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
//        WebElement radioButtonNo = driver.findElement(org.openqa.selenium.By.xpath("//label[@for='noRadio']"));
//        radioButtonYes.click();
//
//        System.out.println("Radio Button Yes is enabled: " + radioButtonYes.isSelected());
//        Thread.sleep(2000);
//        radioButtonImpressive.click();
//        System.out.println("Radio Button Impressive is enabled: " + radioButtonImpressive.isSelected());
//        Thread.sleep(2000);
//        radioButtonNo.click();
//        System.out.println("Radio Button No is enabled: " + radioButtonNo.isSelected());
//        Thread.sleep(2000);
//
//        //        Prints whether each option is enabled/disabled
//
////        For enabled options, select them and verify selection
//        System.out.println("Radio Button Yes is enabled: " + radioButtonYes.isEnabled());
//        System.out.println("Radio Button Impressive is enabled: " + radioButtonImpressive.isEnabled());
//        System.out.println("Radio Button No is enabled: " + radioButtonNo.isEnabled());
//
//
//    }
@Test
void radioButtonTest1() throws InterruptedException {
        WebElement radioButtonYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement radioButtonImpressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement radioButtonNo = driver.findElement(org.openqa.selenium.By.xpath("//input[@id='noRadio']"));


    // Yes button
    if (radioButtonYes.isEnabled()) {
        radioButtonYes.click();
        System.out.println("Yes button is enabled and selected: " + radioButtonYes.isEnabled());
    } else {
        System.out.println("Yes button is disabled.");
    }
    Thread.sleep(2000);

    // Impressive button
    if (radioButtonImpressive.isEnabled()) {
        radioButtonImpressive.click();
        System.out.println("Impressive button is enabled and selected: " + radioButtonImpressive.isEnabled());
    } else {
        System.out.println("Impressive button is disabled.");
    }
    Thread.sleep(2000);

    // No button
    if (radioButtonNo.isEnabled()) {
        radioButtonNo.click();
        System.out.println("No button is enabled and selected: " + radioButtonNo.isEnabled());
    } else {
        System.out.println("No button is disabled.");
    }
    Thread.sleep(2000);
}


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();


    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
