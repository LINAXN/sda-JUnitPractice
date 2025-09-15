package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.TestBase;

public class A01_UserRegistrationScreenshot extends TestBase {
    /*
 Go to
 Register a user
 Sign in with the registered user
 Take all pages' screenshots
 Take 'Celebrate Login' button's screenshot.
 Capture a screenshot of the page with confetti.
 */
    @Test
    void userscreenshot() throws InterruptedException {

        driver.get("https://claruswaysda.github.io/homepage.html");
        takeFullPageScreenshot();

        driver.findElement(By.className("user-icon")).click();
        driver.findElement(By.xpath("//a[.='Register']")).click();


        driver.findElement(By.id("ssn")).sendKeys("1223456781");
        driver.findElement(By.id("first-name")).sendKeys("lina");
        driver.findElement(By.id("last-name")).sendKeys("alhumaidi");
        driver.findElement(By.id("address")).sendKeys("Qassim");
        driver.findElement(By.id("phone")).sendKeys("0555555555");
        driver.findElement(By.id("username")).sendKeys("Linaxxxx");
        driver.findElement(By.id("email")).sendKeys("Linaxn@gmail.com");
        driver.findElement(By.id("password")).sendKeys("fk;k392724");
        driver.findElement(By.id("confirm-password")).sendKeys("fk;k392724");
takeFullPageScreenshot();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement successM = driver.findElement(By.className("success-message"));
        takeElementsScreenshot(successM);


        driver.findElement(By.xpath("//button[@class='login-button']")).click();
        takeFullPageScreenshot();

        driver.findElement(By.id("username")).sendKeys("Linaxxxx");
        driver.findElement(By.id("password")).sendKeys("fk;k392724");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);


     WebElement celebrate =   driver.findElement(By.id("clickMeButton"));

        celebrate.click();
        Thread.sleep(2000);
        takeFullPageScreenshot();

    }

}
