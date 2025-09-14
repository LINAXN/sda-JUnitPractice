package Monotering;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.JSUtils;
import utillties.TestBase;

public class C14_FlashBorder extends TestBase {
    @Test
    void flashBorderTest() {
//        Go to https://claruswaysda.github.io/signIn.html
        driver.get("https://claruswaysda.github.io/signIn.html");

        //        enter username 'admin'
        WebElement username = driver.findElement(By.id("username"));
        JSUtils.flashBorder(driver, username, "5px", "dashed", "red");
        username.sendKeys("admin");
//
        WebElement password = driver.findElement(By.id("password"));
        JSUtils.removeBorder(driver,password);
        password.sendKeys("123");
//        enter password '123'

//        Click on Sign In
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        JSUtils.flashBorder(driver, username, "5px", "soild", "red");
submit.submit();
//        Assert the 'Employee Table' is visible

//        Create a method to change border color and style of web elements.
//        Use the method on each element you interact with.

    }

}