package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utillties.TestBase;

public class D01_FormLogin extends TestBase {
     /*
 Go to https://claruswaysda.github.io/form.html
 Fill the form
 Login the app
 Celebrate the login
 */
    @Test
    void test01() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/form.html");
 driver.findElement(By.id("ssn")).sendKeys("1223456781");
        driver.findElement(By.id("first-name")).sendKeys("lina");
        driver.findElement(By.id("last-name")).sendKeys("alhumaidi");
        driver.findElement(By.id("address")).sendKeys("Qassim");
        driver.findElement(By.id("phone")).sendKeys("0555555555");
        driver.findElement(By.id("username")).sendKeys("Linaxxxx");
        driver.findElement(By.id("email")).sendKeys("Linaxn@gmail.com");
        driver.findElement(By.id("password")).sendKeys("fk;k392724");
        driver.findElement(By.id("confirm-password")).sendKeys("fk;k392724");
        driver.findElement(By.xpath("//button[@class='button']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//button[@class='login-button']")).click();

        driver.findElement(By.id("username")).sendKeys("Linaxxxx");
        driver.findElement(By.id("password")).sendKeys("fk;k392724");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);


        driver.findElement(By.id("clickMeButton")).click();


    }






    }

