package Tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task05_DynamicListManagement {
//     Question: Go to "
//   1 http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
//   2 Uses Faker to generate 5 random task names
//   3 Adds all tasks to the todo list
//   4 Marks every other task as completed (strikethrough)
//   5 Deletes all completed tasks
//   6 Verifies only incomplete tasks remain

    WebDriver driver;
    @Test
    void dynamicListManagementTest() {
        //2
        Faker faker= new Faker();
        for (int i = 0; i < 5; i++) {
            String task = faker.lorem().sentence();
        WebElement Tasks  =  driver.findElement(By.xpath("//input[@type='text']"));
            Tasks.sendKeys(task, Keys.ENTER);}

        //3 4



        for (int i = 1; i <=5 ; i++) {
            driver.findElement(By.xpath("(//li)["+i+"]")).click();

        }
        List<WebElement> completedTasks  = driver.findElements(By.xpath("//li[@class='completed']"));
        for (WebElement completed: completedTasks) {
            completed.findElement(By.xpath(".//i[@class='fa fa-trash']")).click();
        }
List<WebElement> incompletedTasks  = driver.findElements(By.xpath("//li[not(@class='completed')]"));
        for (WebElement incompleted: incompletedTasks) {
            System.out.println("incompleted.getText() = " + incompleted.getText());
        }
        //5 6
    }
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
   // 1
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }

}
