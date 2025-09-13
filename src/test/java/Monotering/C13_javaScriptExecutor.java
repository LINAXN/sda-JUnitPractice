package Monotering;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.JSUtils;
import utillties.TestBase;

public class C13_javaScriptExecutor extends TestBase {
    /*
        Go to https://claruswaysda.github.io/form.html
        Create a method to flash the elements you are working on and use it.
        Register a user
        Login
        Celebrate the login!
    */

    @Test
    void javaScriptExecutorTest() throws InterruptedException {
//        Go to
        driver.get("https://claruswaysda.github.io/form.html");

//        Create a method to flash the elements you are working on and use it.
        WebElement ssn = driver.findElement(By.id("ssn"));
        JSUtils.flash(ssn,driver,"blue");
//        Register a user

//        Login

//        Celebrate the login !

    }
}