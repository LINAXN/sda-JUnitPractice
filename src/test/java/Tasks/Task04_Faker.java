package Tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task04_Faker {
//    Question: Go to "
//    https://demoqa.com/text-box". Use Java Faker to:
//    Generate and enter a fake full name
//    Generate and enter a fake email address
//    Generate and enter a fake current address
//    Generate and enter a fake permanent address
//    Submit the form and verify the output contains the entered data

 WebDriver driver;
@Test
void fakerTest() {
    Faker faker = new Faker();
    String fullName = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().streetAddress();
    String permanentAddress = faker.address().fullAddress();
    driver.findElement(By.id("userName")).sendKeys(fullName);
    driver.findElement(By.id("userEmail")).sendKeys(email);
    driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
    driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
    driver.findElement(By.id("submit")).click();


WebElement output = driver.findElement(By.id("output"));
    String outputText = output.getText();

    assert outputText.contains(fullName) : "Full name not found in output";
    assert outputText.contains(email) : "Email not found in output";
    assert outputText.contains(currentAddress) : "Current address not found in output";
    assert outputText.contains(permanentAddress) : "Permanent address not found in output";






}

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }




}
