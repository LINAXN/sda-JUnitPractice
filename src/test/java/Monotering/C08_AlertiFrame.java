package Monotering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C08_AlertiFrame extends TestBase {
    @Test
    void test01() {
//        Go to https://claruswaysda.github.io/iframe.html
        driver.get("https://claruswaysda.github.io/iframe.html");
//        Type your name in input
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);   // تدخلي داخل الإطار
        driver.findElement(By.tagName("input")).sendKeys("Lina");


//        Click on 'Bold' button

        driver.switchTo().parentFrame();  // طلعي من الإطار
        driver.findElement(By.tagName("button")).click();
        String alertText = driver.switchTo().alert().getText();
        // Assert alert text contains the name
        // Accept alert
        driver.switchTo().alert().accept();
        assertEquals("Bold button clicked", alertText);

    }


}
