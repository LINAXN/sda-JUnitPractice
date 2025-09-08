package Tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task05_DynamicListManagement {
//    Question: Go to "
//    http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
//    Uses Faker to generate 5 random task names
//    Adds all tasks to the todo list
//    Marks every other task as completed (strikethrough)
//    Deletes all completed tasks
//    Verifies only incomplete tasks remain

    WebDriver driver;
    @Test
    void dynamicListManagementTest() {
        Faker faker= new Faker();
        for (int i = 0; i < 5; i++) {
            String taskName = faker.lorem().word();
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys(taskName, Keys.ENTER);
        }
        for (int i = 1; i <=5 ; i+=1) {
            driver.findElement(By.xpath("(//li)["+i+"]")).click();
        }

    }
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

////i[@class='fa fa-trash']

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }

}
