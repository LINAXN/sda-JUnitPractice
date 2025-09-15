package TestSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utillties.TestBase;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C35_DownloadFile extends TestBase {


        @Test
        void name() throws InterruptedException, IOException {
            String name = "Admin";
            String password = "admin123";
            //Go to URL: https://opensource-demo.orangehrmlive.com/
            driver.get("https://opensource-demo.orangehrmlive.com/");

            //Login page valid credentials.
            driver.findElement(By.xpath("//*[@name='username']")).sendKeys(name);
            driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//*[@type='submit']")).click();

            //Click PIM on the left side bar
            driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();
            driver.findElement(By.className("oxd-topbar-body-nav-tab-item")).click();
            driver.findElement(By.xpath("//a[.='Data Import']")).click();

            Files.deleteIfExists(Path.of(System.getProperty("user.home"),"Downloads","importData.csv"));
            driver.findElement(By.className("download-link")).click();
            //Click Configuration and select Data Import
            //Download sample CSV file.
            //Verify if the file downloaded successfully.
            Thread.sleep(3000);
            Assertions.assertTrue(Files.exists(Path.of(System.getProperty("user.home"),"Downloads","importData.csv")));
        }
    }

