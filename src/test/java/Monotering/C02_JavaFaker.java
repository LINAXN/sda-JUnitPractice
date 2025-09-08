package Monotering;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JavaFaker {
    WebDriver driver;

    @Test
    void javaFakerTest() {
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.printf("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
        System.out.printf("PASSWORD: " + faker.internet().password(5, 10, true, true, true) + "\n");
        System.out.println("faker.company().name() = " + faker.company().name());
        System.out.println("faker.date().birthday() = " + faker.date().birthday());
        driver.findElement(By.name("username")).sendKeys(faker.name().username());
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys(faker.instance().lorem().paragraph(30));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

//

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        // Go to https://the-internet.herokuapp.com/checkboxes
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterEach
//    void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }
}